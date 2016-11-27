package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ProfessorDAO;
import br.edu.ifsul.modelo.Professor;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Joel Zatti joelzatti@gmail.com
 */
@ManagedBean(name = "controleProfessor")
@SessionScoped
public class ControleProfessor implements Serializable {

    private ProfessorDAO dao;
    private Professor objeto;

    public ControleProfessor() {
        dao = new ProfessorDAO();
    }

    public String listar() {
        return "/privado/professor/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Professor();
        return "formulario";
    }

    public String salvar() {
        if (dao.persist(objeto)) {
            UtilMensagens.mensagemInformacao(dao.getMensagem());
            return "listar";
        } else {
            UtilMensagens.mensagemErro(dao.getMensagem());
            return "formulario";
        }
    }

    public String editar(Integer id) {
        objeto = (Professor) dao.localizar(id);
        return "formulario";
    }

    public void remover(Integer id) {
        objeto = (Professor) dao.localizar(id);
        if (dao.remove(objeto)) {
            UtilMensagens.mensagemInformacao(dao.getMensagem());
        } else {
            UtilMensagens.mensagemErro(dao.getMensagem());
        }
    }

    public String cancelar() {
        objeto = null;
        return "listar";
    }

    public ProfessorDAO getDao() {
        return dao;
    }

    public void setDao(ProfessorDAO dao) {
        this.dao = dao;
    }

    public Professor getObjeto() {
        return objeto;
    }

    public void setObjeto(Professor objeto) {
        this.objeto = objeto;
    }

}
