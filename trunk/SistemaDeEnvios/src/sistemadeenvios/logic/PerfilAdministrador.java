/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

/**
 *
 * @author Fede
 */
public class PerfilAdministrador implements IPerfilUsuario{
    public String getPerfilName()
    {
        return "admin";
    }
    public boolean validarAcceso(String componente)
    {
        return true;
    }
    public boolean tieneComponente(String componente)
    {
        return true;
    }
    public void agregarAcceso(String nombreComponente, boolean permitirAcesso)
    {
    }
}
