package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CursoDAO;
import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.dao.InstituicaoDAO;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Joel Zatti joelzatti@gmail.com
 */
@ManagedBean(name = "controleCurso")
@SessionScoped
public class ControleCurso implements Serializable {

    private CursoDAO<Curso> dao;
    private Curso objeto;
    private DisciplinaDAO<Disciplina> DisciplinaDAO;
    private Disciplina disciplina;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    private Boolean novaDisciplina;
    private InstituicaoDAO<Instituicao> instituicaoDAO;
    
    public void novaDisciplina(){
        disciplina = new Disciplina();
        novaDisciplina = true;
    }
    public void alterarDisciplina(int index){
        disciplina = objeto.getDisciplina().get(index);
        setNovaDisciplina((Boolean) false);
    }
    public void removerDisciplina(int index){
        objeto.removerDisciplina(index);
        UtilMensagens.mensagemInformacao("Disciplina removida com sucesso!");
    }
    public void salvarDisciplina(){
        if(novaDisciplina){
            objeto.adicionarDisciplina(disciplina);       
        }
         UtilMensagens.mensagemInformacao("Operação executada com sucesso!");
    }
    
    public ControleCurso() {
        dao = new CursoDAO<>();
        DisciplinaDAO = new DisciplinaDAO<>();
        instituicaoDAO = new InstituicaoDAO<>();
    }

    public String listar() {
        return "/privado/curso/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Curso();
    }

    public void salvar() {
        boolean persistiu;
        if (objeto.getId() == null){
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu) {
            UtilMensagens.mensagemInformacao(dao.getMensagem());
        } else {
            UtilMensagens.mensagemErro(dao.getMensagem());
        }
    }

    public void editar(Integer id) {
        objeto = dao.localizar(id);
    }

    public void remover(Integer id) {
        objeto = dao.localizar(id);
        if (dao.remove(objeto)) {
            UtilMensagens.mensagemInformacao(dao.getMensagem());
        } else {
            UtilMensagens.mensagemErro(dao.getMensagem());
        }
    }
    
    public CursoDAO<Curso> getDao() {
        return dao;
    }

    public void setDao(CursoDAO<Curso> dao) {
        this.dao = dao;
    }

    public Curso getObjeto() {
        return objeto;
    }

    public void setObjeto(Curso objeto) {
        this.objeto = objeto;
    }   

    public DisciplinaDAO<Disciplina> getDisciplinaDAO() {
        return DisciplinaDAO;
    }

    public void setDisciplinaDAO(DisciplinaDAO<Disciplina> DisciplinaDAO) {
        this.DisciplinaDAO = DisciplinaDAO;
    }

    public Boolean getNovaDisciplina() {
        return novaDisciplina;
    }

    public void setNovaDisciplina(Boolean novaDisciplina) {
        this.novaDisciplina = novaDisciplina;
    }

    public InstituicaoDAO<Instituicao> getInstituicaoDAO() {
        return instituicaoDAO;
    }

    public void setInstituicaoDAO(InstituicaoDAO<Instituicao> instituicaoDAO) {
        this.instituicaoDAO = instituicaoDAO;
    }

}
