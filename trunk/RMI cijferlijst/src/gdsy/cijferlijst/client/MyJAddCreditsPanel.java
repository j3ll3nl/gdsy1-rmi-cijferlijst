package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;

class MyJAddCreditsPanel
extends MyJMenuPanel
{  
  private static final long serialVersionUID = 1L;
  private boolean debug = false;

  MyJAddCreditsPanel(Set<String> items, ActionListener al)
  {
    super(al);
    if (debug) System.out.println("MyAddCreditsPanel("+items+", "+al.getClass().getName()+")");
    setName(C.addcredits);
    HashSet<String> credits = new HashSet<String>();
    for (int i=0; i<16; i++)
    {
      credits.add(""+i);
    }
    add(new MyJLabel("add credits", JLabel.CENTER, new Rectangle(sx    , sy   ,  sw    , 30)));   
    add(new MyJLabel("customer"   , JLabel.CENTER, new Rectangle(sx    , sy+40,    100, 20))); 
    add(new MyJComboBox(items                        , new Rectangle(sx+100, sy+40, sw-100, 20)));
    add(new MyJLabel("credits"    , JLabel.CENTER, new Rectangle(sx    , sy+70,    100, 20))); 
    add(new MyJComboBox(credits                      ,  new Rectangle(sx+100, sy+70, sw-100, 20)));

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
    System.out.println("MyJAddCreditsPanel.finalize()"); 
  }
}
