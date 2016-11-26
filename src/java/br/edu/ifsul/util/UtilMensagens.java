
package br.edu.ifsul.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joel Zatti
 * joelzatti@gmail.com
 */
public class UtilMensagens {
    public  static void mensagemInformacao(String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    public  static void mensagemErro(String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

}
