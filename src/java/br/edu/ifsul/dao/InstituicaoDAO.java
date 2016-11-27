package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Instituicao;
import java.io.Serializable;

/**
 *
 * @author Joel Zatti joelzatti@gmail.com
 */
public class InstituicaoDAO<T> extends DAOGenerico<Instituicao> implements Serializable {

    public InstituicaoDAO() {
        super();
        super.setClassePersistente(Instituicao.class);
        super.setOrdem("nome");
    }
}
