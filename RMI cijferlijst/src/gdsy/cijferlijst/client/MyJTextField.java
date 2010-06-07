package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import javax.swing.JTextField;

class MyJTextField
extends JTextField
{
  private static final long serialVersionUID = 1L;  
  private boolean debug = false;
  
  MyJTextField(Rectangle rect)
  {
    super();
    if (debug) System.out.println("MyJTextField("+rect+")");
    setBounds(rect);    
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJTextField.finalize()"); 
  }
}
