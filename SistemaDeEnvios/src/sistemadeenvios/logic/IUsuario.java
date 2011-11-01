/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

/**
 *
 * @author Andres
 */
public interface IUsuario {
    boolean validarAcceso(String componente);
    boolean validarPassword(String password);
    String getUserName();
    boolean addPerfil(String perfilUsuario);
    boolean crearUsuario();
    boolean borrarUsuario();
    boolean modificarUsuario();
}
