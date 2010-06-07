package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import javax.swing.JPasswordField;

class MyJPasswordField
extends JPasswordField
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;
  
  MyJPasswordField(Rectangle rect)
  {
    super();
    if (debug) System.out.println("MyJRemoveBookPanel("+rect+")"); 
    setBounds(rect);    
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJPasswordField.finalize()"); 
  }
}
