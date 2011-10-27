/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios;

/**
 *
 * @author Andres
 */
public interface IUsuario {
    public boolean validarAcceso(String componente);
    public boolean validarPassword(String password);
    public String getUserName();
}
