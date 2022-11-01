package cliente;

import java.io.*;
import java.rmi.*;

import servidor.HolaMundoServidor;

public class HolaMundoCliente {

	public static void main(String args[]) {
		
		try {
			int numPuertoRMI;
			String nombreNodo;
			InputStreamReader ent = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(ent);
			System.out.println("Nodo del registro RMI: ");
			nombreNodo = buf.readLine();
			System.out.println("Numero de puerto: ");
			String numPuerto = buf.readLine();
			numPuertoRMI = Integer.parseInt(numPuerto);
			//String URLRegistro = "rmi://" + nombreNodo + ":" + numPuertoRMI + "/holaMundo";
			String URLRegistro = "rmi://" + nombreNodo + ":" + numPuertoRMI +"/"+ HolaMundoImpl.class.getCanonicalName();
			
			HolaMundoInt h = (HolaMundoInt)Naming.lookup(URLRegistro);
			System.out.println("Busqueda completa.");
			
			String mensaje = h.decirHola("Pato donald");
			System.out.println("HolaMundoCliente: " + mensaje);
					
		} catch(Exception e) {
			System.out.println("Excepcion en HolaMundoCliente: " + e + "\n\n");
			e.printStackTrace();
		}
		
	}
	
}
