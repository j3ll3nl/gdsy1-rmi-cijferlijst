package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

class MyJNewBookPanel
extends MyJMenuPanel
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;
  
  MyJNewBookPanel(ActionListener al)
  {
    super(al);
    if (debug) System.out.println("MyJNewBookPanel("+al.getClass().getName()+")"); 
    setName(C.newbook);
    add(new MyJLabel("new book", JLabel.CENTER, new Rectangle(sx, sy, sw, 30))); 
    add(new MyJLabel("book"    , JLabel.CENTER, new Rectangle(sx    , sy+40,    100, 20))); 
    add(new MyJTextField(                       new Rectangle(sx+100, sy+40, sw-100, 20)));
 
    add(new MyJButton(C.send  , al, new Rectangle(sx       , sy+sh-20, 100, 20)));
    add(new MyJButton(C.cancel, al, new Rectangle(sx+sw-100, sy+sh-20, 100, 20)));
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJNewBookPanel.finalize()"); 
  }
}
