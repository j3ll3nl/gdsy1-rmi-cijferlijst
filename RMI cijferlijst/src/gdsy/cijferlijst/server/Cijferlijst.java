package gdsy.cijferlijst.server;

import java.io.Serializable;
import java.util.HashMap;

public class Cijferlijst implements Serializable {  
  private static final long serialVersionUID = 1L;
  
  /***************************************************************************\
   * Static
  \***************************************************************************/
  private static HashMap<String, Cijferlijst> cijfers = null;
  
  static {
    System.out.println("Cijferlijst: static initializer");
    Cijferlijst.cijfers = Utils.getCijferlijst();
    
    if (Cijferlijst.cijfers == null) {
    	Cijferlijst.cijfers = new HashMap<String, Cijferlijst>();
    	
    	new Cijferlijst("Anne Roon", 5);
    	new Cijferlijst("Arjen Adriaanse", 7);
    	new Cijferlijst("Arnout Evers", 6.3 );
    	new Cijferlijst("Bar Janssen", 4.3);
    	new Cijferlijst("Benno van Dijk", 8.2 );
    	new Cijferlijst("Bjorn Slaman", 7.4);
    	new Cijferlijst("Bram Eisenhardt", 3);
    	new Cijferlijst("Bram Theeuwes", 7.6);
    	new Cijferlijst("Chriastaan van Brummelen", 8.3);
    	new Cijferlijst("Corne Roele", 6);
    	new Cijferlijst("Jelle den Butter", 8.5);
    	new Cijferlijst("Koen Mulder", 8.5);
    	
    	Utils.writeCijferlijst(cijfers);
    }
  }
   
  public static Cijferlijst findCijfer(String naam) {
	  synchronized (cijfers) {
		  return cijfers.get(naam);
	  }
  }
  
  public static void removeCijfers(String naam) {
      synchronized (cijfers) {
    	  cijfers.remove(naam);
      }
  }
  
  /*public static HashSet<String> allBooks()
  {
    HashSet<String> ret = new HashSet<String>(); 
    synchronized (books)
    {
      for (String title : books.keySet())
      {
        ret.add(title);
      }
      return ret;
    }
  }*/
  
  static void close()
  {
    Utils.writeCijferlijst(cijfers);
  }
  
  /***************************************************************************\
   * Object
  \***************************************************************************/  
  private String naam = null;
  private double cijfer = 0;
  
  Cijferlijst(String naam, double cijfer)
  {
    System.out.println("Cijfer("+naam+","+cijfer+")");
    
    this.naam = naam;
    this.cijfer = cijfer;
    
    synchronized (Cijferlijst.cijfers) {
    	Cijferlijst.cijfers.put(this.naam, this);
    }
  }
  
  public String getNaam() {
	  return this.naam;
  }
  
  public double getCijfer() {
	  return this.cijfer;
  }
  
  public void setCijfer(double cijfer) {
	  this.cijfer = cijfer;
  }
  
  public void setNaam (String naam)  {
	  this.naam = naam;
  }
  
  public String getInfo()  {
    return "[Cijfer: "+this.naam+", "+this.cijfer+"]";
  }
  
  @Override
  public String toString()
  {
    return this.naam;
  } 
}

