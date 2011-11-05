/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import java.util.ArrayList;
import java.util.Hashtable;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.logic.Usuario;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.persistence.IUserBuilder;

/*
 * @author Fede
 */
public class StubUserBuilder implements IUserBuilder {

    final String usuarioConsultor = "consultor";
    final String usuarioAdministrador = "admin";
    final String usuarioFuncionario = "funcionario";
    private Hashtable hashUsuarios;

    public boolean existeUserName(String userName) {
        return this.hashUsuarios.containsKey(userName);
    }

    public String getPassword(String userName) {
        return userName;
    }

    public ArrayList<IPerfilUsuario> getPerfiles(String userName) {
        if (existeUserName(userName)) {
            IUsuario user = (IUsuario) this.hashUsuarios.get(userName);
            return user.getListaPerfiles();
        }
        return null;
        /*
        IPerfilBuilder pb = new StubPerfilBuilder();
        ArrayList<String> perfiles = new ArrayList<String>();
        ArrayList<IPerfilUsuario> listaPerfiles = new ArrayList<IPerfilUsuario>();
        // Cargo los nombres de los perfiles
        if (userName.equalsIgnoreCase("admin")) {
        perfiles.add("administrador");
        } else if (userName.equalsIgnoreCase("funcionario")) {
        perfiles.add("funcionario");
        } else
        if (userName.equalsIgnoreCase("consultor"))  {
        perfiles.add("consultor");
        }
        // Cargo los perfiles por su nombre
        for(String perfil: perfiles){
        if(pb.existePerfil(perfil)){
        listaPerfiles.add(pb.getPerfil(perfil));
        }
        }
        return listaPerfiles;*/
    }

    public boolean crearUsuario(String userName, String password,
            ArrayList<String> perfiles) {
        if (!existeUserName(userName)) {
            this.hashUsuarios.put(userName, new Usuario(userName, password, perfiles));
            return true;
        }
        return false;
    }

    public boolean borrarUsuario(String userName) {
        if (existeUserName(userName)) {
            this.hashUsuarios.remove(userName);
            return true;
        }
        return false;
    }

    public boolean modificarUsuario(String userName, String password,
            ArrayList<String> perfiles) {
        if (existeUserName(userName)) {
            this.hashUsuarios.remove(userName);
            this.hashUsuarios.put(userName, new Usuario(userName, password, perfiles));
            return true;
        }
        return false;
    }
}
