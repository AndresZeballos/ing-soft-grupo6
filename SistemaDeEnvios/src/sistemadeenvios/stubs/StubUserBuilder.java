/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.persistence.IUserBuilder;

/*
 * @author Fede
 */
public class StubUserBuilder implements IUserBuilder {

    public boolean existeUserName(String userName) {
        return true;
    }

    public String getPassword(String userName) {
        return userName;
    }

    public ArrayList<IPerfilUsuario> getPerfiles(String userName) {
        IPerfilBuilder pb = new StubPerfilBuilder();
        ArrayList<String> perfiles = new ArrayList<String>();
        ArrayList<IPerfilUsuario> listaPerfiles = new ArrayList<IPerfilUsuario>();
        // Cargo los nombres de los perfiles
        if (userName.equalsIgnoreCase("admin")) {
            perfiles.add("administrador");
        } else if (userName.equalsIgnoreCase("funcionario")) {
            perfiles.add("funcionario");
        } else /* if (userName.equalsIgnoreCase("consultor")) */ {
            perfiles.add("consultor");
        }
        // Cargo los perfiles por su nombre
        for(String perfil: perfiles){
            if(pb.existePerfil(perfil)){
                listaPerfiles.add(pb.getPerfil(perfil));
            }
        }
        return listaPerfiles;
    }

    public boolean crearUsuario(String userName, String password,
            ArrayList<String> perfiles) {
        return true;
    }

    public boolean borrarUsuario(String userName) {
        return true;
    }

    public boolean modificarUsuario(String userName, String password,
            ArrayList<String> perfiles) {
        return true;
    }
}
