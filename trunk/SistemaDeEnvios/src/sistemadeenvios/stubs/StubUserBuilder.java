/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.ArrayList;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.logic.Usuario;
import sistemadeenvios.persistence.IUserBuilder;

/*
 * @author Fede
 */
public class StubUserBuilder implements IUserBuilder {

    private static StubUserBuilder INSTANCE;
    final String usuarioConsultor = "consultor";
    final String usuarioAdministrador = "administrador";
    final String usuarioFuncionario = "funcionario";
    private Hashtable hashUsuarios;

    public static StubUserBuilder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StubUserBuilder();
        }
        return INSTANCE;
    }

    private StubUserBuilder() {
        this.hashUsuarios = new Hashtable();
        this.hashUsuarios.put(usuarioConsultor, new StubUsuario(usuarioConsultor));
        this.hashUsuarios.put(usuarioAdministrador, new StubUsuario(usuarioAdministrador));
        this.hashUsuarios.put(usuarioFuncionario, new StubUsuario(usuarioFuncionario));
    }

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
