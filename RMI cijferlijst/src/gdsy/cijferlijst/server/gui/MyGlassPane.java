package gdsy.cijferlijst.server.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class MyGlassPane extends JComponent
{
  private static final long serialVersionUID = 1L; 
  private Font font = new Font("monospaced", Font.BOLD, 32);
  private String text = "";
  
  public MyGlassPane()
  {
    //System.out.println("MyGlassPane()");   
    setName("MyGlassPane"); 
  }
  
  public void setText(String newText)
  {
    //System.out.println("MyGlassPane().setText("+newText+")");
    text = newText;
    repaint();
  }
  
  @Override
  protected void paintComponent(Graphics g)
  {
    //System.out.println("MyGlassPane.paintComponent()");
    Graphics2D g2d = (Graphics2D)g;
    g2d.setFont(font);
    g2d.setColor(Color.BLUE);
    g2d.drawString("- "+text+" -", 850, 80);
  }
}