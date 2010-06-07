package gdsy.cijferlijst.server.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class MyContentPane
extends JPanel
{
  private static final long serialVersionUID = 1L;
 
  public MyContentPane()
  {
    //System.out.println("MyContentPane()");
    setName("MyContentPane");   
    setBackground(Color.BLACK);   
    setLayout(new BorderLayout(1, 1));  
  }  
}

