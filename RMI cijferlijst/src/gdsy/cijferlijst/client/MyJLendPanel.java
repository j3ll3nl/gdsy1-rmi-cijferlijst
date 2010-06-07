package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JLabel;

class MyJLendPanel
extends MyJMenuPanel
{  
  private static final long serialVersionUID = 1L;
  private boolean debug = false;

  MyJLendPanel(Set<String> customers, Set<String> books, ActionListener al)
  {
    super(al);
    if (debug) System.out.println("MyJLendPanel("+customers+", "+books+", "+al.getClass().getName()+")"); 
    setName(C.lend);
    add(new MyJLabel("lend"    , JLabel.CENTER, new Rectangle(sx    , sy   ,  sw    , 30)));   
    add(new MyJLabel("customer", JLabel.CENTER, new Rectangle(sx    , sy+40,    100, 20))); 
    add(new MyJComboBox(customers             , new Rectangle(sx+100, sy+40, sw-100, 20)));
    add(new MyJLabel("book"    , JLabel.CENTER, new Rectangle(sx    , sy+70,    100, 20))); 
    add(new MyJComboBox(books                 , new Rectangle(sx+100, sy+70, sw-100, 20)));

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
    System.out.println("MyJLendPanel.finalize()"); 
  }
}
