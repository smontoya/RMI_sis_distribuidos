package app_cliente_sd;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Daniel Wladdimiro Cottet
 * @title Taller de sistemas distribuidos - Clase 1
 */

//Esta inteface indicará los métodos que están a dispoción del cliente y servidor
//para que puedan interactuar remotamente.
//Todos estos métodos deben poseer como mínimo la excepción RemoteException

public interface Interface extends Remote {
    public boolean ingresarUsuario(String username, String rut, String digito, String nombre, String departamento, String salario, String password) throws RemoteException;
    public boolean buscarUsuario(String username) throws RemoteException;
    public ArrayList<String> verUsuarios() throws RemoteException;
}