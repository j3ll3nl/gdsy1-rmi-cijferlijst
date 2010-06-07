package gdsy.cijferlijst.server.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Icon;

public class MyIconStop implements Icon
{
  private Font font = new Font("dialog", Font.PLAIN, 12);
  
  public MyIconStop()
  {
    //System.out.println("MyIconStop()");
  }
  
  @Override
  public int getIconHeight()
  {
    return 14;
  }

  @Override
  public int getIconWidth()
  {
    return 42;
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y)
  {
    //System.out.println("MyStartIcon.paintIcon(): "+c+", "+x+","+y);
    g.setFont(font);
    g.setColor(Color.RED);
    g.fillRect(x, y, x+39, y+11);
    g.setColor(Color.BLACK);
    g.drawString("STOP", x+2, y+12);
  }
  
  @Override
  public String toString()
  {
    return "[MyIconStop 14x42]";
  }
}
