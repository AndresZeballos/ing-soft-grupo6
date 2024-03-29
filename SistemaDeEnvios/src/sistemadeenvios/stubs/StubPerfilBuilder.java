/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.ArrayList;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.logic.PerfilUsuario;

/**
 *
 * @author agustin
 */
public class StubPerfilBuilder implements IPerfilBuilder {
    //Nombres de perfiles stub

    private static StubPerfilBuilder INSTANCE;
    final String perfilConsultor = "consultor";
    final String perfilAdministrador = "administrador";
    final String perfilFuncionario = "funcionario";
    private Hashtable hashPerfiles;

    public static StubPerfilBuilder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StubPerfilBuilder();
        }
        return INSTANCE;
    }

    private StubPerfilBuilder() {
        this.hashPerfiles = new Hashtable();
        this.hashPerfiles.put(perfilConsultor, new StubPerfilConsultar());
        this.hashPerfiles.put(perfilAdministrador, new StubPerfilAdministrador());
        this.hashPerfiles.put(perfilFuncionario, new StubPerfilFuncionario());
    }

    public boolean existePerfil(String perfilName) {
        return this.hashPerfiles.containsKey(perfilName);
    }

    public IPerfilUsuario getPerfil(String perfilName) {
        IPerfilUsuario perfil = (IPerfilUsuario) this.hashPerfiles.get(perfilName);
        return perfil;
    }

    public boolean crearPerfil(String perfilName, ArrayList<String> permisos) {
        boolean creacion = false;
        if (!existePerfil(perfilName)) {
            creacion = true;
            PerfilUsuario perfil = new PerfilUsuario(perfilName.toLowerCase());
            for (String permiso : permisos) {
                perfil.agregarAcceso(permiso);
            }
            this.hashPerfiles.put(perfilName, perfil);
        }
        return creacion;
    }

    public boolean borrarPerfil(String perfilName) {
        boolean borrar = false;
        if (existePerfil(perfilName) && !perfilName.equalsIgnoreCase(perfilAdministrador)) {
            borrar = true;
            this.hashPerfiles.remove(perfilName);
        }
        return borrar;
    }

    public boolean modificarPerfil(String perfilName, ArrayList<String> permisos) {
        boolean modificar = false;
        if (existePerfil(perfilName) && !perfilName.equalsIgnoreCase(perfilAdministrador)) {
            modificar = true;
            IPerfilUsuario perfil = getPerfil(perfilName);
            for (String permiso : permisos) {
                perfil.agregarAcceso(permiso);
            }
        }
        return modificar;
    }
}
