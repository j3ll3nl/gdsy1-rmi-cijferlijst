package gdsy.cijferlijst.client;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.Set;

import javax.swing.JComboBox;

class MyJComboBox extends JComboBox
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;

  MyJComboBox(Set<String> items, Rectangle rect)
  {   
    if (debug) System.out.println("MyJComboBox("+items+", "+rect+")");
    setBounds(rect);
    setFont(new Font("monospaced", Font.PLAIN, 8*rect.height/10));
    setEditable(true);    
    setRequestFocusEnabled(false);
    setRenderer(new MyCellRenderer());
    addItems(items);
  } 
  
  private void addItems(Set<String> items)
  {
    if (debug) System.out.println("MyJComboBox.addItems("+items+")");
    if (items != null)
    {
      addItem("");
      for (String title : items)
      {
        addItem(title);
      }
    }
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJComboBox.finalize()"); 
  }
}
