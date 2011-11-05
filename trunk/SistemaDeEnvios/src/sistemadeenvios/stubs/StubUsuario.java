/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.persistence.IPerfilBuilder;

/**
 *
 * @author Andres
 */
public class StubUsuario implements IUsuario {

    private ArrayList<IPerfilUsuario> listaPerfiles;
    private String userName, password;

    public StubUsuario(String userName) {
        this.userName = userName;
        this.password = userName;
        this.listaPerfiles = new ArrayList<IPerfilUsuario>();
        this.listaPerfiles.add(StubPerfilBuilder.getInstance().getPerfil(userName));
    }

    public boolean validarAcceso(String componente) {
        boolean permitirAcceso = true;
        boolean containsAcceso = false;
        for (IPerfilUsuario p : this.listaPerfiles) {
            if (p.tieneComponente(componente)) {
                containsAcceso = true;
                permitirAcceso = permitirAcceso && p.validarAcceso(componente);
            }
        }
        if (!containsAcceso) {
            permitirAcceso = false;
        }
        return permitirAcceso;
    }

    public boolean validarPassword(String password) {
        if (this.password == null) {
            return false;
        }
        return this.password.equals(password);
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<IPerfilUsuario> getListaPerfiles() {
        return listaPerfiles;
    }

    public boolean addPerfil(String perfilUsuario) {
        IPerfilBuilder perfilBuilder = StubPerfilBuilder.getInstance();
        if (perfilBuilder.existePerfil(perfilUsuario)) {
            IPerfilUsuario perfil = perfilBuilder.getPerfil(perfilUsuario);
            Boolean contiene = false;
            for (IPerfilUsuario p : listaPerfiles) {
                if (p.getPerfilName().equals(perfil.getPerfilName())) {
                    contiene = true;
                    break;
                }
            }
            if (!contiene) {
                this.listaPerfiles.add(perfil);
                return true;
            }
        }
        return false;
    }

    public boolean crearUsuario() {
        return true;
    }

    public boolean borrarUsuario() {
        return true;
    }

    public boolean modificarUsuario() {
        return true;
    }

    public void borrarPerfiles() {
        for (int i = 0; i < this.listaPerfiles.size(); i++) {
            this.listaPerfiles.remove(i);
        }
    }
}
