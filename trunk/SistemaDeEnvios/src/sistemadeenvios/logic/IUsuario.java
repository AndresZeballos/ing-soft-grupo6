/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public interface IUsuario {
    boolean validarAcceso(String componente);
    boolean validarPassword(String password);
    String getUserName();
    ArrayList<IPerfilUsuario> getListaPerfiles();
    boolean addPerfil(String perfilUsuario);
    void borrarPerfiles();
    boolean crearUsuario();
    boolean borrarUsuario();
    boolean modificarUsuario();
}
