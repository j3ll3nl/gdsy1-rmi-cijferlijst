package gdsy.cijferlijst.server.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.net.UnknownHostException;
import java.util.EventListener;

import javax.swing.JPanel;

public class MyJPanel 
extends JPanel
{
  private static final long serialVersionUID = 1L;

  public MyJPanel(String item, String port, EventListener eventListener)
  throws UnknownHostException // by MyChoice
  {
    super(new FlowLayout(FlowLayout.CENTER, 5, 1));
    //System.out.println("MyJPanelNORTH("+item+","+port+","+contentbase+", "+eventListener+")");
    add(new MyJLabel("  host"));
    add(new MyJComboBox(item, (ItemListener)eventListener));
    add(new MyJLabel("  port"));
    add(new MyJTextField("port", port, 5, true, (ActionListener)eventListener));
    add(new MyJButton(new MyIconStart(), "start", true, (ActionListener)eventListener));
  }
}
