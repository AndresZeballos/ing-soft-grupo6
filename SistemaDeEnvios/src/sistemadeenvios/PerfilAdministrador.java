/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios;

/**
 *
 * @author Fede
 */
public class PerfilAdministrador implements IPerfilUsuario{
    public boolean ValidarAcceso(String componente)
    {
        return true;
    }
    public boolean TieneComponente(String componente)
    {
        return true;
    }
}
