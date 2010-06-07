package gdsy.cijferlijst.server.gui;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

public class MyJLayeredPane
extends JLayeredPane
implements MouseWheelListener
{
  private static final long serialVersionUID = 1L;
  
  public MyJLayeredPane()
  {
    //System.out.println("MyJLayeredPane()");  
    setName("MyLayeredPane");
    addMouseWheelListener(this);
  }
  
  public void setText()
  {    
    Integer layer = JLayeredPane.DEFAULT_LAYER;
    int top = getComponentCountInLayer(layer);
    if (top > 0)
    {
      Component[] component = getComponentsInLayer(layer);
      MyJScrollPane  scrollPane = (MyJScrollPane)component[0];
      JRootPane rootPane = (JRootPane)getParent();    
      MyGlassPane glassPane = (MyGlassPane)rootPane.getGlassPane(); 
      glassPane.setText(""+scrollPane.getId());
    }
  }
  
  public void addInLayer(Component comp)
  {
    //System.out.println("MyJLayeredPane.addInLayer("+comp+")");  
    Integer layer = JLayeredPane.DEFAULT_LAYER;
    int top = getComponentCountInLayer(layer);
    if (top == 0)
    {
      super.add(comp, layer, 0);
    }
    else
    {
      Component[] component = getComponentsInLayer(layer);
      MyJScrollPane scrollPane = (MyJScrollPane)component[0];
      if (scrollPane.getId() == 100)
      {    
        super.add(comp, layer, -1);   
      }
      else
      {
        for (int i=1; i<component.length; i++)
        {
          scrollPane = (MyJScrollPane)component[i];
          if (scrollPane.getId() == 100)
          {
            super.add(comp, layer, i);                      
          }    
        }
      }
    }
    setText();
  }
  
  public void removeLayer()
  {    
    //System.out.println("MyJLayeredPane.removeLayer()");  
    Integer layer = JLayeredPane.DEFAULT_LAYER;
    int top = getComponentCountInLayer(layer);    
    if (top > 0)
    {
      Component[] component = getComponentsInLayer(layer);
      for (int i=0; i<top; i++)
      {
        int pos = getIndexOf(component[i]);
        remove(pos);
      }
    }
    setText();
  }
  
  @Override
  public void mouseWheelMoved(MouseWheelEvent mwm)
  {
    //System.out.println("MyJLayeredPane.mouseWheelMoved("+mwm+")");    
    int rotation = mwm.getWheelRotation();
    int top = getComponentCountInLayer(JLayeredPane.DEFAULT_LAYER);
    Component[] component = getComponentsInLayer(JLayeredPane.DEFAULT_LAYER);
    if (rotation > 0)
    {
      moveToBack(component[0]);
    }
    else
    {
      moveToFront(component[top-1]);
    }
    setText();
  }
}
