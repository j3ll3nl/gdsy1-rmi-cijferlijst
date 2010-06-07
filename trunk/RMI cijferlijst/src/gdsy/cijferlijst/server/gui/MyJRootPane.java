package gdsy.cijferlijst.server.gui;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

public class MyJRootPane
extends JRootPane
{
  private static final long serialVersionUID = 1L; 
    
  public MyJRootPane() 
  { 
    //System.out.println("MyJRootPane()");       
    setName("MyJRootPane");       
  }
  
  @Override
  protected Component createGlassPane()   
  {     
    //System.out.println("MyJRootpane.createGlassPane()");
    return new MyGlassPane();    
  }
  
  @Override
  protected JLayeredPane createLayeredPane() 
  { 
    //System.out.println("MyJRootpane.createLayeredPane()");
    return new MyJLayeredPane(); 
  }
  
  @Override
  protected Container createContentPane() 
  {     
    //System.out.println("MyJRootpane.createContentPane()");
    return new MyContentPane();  
  }
}

