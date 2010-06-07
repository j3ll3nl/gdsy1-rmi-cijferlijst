package gdsy.cijferlijst.client;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JApplet;

public class MyJApplet
extends JApplet
{
  private static final long serialVersionUID = 1L;
  private boolean debug = true;

  /*****************************************************************\
   * Construction 
  \*****************************************************************/

  public MyJApplet()
  {
    if (debug) System.out.println("MyJApplet()");
  }

  /*****************************************************************\
   * Lifecycle
  \*****************************************************************/
  @Override
  public void init()
  {
    if (debug) System.out.println("MyJApplet.init()");
    setName("MyJApplet");
    new Control(this);
  }

  @Override
  public void start()
  {
    if (debug) System.out.println("MyJApplet.start()");
    printInfo();
 }

  @Override
  public void stop()
  {
    if (debug) System.out.println("MyJApplet.stop()");
  }

  @Override
  public void destroy()
  {
    if (debug) System.out.println("MyJApplet.destroy()");
  }  
  
  /*****************************************************************\
   * Debug Info
  \*****************************************************************/
  public void printInfo()
  {
    if (debug) System.out.println("MyJFrame.printInfo()");  
    printContainer(   "", this);
    printContainer(  " ", getRootPane());
    printContainer( "  ", getLayeredPane());
    printContainer("   ", getContentPane()); 
  }
  
  private void printContainer(String s, Container container)
  {
    if (container != null)
    {
      Component[] component = container.getComponents();
      for (int i=0; i<component.length; i++)
      {
        if (debug) System.out.println(s+component[i]);     
      } 
    }
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJApplet.finalize()"); 
  }
}
