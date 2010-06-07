package gdsy.cijferlijst.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import gdsy.cijferlijst.IF.CijferlijstRemoteIF;
import gdsy.cijferlijst.IF.LoginRemoteIF;

public class LoginRemote
implements LoginRemoteIF
{   
  private static int port = 0;
  
  public LoginRemote(int newPort)
  {
    System.out.println("LoginRemote()");
    port = newPort;
  }
  
  private boolean check(String usr, String pwd)
  {
    System.out.println("LoginRemote.check("+usr+", "+pwd+")");
    return (usr.equals("eric") && pwd.equals("geheim"));
  }
  
  public Remote login(String usr, String pwd) 
  throws RemoteException
  {
    System.out.println("LoginRemote.login("+usr+", "+pwd+")");
    if (check(usr, pwd))
    {
      CijferlijstRemoteIF manager = new CijferlijstRemote();
      Remote remote = UnicastRemoteObject.exportObject(manager, port);
      System.out.println(remote);
      return remote;
    }
    throw new RemoteException("wrong username and/or password");
  }
}
