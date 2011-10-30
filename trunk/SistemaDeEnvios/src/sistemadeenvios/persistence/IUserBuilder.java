/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.persistence;

import java.util.ArrayList;
import sistemadeenvios.logic.IUsuario;
import java.sql.SQLException;

/**
 *
 * @author agustin
 */
public interface IUserBuilder {
    String getUserName(String userName) throws SQLException;
    String getPassword(String userName) throws SQLException;
    ArrayList<IPerfilBuilder> getPerfiles(String userName) throws SQLException;
    void crearUsuario(String userName, String password,
                      ArrayList<String> perfiles) throws SQLException;
    void borrarUsuario(String userName) throws SQLException;
    void modificarUsuario(String userName, String password,
                          ArrayList<String> perfiles) throws SQLException;
}
