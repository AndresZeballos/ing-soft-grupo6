/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

import java.util.ArrayList;

/**
 *
 * @author Fede
 */
public interface IPerfilUsuario {
    String getPerfilName();
    ArrayList<String> getPermisos();
    boolean validarAcceso(String componente);
    void agregarAcceso(String nombreComponente);
    boolean tieneComponente(String componente);
    void borrarPermisosPerfil();
    boolean crearPerfil();
    boolean modificarPerfil();
    boolean borrarPerfil();
}

