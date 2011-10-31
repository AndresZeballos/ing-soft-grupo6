/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.persistence;

import java.util.ArrayList;
import sistemadeenvios.logic.IPerfilUsuario;

/**
 *
 * @author agustin
 */
public interface IUserBuilder {
    boolean existeUserName(String userName);
    String getPassword(String userName);
    ArrayList<IPerfilUsuario> getPerfiles(String userName);
    void crearUsuario(String userName, String password,
                      ArrayList<String> perfiles);
    void borrarUsuario(String userName);
    void modificarUsuario(String userName, String password,
                          ArrayList<String> perfiles);
}
