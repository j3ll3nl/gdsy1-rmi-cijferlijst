package gdsy.cijferlijst.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import gdsy.cijferlijst.IF.LoginRemoteIF;
import gdsy.cijferlijst.server.LoginRemote;

public class Server
{     
  private int registryPort = 1097;
  private LoginRemoteIF login = null;
  private Registry registry = null;
  private boolean bind = false;

  public void start(int port)
  throws RemoteException
  {    
    System.out.println("Server.start("+port+")");
    login = new LoginRemote(port);
    System.out.println(UnicastRemoteObject.exportObject(login, port));
    if (registry == null)
    {
      registry = LocateRegistry.createRegistry(registryPort);   
      System.out.println("registry="+registry);
    }
    registry.rebind(LoginRemoteIF.registryName, login);
    bind = true;
    String[] list = registry.list();
    for (int i=0; i<list.length; i++)
    {
      System.out.println("registry["+i+"]="+list[i]);
    }
  }
  
  public void stop()
  throws Exception
  {
    System.out.println("Server.stop()");
    if (login != null)
    {
      System.out.println("unexportObject()="+UnicastRemoteObject.unexportObject(login, true));
      login = null;
    }
    if (bind)
    {
      registry.unbind(LoginRemoteIF.registryName);
      bind = false;
    }
    System.gc();
    System.runFinalization();
  }
}
