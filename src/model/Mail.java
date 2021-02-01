package model;

/**
 * Separa una cadena con una dirección de email y 
 * la correspondiente subcadena con el dominio.
 * 
 * @author angel
 */
public class Mail {
    
    private String mail;
    
    public Mail(String mail){
        this.mail = mail;
    }
    
    public String getDomain(){
        return mail.substring(mail.indexOf('@')+1);
    }
}
