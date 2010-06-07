package gdsy.cijferlijst.server.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JComboBox;

public class MyJComboBox extends JComboBox
{
  private static final long serialVersionUID = 1L;
  private Font font = new Font("monospaced", Font.PLAIN, 14);

  public MyJComboBox(String item, ItemListener itemListener)
  throws UnknownHostException // by InetAddress
  {   
    //System.out.println("MyJComboBox("+item+", "+itemListener+")");
    setFont(font);
    setEditable(true);    
    setRequestFocusEnabled(false);

    setRenderer(new MyCellRenderer());
    addItem("0.0.0.0");
   
    InetAddress localhost = InetAddress.getLocalHost();
    InetAddress[] host = InetAddress.getAllByName(localhost.getHostName());
    for (int i=0; i<host.length; i++)
    {
      addItem(host[i].getHostAddress());
    }
    setSelectedItem(item);    
    addItemListener(itemListener);
  } 
  
  @Override
  public Dimension getPreferredSize()
  {
    return new Dimension(160, 20);
  }
}
