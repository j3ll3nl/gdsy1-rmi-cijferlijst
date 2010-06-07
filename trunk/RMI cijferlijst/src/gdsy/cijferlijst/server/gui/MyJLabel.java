package gdsy.cijferlijst.server.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyJLabel extends JLabel
{
  private static final long serialVersionUID = 1L;
  private Font font = new Font("monospace", Font.BOLD, 14);

  public MyJLabel() {}
  
  public MyJLabel(String text)
  {
    super(text);    
    //System.out.println("MyJLabel("+text+")");
    setForeground(Color.BLUE);
    setBackground(Color.WHITE);
    setFont(font);
  }
}
