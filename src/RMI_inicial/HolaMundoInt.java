package RMI_inicial;

import java.rmi.*;

public interface HolaMundoInt extends Remote {
	public String decirHola(String nombre) throws java.rmi.RemoteException;
}
