/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.stubs;

import java.util.ArrayList;

/**
 *
 * @author Fede
 */
public class StubPerfilConsultar implements sistemadeenvios.IPerfilUsuario{
    ArrayList<String> componentes;
    public StubPerfilConsultar()
    {
        this.componentes = new ArrayList<String>();
        this.componentes.add("actualizarUsuario");
    }
    public boolean validarAcceso(String componente)
    {
        return true;
    }
    public boolean tieneComponente(String componente)
    {
        return componente.equalsIgnoreCase("ConsultarEnvio");
    }
}
