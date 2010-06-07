package gdsy.cijferlijst.IF;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginRemoteIF
extends Remote
{ 
  static final String registryName = "ABC-LIBRARY";
  Remote login(String usr, String pwd) throws RemoteException; 
}
