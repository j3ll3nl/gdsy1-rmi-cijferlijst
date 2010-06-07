package gdsy.cijferlijst.client;

import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

class MyJLoginPanel extends MyJTitlePanel
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;
 
  MyJLoginPanel(ActionListener al)
  {
    if (debug) System.out.println("MyJLoginPanel("+al.getClass().getName()+")"); 
    init(al);
  }
  
  MyJLoginPanel(int width, int height, ActionListener al)
  {
    super(true, width, height);
    if (debug) System.out.println("MyJLoginPanel("+width+", "+", "+height+", "+al.getClass().getName()+")"); 
    init(al);
  }
  
  private void init(ActionListener al)
  {
    if (debug) System.out.println("MyJLoginPanel.init("+al.getClass().getName()+")"); 
    setTitle("Welcome: type a username + enter");
    setName(C.login);
    //add(new MyJLabel("please login", JLabel.CENTER, new Rectangle(sx    , sy    , sw    , 30)));   
    add(new MyJLabel("username"    , JLabel.CENTER, new Rectangle(sx    , sy+ 40,    100, 20)));
    add(new MyJTextField(                           new Rectangle(sx+100, sy+ 40, sw-100, 20)));
    add(new MyJLabel("password"    , JLabel.CENTER, new Rectangle(sx    , sy+ 70,    100, 20)));
    add(new MyJPasswordField(                       new Rectangle(sx+100, sy+ 70, sw-100, 20)));

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
    System.out.println("MyJLoginPanel.finalize()"); 
  }
}
