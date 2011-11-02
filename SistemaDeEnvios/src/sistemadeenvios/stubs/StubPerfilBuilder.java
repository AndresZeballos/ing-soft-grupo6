/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.logic.IPerfilUsuario;

/**
 *
 * @author agustin
 */


public class StubPerfilBuilder implements IPerfilBuilder {
    //Nombres de perfiles stub
    final String perfilConsultor = "consultor";
    final String perfilAdministrador = "administrador";
    final String perfilFuncionario = "funcionario";

    public boolean existePerfil(String perfilName) {
        boolean existe = false;
        existe = existe || perfilConsultor.equalsIgnoreCase(perfilName);
        existe = existe || perfilAdministrador.equalsIgnoreCase(perfilName);
        existe = existe || perfilFuncionario.equalsIgnoreCase(perfilName);
        return existe;
    }

    public IPerfilUsuario getPerfil(String perfilName) {
        if (perfilName.equalsIgnoreCase(perfilAdministrador)) {
            return new StubPerfilAdministrador();
        } else if (perfilName.equalsIgnoreCase(perfilFuncionario)) {
            return new StubPerfilFuncionario();
        } else /* if (userName.equalsIgnoreCase("consultor")) */ {
            return new StubPerfilConsultar();
        }
    }
    
    public boolean crearPerfil(String perfilName)
    {
        boolean creacion = false;
        if (!existePerfil(perfilName))
        {
            creacion = true;
        }
        return creacion;
    }
    public boolean borrarPerfil(String perfilName)
    {
        boolean borrar = false;
        if (existePerfil(perfilName))
        {
            borrar = true;
        }
        return borrar;
    }
    public boolean modificarPerfil(String perfilName, ArrayList<String> permisos)
    {
        boolean modificar = false;
        if (existePerfil(perfilName))
        {
            modificar = true;
            String permiso;
            IPerfilUsuario perfil = getPerfil(perfilName);
            perfil.borrarTodo();
            for(Object objPermiso : permisos)
            {
                permiso = (String)objPermiso;
                perfil.agregarAcceso(permiso);
            }
        }

        return modificar;
    }
}
