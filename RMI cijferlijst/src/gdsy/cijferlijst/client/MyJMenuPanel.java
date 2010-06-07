package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import java.awt.event.ActionListener;

class MyJMenuPanel
extends MyJTitlePanel
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;

  MyJMenuPanel(ActionListener al)
  {
    if (debug) System.out.println("MyJMenuPanel("+al.getClass().getName()+")"); 
    MyJButton nb = new MyJButton(C.newbook       , al, new Rectangle(mx, my    , mw, 20));
    MyJButton nc = new MyJButton(C.newcustomer   , al, new Rectangle(mx, my+ 22, mw, 20));
    MyJButton rb = new MyJButton(C.removebook    , al, new Rectangle(mx, my+ 44, mw, 20));
    MyJButton rc = new MyJButton(C.removecustomer, al, new Rectangle(mx, my+ 66, mw, 20));
    MyJButton ac = new MyJButton(C.addcredits    , al, new Rectangle(mx, my+ 88, mw, 20));
    MyJButton l  = new MyJButton(C.lend          , al, new Rectangle(mx, my+110, mw, 20));
    MyJButton ul = new MyJButton(C.unlend        , al, new Rectangle(mx, my+132, mw, 20));
    MyJButton e  = new MyJButton(C.exit          , al, new Rectangle(mx, my+154, mw, 20));
    
    add(nb);
    add(nc);
    add(rb);
    add(rc);
    add(ac);
    add(l);
    add(ul); 
    add(e);
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJMenuPanel.finalize()"); 
  }
}
