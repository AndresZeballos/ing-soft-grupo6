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
public interface IPerfilBuilder {
    //String getPerfilName();

    boolean existePerfil(String perfilName);
    boolean crearPerfil(String perfilName, ArrayList<String> permisos);
    boolean borrarPerfil(String perfilName);
    boolean modificarPerfil(String perfilName, ArrayList<String> permisos);
    IPerfilUsuario getPerfil(String perfilName);
}
