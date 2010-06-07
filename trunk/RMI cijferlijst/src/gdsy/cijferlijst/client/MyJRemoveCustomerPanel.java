package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JLabel;

class MyJRemoveCustomerPanel
extends MyJMenuPanel
{  
  private static final long serialVersionUID = 1L;
  private boolean debug = false;

  MyJRemoveCustomerPanel(Set<String> customers, ActionListener al)
  {
    super(al);
    if (debug) System.out.println("MyJRemoveCustomerPanel("+customers+", "+al.getClass().getName()+")"); 
    setName(C.removecustomer);
    add(new MyJLabel("remove customer", JLabel.CENTER, new Rectangle(sx    , sy   ,  sw    , 30)));   
    add(new MyJLabel("customer"       , JLabel.CENTER, new Rectangle(sx    , sy+40,    100, 20))); 
    add(new MyJComboBox(customers                    , new Rectangle(sx+100, sy+40, sw-100, 20)));

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
    System.out.println("MyJRemoveCustomerPanel.finalize()"); 
  }
}
