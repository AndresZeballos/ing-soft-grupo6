/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios;

/**
 *
 * @author Fede
 */
public interface IPerfilUsuario {
    boolean validarAcceso(String componente);
    boolean tieneComponente(String componente);
}
