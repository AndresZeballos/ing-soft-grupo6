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
    boolean validarAcceso(String componente);
    void agregarAcceso(String nombreComponente, boolean permitirAcesso);
    boolean tieneComponente(String componente);
}
