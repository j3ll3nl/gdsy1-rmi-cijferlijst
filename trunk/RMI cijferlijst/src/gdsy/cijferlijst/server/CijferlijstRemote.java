package gdsy.cijferlijst.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.Unreferenced;
import java.util.HashMap;
import java.util.HashSet;

import gdsy.cijferlijst.IF.CijferlijstRemoteIF;

public class CijferlijstRemote implements CijferlijstRemoteIF, Unreferenced
{ 
  public CijferlijstRemote()
  {
    System.out.println("CijferlijstRemote()");
  }

@Override
public String addCijfer(String naam, double cijfer) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void close() throws RemoteException {
	// TODO Auto-generated method stub
	
}

@Override
public HashMap<String, Double> getCijferlijst() throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String removeCijfer(String title) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String updateCijfer(String naam, double cijfer) throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void unreferenced() {
	// TODO Auto-generated method stub
	
}
  
  /*public HashSet<String> allBooks()
  {
    System.out.println("LibraryManagerRemote.allBooks()");
    return Cijferlijst.allBooks();
  }
  
  public HashSet<String> allBooks(String name)
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.allBooks("+name+")");
    Customer customer = Customer.findCustomer(name);
    if (customer != null)
    {   
      HashSet<String> titles = new HashSet<String>();
      for (Cijferlijst book : customer.getBooks())
      {
        titles.add(book.getTitle());
      }
      return titles;
    }
    throw new RemoteException("\""+name+"\" does not exist in database"); 
  }
  
  public HashSet<String> allCustomers()
  {
    System.out.println("LibraryManagerRemote.allCustomers()");
    return Customer.allCustomers();
  } 
  
  public String addCredits(String name, int credits) 
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.addCredits("+name+", "+credits+")");   
    Customer customer = Customer.findCustomer(name);
    if (customer != null)
    {
      int newCredits = credits+customer.getCredits();
      customer.setCredits(newCredits);
      return "\""+name+"\" has "+newCredits+" credits";
    }
    throw new RemoteException("\""+name+"\" not exist in database");  
  }
  
  public String lend(String name, String title)
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.lend("+title+", "+name+")");
    Cijferlijst book = Cijferlijst.findBook(title);
    if (book != null)
    {
      Customer lendTo = book.getLendTo();       
      if (lendTo == null)
      {
        Customer customer = Customer.findCustomer(name); 
        if (customer != null)
        {
          int credits = customer.getCredits();
          if (credits > 0)
          {
            customer.setCredits(--credits);
            customer.addBook(book);
            book.setLendTo(customer);
            return "\""+title+"\" lend to "+name;
          }
          throw new RemoteException("\""+name+"\" has no credits");
        }
        throw new RemoteException("\""+name+"\" not exist in database");
      }
      throw new RemoteException("\""+title+"\" is lend to "+lendTo);
    }
    throw new RemoteException("\""+title+"\" not exist in database");   
  }
  
  public String newBook(String title)
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.newBook("+title+")");   
    Cijferlijst book = Cijferlijst.findBook(title);
    if (book == null)
    {
      new Cijferlijst(title);
      System.gc();
      System.runFinalization();
      return "\""+title+"\" put in database";
    }
    throw new RemoteException("\""+title+"\" exist in database");     
  }
  
  public String newCustomer(String name)
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.newCustomer("+name+")");    
    Customer customer = Customer.findCustomer(name);
    if (customer == null)
    {
      new Customer(name);
      return "\""+name+"\" put in database";
    }
    throw new RemoteException("\""+name+"\" exist in database");     
  }
  
  public String removeBook(String title)
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.removeBook("+title+")");   
    Cijferlijst book = Cijferlijst.findBook(title);
    if (book != null)
    {
      if (Cijferlijst.removeBook(title))
      {
        return "\""+title+"\" removed from database";
      }
      else
      {
        throw new RemoteException("\""+title+"\" in use");       
      }
    }
    throw new RemoteException("\""+title+"\" not exist in database");     
  }
  
  public String removeCustomer(String name)
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.removeCustomer("+name+")");  
    Customer customer = Customer.findCustomer(name);
    if (customer != null)
    {
      if (Customer.removeCustomer(name))
      {
        return "\""+name+"\" removed from database";
      }
      else
      {
        throw new RemoteException("\""+name+"\" has books");                     
      }
    }
    throw new RemoteException("\""+name+"\" not exist in database");     
  } 
  
  public String unlend(String title)
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.unlend("+title+")");  
    Cijferlijst book = Cijferlijst.findBook(title);   
    if (book != null)
    {
      Customer customer = book.getLendTo();
      if (customer != null)
      {
        book.setLendTo(null);
        customer.removeBook(book);
        return "\""+title+"\" is free";
      }
      throw new RemoteException("\""+title+"\" was free");
    }
    throw new RemoteException("\""+title+"\" not exist in database");
  }
  
  public void close()
  throws RemoteException
  {
    System.out.println("LibraryManagerRemote.close()");    
    Cijferlijst.close();
    Customer.close();  
  }

  @Override
  public void unreferenced()
  {
    System.out.println("LibraryManagerRemote.unreferenced()");    
    try
    {
      UnicastRemoteObject.unexportObject(this, true);
    }
    catch (Exception e)
    {
      System.err.println(e);
    }   
   }
  
  @Override
  protected void finalize()
  throws Throwable
  {
    System.err.println("LibrarymanagerRemote.finalize()");
  }*/
}