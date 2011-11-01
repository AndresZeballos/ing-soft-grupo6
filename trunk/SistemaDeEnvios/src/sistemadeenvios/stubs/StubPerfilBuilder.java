/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.logic.IPerfilUsuario;

/**
 *
 * @author agustin
 */
public class StubPerfilBuilder implements IPerfilBuilder {
    
    public boolean existePerfil(String perfilName) {
        return true;
    }

    public IPerfilUsuario getPerfil(String perfilName) {
        if (perfilName.equalsIgnoreCase("administrador")) {
            return new StubPerfilAdministrador();
        } else if (perfilName.equalsIgnoreCase("funcionario")) {
            return new StubPerfilFuncionario();
        } else /* if (userName.equalsIgnoreCase("consultor")) */ {
            return new StubPerfilConsultar();
        }
    }
}
