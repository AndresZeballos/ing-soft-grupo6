/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.persistence;

import sistemadeenvios.logic.IPerfilUsuario;

/**
 *
 * @author agustin
 */
public interface IPerfilBuilder {
    //String getPerfilName();

    boolean existePerfil(String perfilName);

    IPerfilUsuario getPerfil(String perfilName);
}
