package gdsy.cijferlijst.client;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class MyJButton
extends JButton
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;

  MyJButton(String label, ActionListener al, Rectangle rect)
  {
    super(label);
    if (debug) System.out.println("MyJButton("+label+", "+", "+al.getClass().getName()+""+rect+")");
    addActionListener(al);
    setFont(new Font("dialog", Font.BOLD, 7*rect.height/10));
    setBounds(rect);   
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJButton.finalize()"); 
  }
}
