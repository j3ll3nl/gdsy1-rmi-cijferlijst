package gdsy.cijferlijst.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;

class MyJLabel
extends JLabel
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;

  MyJLabel()
  {  
    if (debug) System.out.println("MyJLabel()"); 
  }
  
  MyJLabel(String text, int alignment, Rectangle rect)
  {
    super(text, alignment);
    if (debug) System.out.println("MyJLabel("+text+", "+", "+alignment+", "+rect+")"); 
    setFont(new Font("dialog", Font.BOLD, 8*rect.height/10));
    setForeground(new Color(0, 0, 128));
    setBounds(rect);
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJLabel.finalize()"); 
  }
}
