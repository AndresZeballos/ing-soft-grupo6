/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.drivers;

import java.util.ArrayList;
import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.logic.Usuario;

/**
 *
 * @author Andres
 */
public class DriverUsuario {

    public static void main(String args[]) {
        IUsuario user = newUser();
        IUsuario userNull = newUserNull();
        getUserName(user);
        getListaPerfiles(user);
        validarPassword(user, userNull);
        validarAcceso(user);
        addPerfil(user);
        crearUsuario(user);
        borrarUsuario(user);
        modificarUsuario(user);
    }

    private static IUsuario newUser() {
        String userName = "user";
        String password = "pass";
        ArrayList<String> listaPerfiles = new ArrayList<String>();
        listaPerfiles.add("consultor");
        return new Usuario(userName, password, listaPerfiles);
    }

    private static IUsuario newUserNull() {
        String userName = "null";
        ArrayList<String> listaPerfiles = new ArrayList<String>();
        listaPerfiles.add("consultor");
        return new Usuario(userName, null, listaPerfiles);
    }

    /*
     * Verificar que retorna "user"
     */
    private static void getUserName(IUsuario user) {
        System.out.println("Nombre del usuario debe ser \"user\": " + user.getUserName());
    }

    /*
     * Verificar que retorna una lista de IPerfilUsuario, cuyo 
     * único elemento tiene nombre "consultor"
     */
    private static void getListaPerfiles(IUsuario user) {
        System.out.println("getListaPerfiles");
        System.out.println("La lista de perfiles debe tener \"1\" como largo: " + user.getListaPerfiles().size());
        System.out.println("Nombre del perfil debe ser \"consultor\": " + user.getListaPerfiles().get(0).getPerfilName());
    }

    /*
     * 3 cursos de acción:
     * 1) Usuario mal cargado -> password en null -> false
     * 2) Usuario bien cargado -> password incorrecta -> false
     * 3) Usuario bien cargado -> password correcta -> true
     */
    private static void validarPassword(IUsuario user, IUsuario userNull) {
        System.out.println("validarPassword");
        System.out.println("Usuario mal cargado -> password en null: " + userNull.validarPassword("pass"));
        System.out.println("Usuario bien cargado -> password incorrecta: " + user.validarPassword("otraCosa"));
        System.out.println("Usuario bien cargado -> password correcta: " + user.validarPassword("pass"));
    }

    private static void validarAcceso(IUsuario user) {
        System.out.println("validarAcceso");
        System.out.println("Debe validar el acceso a \"ConsultarEnvio\": " + user.validarAcceso("ConsultarEnvio"));
        System.out.println("Debe validar el acceso a \"consultarenvio\": " + user.validarAcceso("consultarenvio"));
        System.out.println("No debe validar el acceso a \"Administrar\": " + user.validarAcceso("Administrar"));
    }

    private static void addPerfil(IUsuario user) {
        System.out.println("addPerfil");
        System.out.println("La lista de perfiles debe tener \"1\" como largo: " + user.getListaPerfiles().size());
        System.out.println("Nombre del perfil debe ser \"consultor\": " + user.getListaPerfiles().get(0).getPerfilName());
        user.addPerfil("consultor");
        System.out.println("Agrega el perfil: \"consultor\" -> ya lo tiene, no debe agregarlo");
        System.out.println("La lista de perfiles debe tener \"1\" como largo: " + user.getListaPerfiles().size());
        System.out.println("Nombre del perfil debe ser \"consultor\": " + user.getListaPerfiles().get(0).getPerfilName());
        user.addPerfil("funcionario");
        System.out.println("Agrega el perfil: \"funcionario\" -> no lo tiene, debe agregarlo");
        System.out.println("La lista de perfiles debe tener \"2\" como largo: " + user.getListaPerfiles().size());
        System.out.println("Nombre del perfil 0 debe ser \"consultor\": " + user.getListaPerfiles().get(0).getPerfilName());
        System.out.println("Nombre del perfil 1 debe ser \"funcionario\": " + user.getListaPerfiles().get(1).getPerfilName());
    }

    private static void crearUsuario(IUsuario user) {
        System.out.println("crearUsuario");
        System.out.println("Debe retornar \"true\": " + user.crearUsuario());
    }

    private static void borrarUsuario(IUsuario user) {
        System.out.println("borrarUsuario");
        System.out.println("Debe retornar \"true\": " + user.borrarUsuario());
    }

    private static void modificarUsuario(IUsuario user) {
        System.out.println("modificarUsuario");
        System.out.println("Debe retornar \"true\": " + user.modificarUsuario());
    }
}
