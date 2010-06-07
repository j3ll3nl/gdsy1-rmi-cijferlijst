package gdsy.cijferlijst.IF;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface CijferlijstRemoteIF extends Remote {
	HashMap<String, Double> getCijferlijst()		throws RemoteException;
	String addCijfer(String naam, double cijfer)	throws RemoteException;
	String updateCijfer(String naam, double cijfer) throws RemoteException; 
	String removeCijfer(String title)             	throws RemoteException;  
	void   close()                              	throws RemoteException;
}
