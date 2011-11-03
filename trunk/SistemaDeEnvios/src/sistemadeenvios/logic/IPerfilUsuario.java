/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

/**
 *
 * @author Fede
 */
public interface IPerfilUsuario {
    String getPerfilName();
    boolean validarAcceso(String componente);
    void agregarAcceso(String nombreComponente);
    boolean tieneComponente(String componente);
    void borrarTodo();
    boolean crearPerfil();
    boolean modificarPerfil();
    boolean borrarPerfil();
}

