package gdsy.cijferlijst.client;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class MyCellRenderer 
extends MyJLabel 
implements ListCellRenderer 
{
  private static final long serialVersionUID = 1L;
  private boolean debug = false;
  
  MyCellRenderer() 
  {
    if (debug) System.out.println("MyCellRendrer()");
    setOpaque(true);
  }

  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
  {
    if (debug) System.out.println("MyCellRenderer("+list.getClass().getName()+", "+value+", "+index+", "+isSelected+", "+cellHasFocus+")");       
    setText(value.toString());      
    return this;
  }  
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyCellRenderer.finalize()"); 
  }
}
