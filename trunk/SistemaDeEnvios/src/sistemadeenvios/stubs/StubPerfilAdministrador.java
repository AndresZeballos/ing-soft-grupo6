/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.logic.IPerfilUsuario;

/**
 *
 * @author Fede
 */
public class StubPerfilAdministrador implements IPerfilUsuario{
    public String getPerfilName()
    {
        return "administrador";
    }
    public boolean validarAcceso(String componente)
    {
        return true;
    }
    public boolean tieneComponente(String componente)
    {
        return true;
    }
    public void agregarAcceso(String nombreComponente)
    {
    }
    public void borrarPermisosPerfil()
    {}
    public boolean crearPerfil() {return true; }
    public boolean modificarPerfil(){return true; }
    public boolean borrarPerfil(){return true; }

    public ArrayList<String> getPermisos() {
        ArrayList<String> posibles = new ArrayList<String>();
        posibles.add("NuevoEnvio");
        posibles.add("ConsultarEnvio");
        posibles.add("NuevoUsuario");
        posibles.add("ActualizarUsuario");
        posibles.add("EliminarUsuario");
        posibles.add("NuevoPerfil");
        posibles.add("ActualizarPerfil");
        posibles.add("EliminarPerfil");
        return posibles;
    }
}
