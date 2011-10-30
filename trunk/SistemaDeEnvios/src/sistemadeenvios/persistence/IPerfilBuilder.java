/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agustin
 */
public interface IPerfilBuilder {
    String getPerfilName() throws SQLException;
    boolean existePerfil(String perfilName) throws SQLException;
    ArrayList<String> getPermisos(String perfilName) throws SQLException;
}
