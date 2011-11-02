/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import sistemadeenvios.logic.IPerfilUsuario;

/**
 *
 * @author agustin
 */
public class StubPerfilFuncionario implements IPerfilUsuario {

    public String getPerfilName() {
        return "funcionario";
    }

    public boolean validarAcceso(String componente) {
        return true;
    }

    public void agregarAcceso(String nombreComponente) {
    }

    public boolean tieneComponente(String componente) {
        return componente.equalsIgnoreCase("ConsultarEnvio") || componente.equalsIgnoreCase("NuevoEnvio");
    }
    public void borrarTodo(){}
}
