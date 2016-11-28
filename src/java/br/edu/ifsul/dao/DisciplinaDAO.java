
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Curso;
import java.io.Serializable;

/**
 *
 * @author Joel Zatti
 * joelzatti@gmail.com
 */
public class DisciplinaDAO<T> extends DAOGenerico<Curso> implements Serializable{
    public DisciplinaDAO(){
        super();
        super.setClassePersistente(Curso.class);
        super.setOrdem("id");
    }
}
