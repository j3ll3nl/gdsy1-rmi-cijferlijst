package gdsy.cijferlijst.server.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.net.UnknownHostException;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class MyJFrame
extends JFrame
{
  private static final long serialVersionUID = 1L;
  private int x = 0;
  private int y = 0;
  private int w = 1024;
  private int h = 512;
  
  public MyJFrame(String item, String port, EventListener eventListener)
  throws UnknownHostException // by MyJpanelNORTH
  {   
    //System.out.println("MyJFrame()");
    setName("MyJFrame"); 
    setTitle(" ABC-LIBRARY RMI Server");
    setResizable(false);
    setBounds(x, y, w, h);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    MyJPanel  north = new MyJPanel(item, port, eventListener);  
    add(north, BorderLayout.NORTH);
    setVisible(true);   
    getGlassPane().setVisible(true);
  }  
  
  @Override
  public void addNotify()
  {
    super.addNotify();
    //System.out.println("MyJFrame.addNotify()");
    Image image = createImage(256, 256);
    Graphics graphics = image.getGraphics();
    for (int r = 0; r < 255; r++)
    {
      for (int g = 0; g < 255; g++)
      {
        graphics.setColor(new Color(r, g, (r + g) % 256));
        graphics.drawLine(r, g, r, g);
      }
    }
    setIconImage(image);
  }
  
  @Override
  protected JRootPane createRootPane()
  {    
    //System.out.println("MyJFrame.createJRootPane()");
    return new MyJRootPane();
  }

  public void printInfo()
  {
    System.out.println("MyJFrame.printInfo()");  
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
        System.out.println(s+component[i]);     
      } 
    }
  }

}
