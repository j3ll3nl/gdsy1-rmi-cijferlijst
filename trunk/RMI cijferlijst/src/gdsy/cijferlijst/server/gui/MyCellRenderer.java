package gdsy.cijferlijst.server.gui;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class MyCellRenderer 
extends MyJLabel 
implements ListCellRenderer 
{
  private static final long serialVersionUID = 1L;

  public MyCellRenderer() 
  {
    setOpaque(true);
  }

  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
  {
    //System.out.println("MyCellRenderer("+list.getClass().getName()+", "+value+", "+index+", "+isSelected+", "+cellHasFocus+")");       
    setText(value.toString());      
    return this;
  }
}

