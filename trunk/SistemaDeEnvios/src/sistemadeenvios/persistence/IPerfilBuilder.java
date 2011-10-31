/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.persistence;

import java.util.ArrayList;

/**
 *
 * @author agustin
 */
public interface IPerfilBuilder {
    //String getPerfilName();
    boolean existePerfil(String perfilName);
    ArrayList<String> getPermisos(String perfilName);
}
