package gdsy.cijferlijst.server.gui;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MyJScrollPane 
extends JScrollPane
{
  private static final long serialVersionUID = 1L;
  private int id = 0;

  public MyJScrollPane(int newId, MyJTextPane view)
  {
    super(view);
    //System.out.println("MyJScrollPane("+view+")");
    id = newId;
    setName("MyJScrollPane");
    setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    setVerticalScrollBarPolicy  (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    setBounds(1, 26, 1015, 436);
  }
  
  public int getId()
  {
    return id;
  }
}
