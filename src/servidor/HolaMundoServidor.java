package servidor;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cliente.HolaMundoImpl;

import java.net.*;
import java.io.*;

public class HolaMundoServidor {

	public static void main(String args[]) {
		
		InputStreamReader ent = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(ent);
		String numPuerto, URLRegistro;
		
		try {
			
			System.out.println("Nº de puerto registro RMI: ");
			numPuerto = buf.readLine().trim();
			int numPuertoRMI = Integer.parseInt(numPuerto);
			arrancarRegistro(numPuertoRMI);
			HolaMundoImpl objExportado = new HolaMundoImpl();
			URLRegistro = "rmi://localhost:" + numPuerto + "/holaMundo";
			Naming.rebind(URLRegistro, objExportado);
			System.out.println("Servidor registrado. El registro contiene actualmente: ");
			listaRegistro(URLRegistro);
			System.out.println("Servidor HolaMundo preparado.");
			
		} catch(Exception excr) {
			System.out.println("Excepcion: " + excr);
		}
		
	}
	
	// Arranca registro RMI en la máquina local
	private static void arrancarRegistro(int numPuertoRMI) throws RemoteException {
		try {
			Registry registro = LocateRegistry.getRegistry(numPuertoRMI);
			registro.list();			
		} catch(RemoteException e) {
			System.out.println("El registro RMI no se puede localizar en el puerto " + numPuertoRMI);
			Registry registro = LocateRegistry.createRegistry(numPuertoRMI);
			System.out.println("Registro RMI creado en en el puerto " + numPuertoRMI);
			
		}
	}
	
	// Listar nombres registrados
	private static void listaRegistro(String URLRegistro) throws RemoteException, MalformedURLException {
		
		System.out.println("Registro " + URLRegistro + " contiene: ");
		String [] nombres = Naming.list(URLRegistro);
		for(int i=0; i<nombres.length; i++) {
			System.out.println(nombres[i]);			
		}
		
	}
	
}