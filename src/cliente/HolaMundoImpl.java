package RMI_inicial;

import java.rmi.*;
import java.rmi.server.*;

public class HolaMundoImpl extends UnicastRemoteObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HolaMundoImpl() throws RemoteException {
		super();
	}
	
	public String decirHola(String nombre) throws RemoteException {
		return "Hello world" + nombre;
	}
}