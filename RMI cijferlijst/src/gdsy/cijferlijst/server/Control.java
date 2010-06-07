package gdsy.cijferlijst.server;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import gdsy.cijferlijst.server.gui.MyIconStart;
import gdsy.cijferlijst.server.gui.MyIconStop;
import gdsy.cijferlijst.server.gui.MyJFrame;
import gdsy.cijferlijst.server.gui.MyJLayeredPane;
import gdsy.cijferlijst.server.gui.MyJScrollPane;
import gdsy.cijferlijst.server.gui.MyJTextPane;

public class Control
extends HashMap<Integer, MyJTextPane> 
implements ActionListener, ItemListener
{
  private static final long serialVersionUID = 1L;
 
  /*****************************************************************\
   * Attributes
   \*****************************************************************/
  private MyJFrame    myJFrame    = null;
  private int         port        = 10099;
  private String      item        = null;
  private Server      server      = null;

  /*****************************************************************\
   * Construction
   \*****************************************************************/
  Control()
  {
    out("Control()");
    System.setOut(new PrintStream(new MyOutputStream(this)));
    System.setErr(new PrintStream(new MyErrorStream(this)));    
    
    System.setProperty("java.rmi.server.logCalls", "true");
    System.setProperty("java.rmi.dgc.leaseValue", "10*60*1000");      // default = 10*60*1000 ms
    System.setProperty("sun.rmi.dgc.logLevel",             "SILENT"); // SILENT, BRIEF, VERBOSE
    System.setProperty("sun.rmi.loader.logLevel",          "SILENT");
    System.setProperty("sun.rmi.server.logLevel",          "SILENT");
    System.setProperty("sun.rmi.transport.logLevel",       "SILENT");
    System.setProperty("sun.rmi.transport.proxy.logLevel", "SILENT");
    System.setProperty("sun.rmi.transport.tcp.logLevel",   "SILENT");

    try
    {
      InetAddress bindAddress = InetAddress.getLocalHost();    
      item = bindAddress.getHostAddress();      
      System.setProperty("java.rmi.server.hostname", item);
      myJFrame = new MyJFrame(item, ""+port, this);   
    }
    catch (UnknownHostException uhe)
    {
      err("Control(): "+uhe.getMessage());
    }
    server = new Server();
  }
   
  /*****************************************************************\
   * do Logging
   \*****************************************************************/
  synchronized void log(int id, Color color, String x)
  {
    if (myJFrame != null)
    {     
      MyJTextPane area = (MyJTextPane)get(id);
      if (area == null)
      {
        area = new MyJTextPane();
        put(id, area);
        MyJScrollPane scrollPane = new MyJScrollPane(id, area);     
        MyJLayeredPane layeredPane = (MyJLayeredPane)myJFrame.getLayeredPane();
        layeredPane.addInLayer(scrollPane);
      }    
      area.append(color, x); 
      //area.append(color, (System.currentTimeMillis()/1000%1000)+"  "+text);   
    }
    else
    {
      if (color.equals(Color.BLACK))
      {
         System.out.println(x);   
      }
      else
      {
        System.err.println(x);
      }
    }
  }
  
  /*****************************************************************\
   * Control doStart(), doStop(), doPort(), doContentbase(), doBindAddrerss()
   \*****************************************************************/
  boolean doStart()
  {
    out("Control.doStart()");    
    try
    {  
      //clean gui
      MyJLayeredPane layeredPane = (MyJLayeredPane)myJFrame.getLayeredPane();
      layeredPane.removeLayer();   
      
      // clean output
      for (int id : keySet())
      {
        put(id, null);
      }
      
      // stop existing server 
      doStop();
      
      // start server
      server.start(port);
      return true;
    }
    catch (RemoteException re)
    {
      err("Control.doStart(): "+re.getMessage());
      return false;
    }
  }
  
  void doStop()
  {
    out("Control.doStop()");
    try
    {
      server.stop();     
    }
    catch (Exception ioe)
    {
      err("Control.doStop(): "+ioe.getMessage());    
    }    
  }
  
  void doPort(int newPort)
  {
    out("Control.doPort("+newPort+")");
    port = newPort;
    if (server != null)
    {
      doStart();
    }
  }
  
  void doBindAddress(InetAddress bindAddress)
  {
    out("Control.doBindAddress("+bindAddress+")");
    System.setProperty("java.rmi.server.hostname", bindAddress.getHostAddress());
    if (server != null)
    {
      doStart();
    }
  }
    
  /*****************************************************************\
   * ActionListener
   \*****************************************************************/
  @Override
  public void actionPerformed(ActionEvent ae)
  {   
    out("Control.actionPerformed("+ae+")");
    Object obj = ae.getSource();
    if (obj instanceof JButton)
    {
      JButton button = (JButton)obj;
      button.setEnabled(false);
      String cmd = button.getActionCommand();
      if (cmd.equals("start"))
      {
        if (doStart())
        {
          button.setIcon(new MyIconStop());
          button.setActionCommand("stop");
        }
        button.setEnabled(true);
      }
      else if (cmd.equals("stop"))
      {
        doStop();    
        button.setIcon(new MyIconStart());
        button.setActionCommand("start");
        button.setEnabled(true);    
      }
    }
    if (obj instanceof JTextField)
    {
      JTextField textField = (JTextField)obj;
      String cmd = ae.getActionCommand();
      if (cmd.equals("port"))
      {
        try
        {
          doPort(Integer.parseInt(textField.getText()));
        }
        catch (NumberFormatException nfe)
        {
          err("Control.actionPerformed(): "+nfe.getMessage());
        }
      }
    } 
  }

  /*****************************************************************\
   * ItemListener
   \*****************************************************************/
  @Override
  public void itemStateChanged(ItemEvent ie)
  {     
    out("Control.itemStateChanged("+ie+")");
    JComboBox choice = (JComboBox)ie.getSource();
    item = (String)choice.getSelectedItem();
    try
    {
      InetAddress bindAddress = InetAddress.getByName(item);
      doBindAddress(bindAddress);
    }
    catch (UnknownHostException uhe)
    {
       err("Control.itemStateChanged(): "+uhe.getMessage());
    }
  } 
  
  /*****************************************************************\
   * Logging
  \*****************************************************************/  
  private void out(String x)
  {
    log(100, Color.BLACK, x+"\n");
  }
 
  private void err(String x)
  {
     log(100, Color.RED, x+"\n");
  }
}
