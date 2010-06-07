package gdsy.cijferlijst.client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.rmi.Naming;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gdsy.cijferlijst.IF.CijferlijstRemoteIF;
import gdsy.cijferlijst.IF.LoginRemoteIF;

class Control
implements ActionListener
{
  private MyJApplet myJApplet = null;
  private CijferlijstRemoteIF lib = null;
  
  private boolean debug = false;
  private boolean rmi = true;
    
  Control(MyJApplet newMyJApplet)
  {
    if (debug) System.out.println("Control("+newMyJApplet.getName()+")");
    myJApplet = newMyJApplet;
    
    int width  = myJApplet.getWidth();
    int height = myJApplet.getHeight();
    System.out.println("width="+width+", height="+height);
        
    myJApplet.getLayeredPane().add(new MyJLoginPanel(width, height, this));
  }
  
  @Override
  public void actionPerformed(ActionEvent ae)
  {
    if (debug) System.out.println("Control.actionperformed("+ae+")");
    JButton button = (JButton)ae.getSource();
    String cmd = button.getActionCommand(); 
    if (debug) System.out.println("cmd="+cmd);
    JComponent parent = (JComponent)button.getParent();
    
    if (cmd.equals(C.send))
    {    
      String name = parent.getName();
      if (debug) System.out.println("parent="+parent.getName());
      
           if (name.equals(C.login)         ) doLogin(parent);
      //else if (name.equals(C.newbook)       ) doNewBook(parent);
      //else if (name.equals(C.newcustomer)   ) doNewCustomer(parent);
      //else if (name.equals(C.removebook)    ) doRemoveBook(parent);
      //else if (name.equals(C.removecustomer)) doRemoveCustomer(parent);
      //else if (name.equals(C.addcredits)    ) doAddCredits(parent);
      //else if (name.equals(C.lend)          ) doLend(parent);
      //else if (name.equals(C.unlend)        ) doUnlend(parent);
    }
    else 
    {       
      MyJTitlePanel panel = (MyJTitlePanel)parent;
      panel.setMessage("message: ");
      panel.setError("error: ");
   
      myJApplet.getLayeredPane().removeAll();
           if (cmd.equals(C.cancel)        ) myJApplet.getLayeredPane().add(new MyJMenuPanel(this));        
      else if (cmd.equals(C.newbook)       ) myJApplet.getLayeredPane().add(new MyJNewBookPanel(this));  
      else if (cmd.equals(C.newcustomer)   ) myJApplet.getLayeredPane().add(new MyJNewCustomerPanel(this));
      //else if (cmd.equals(C.removebook)    ) myJApplet.getLayeredPane().add(new MyJRemoveBookPanel(allBooks(), this));
      //else if (cmd.equals(C.removecustomer)) myJApplet.getLayeredPane().add(new MyJRemoveCustomerPanel(allCustomers(), this));
      //else if (cmd.equals(C.addcredits)    ) myJApplet.getLayeredPane().add(new MyJAddCreditsPanel(allCustomers(), this));
      //else if (cmd.equals(C.lend)          ) myJApplet.getLayeredPane().add(new MyJLendPanel(allCustomers(), allBooks(), this));
      //else if (cmd.equals(C.unlend)        ) myJApplet.getLayeredPane().add(new MyJUnlendPanel(allBooks(), this));   
      else if (cmd.equals(C.exit)          ) doExit(parent);
    }
  }
  
  private void doLogin(JComponent parent)
  {
    if (debug) System.out.println("Control.doLogin("+parent.getName()+")");    
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent;
    
    JTextField textField = (JTextField)parent.getComponent(6);
    String usr = textField.getText();
    if (debug) System.out.println("usr="+usr);
    
    JPasswordField pwdField = (JPasswordField)parent.getComponent(8);
    char[] pwd_raw = pwdField.getPassword();
    String pwd = new String(pwd_raw);
    if (debug) System.out.println("pwd="+pwd);    
    
    try
    {
      URL codebase = myJApplet.getCodeBase();    
      String regName = "rmi://"+codebase.getHost()+":1097/"+LoginRemoteIF.registryName;
      
      LoginRemoteIF service = (LoginRemoteIF) Naming.lookup(regName);     
      if (rmi) System.out.println("Naming.lookup("+regName+")");
      if (rmi) System.out.println("service="+service);
      
      lib = (CijferlijstRemoteIF) service.login(usr, pwd);
      if (rmi) System.out.println("service.login("+usr+", "+pwd+")");
      if (rmi) System.out.println("lib="+lib);
      
      panel.setMessage("message: Duidelijk ingelogd!");
      panel.setError("error:  Duidelijk ingelogd!");
      //myJApplet.getLayeredPane().removeAll();
      //myJApplet.getLayeredPane().add(new MyJMenuPanel(this));
    }
    catch (Exception e)
    {
      panel.setError("error: "+e.getMessage());      
    }
  }
  
  /*private void doNewBook(JComponent parent)
  {
    if (debug) System.out.println("Control.doNewBook("+parent.getName()+")");
    if (debug) printComponents(parent);
    MyJTitlePanel panel = (MyJTitlePanel)parent;
    
    JTextField textField = (JTextField)parent.getComponent(14);
    String title = textField.getText();
    if (!title.equals(""))
    {
      try
      {
        if (rmi) System.out.println("lib.newBook("+title+")");
        panel.setMessage(lib.newBook(title));    
        textField.setText("");
      }
      catch (Exception e)
      {
        panel.setError("error: "+e.getMessage());     
      }
    }
    else
    {
      panel.setError("error: no title!");
    }
  }
  
  private void doRemoveBook(JComponent parent)
  {
    if (debug) System.out.println("Control.doRemoveBook("+parent.getName()+")");
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent; 
    
    JComboBox choice = (JComboBox)parent.getComponent(14);
    String title = (String)choice.getSelectedItem();
    if (debug) System.out.println("title="+title);
    
    try
    {
      if (rmi) System.out.println("lib.removeBook("+title+")");
      panel.setMessage(lib.removeBook(title));
      choice.removeItem(title);
    }
    catch (Exception e)
    {
      panel.setError("error: "+e.getMessage());     
    }
  }
  
  private void doNewCustomer(JComponent parent)
  {
    if (debug) System.out.println("Control.doNewCustomer("+parent.getName()+")");
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent; 
    
    JTextField textField = (JTextField)parent.getComponent(14);
    String name = textField.getText();
    if (debug) System.out.println("name="+name);
    
    if (!name.equals(""))
    {
      try
      {
        if (rmi) System.out.println("lib.newCustomer("+name+")");
        panel.setMessage(lib.newCustomer(name));   
        textField.setText("");
      }
      catch (Exception e)
      {
        panel.setError("error: "+e.getMessage());      
      }
    }
    else
    {
      panel.setError("error: no customer!");
    }
  }
  
  private void doRemoveCustomer(JComponent parent)
  {
    if (debug) System.out.println("Control.doRemoveCustomer("+parent.getName()+")");
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent;
    
    JComboBox choice = (JComboBox)parent.getComponent(14);
    String name = (String)choice.getSelectedItem();
    if (debug) System.out.println("name="+name);
    
    try
    {
      if (rmi) System.out.println("lib.removeCustomer("+name+")");
      panel.setMessage(lib.removeCustomer(name));
      choice.removeItem(name);
    }
    catch (Exception e)
    {
      panel.setError("error: "+e.getMessage());      
    }
  }
  
  private void doAddCredits(JComponent parent)
  {
    if (debug) System.out.println("Control.doAddCredits("+parent.getName()+")");
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent;
    
    JComboBox choice1 = (JComboBox)parent.getComponent(14);
    String name = (String)choice1.getSelectedItem();
    if (debug) System.out.println("name="+name);
    
    JComboBox choice2 = (JComboBox)parent.getComponent(16);
    String scredits = (String)choice2.getSelectedItem();
    if (debug) System.out.println("credits="+scredits);  
    
    try
    {
      int credits = Integer.parseInt(scredits);
      if (rmi) System.out.println("lib.addCredits("+name+", "+credits+")");
      panel.setMessage(lib.addCredits(name, credits));
    }
    catch (Exception e)
    {
      panel.setError("error: "+e.getMessage());     
    }
  }
  
  private void doLend(JComponent parent)
  {
    if (debug) System.out.println("Control.doLend("+parent.getName()+")");
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent; 
    
    JComboBox choice1 = (JComboBox)parent.getComponent(14);
    String name = (String)choice1.getSelectedItem();
    if (debug) System.out.println("name="+name);
    
    JComboBox choice2 = (JComboBox)parent.getComponent(16);
    String title = (String)choice2.getSelectedItem();
    if (debug) System.out.println("title="+title);   
    
    try
    {
      if (rmi) System.out.println("lib.lend("+name+", "+title+")");
      panel.setMessage(lib.lend(name, title));
    }
    catch (Exception e)
    {
      panel.setError("error: "+e.getMessage());     
    }
  }
  
  private void doUnlend(JComponent parent)
  {
    if (debug) System.out.println("Control.doUnlend("+parent.getName()+")");
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent;    
    JComboBox choice = (JComboBox)parent.getComponent(14);
    String title = (String)choice.getSelectedItem();
    System.out.println("title="+title); 
    
    try
    {
      if (rmi) System.out.println("lib.addCredits("+title+")");
      panel.setMessage(lib.unlend(title));
    }
    catch (Exception e)
    {
      panel.setError("error: "+e.getMessage());      
    }
  }
  
  private Set<String> allBooks()
  {
    if (debug) System.out.println("Control.allBooks()");
    try
    {
      if (rmi) System.out.println("lib.allBooks()");
      return lib.allBooks();
    }
    catch (Exception e)
    {
      return null;
    }   
  }
  
  private Set<String> allCustomers()
  {
    if (debug) System.out.println("Control.allCustomers()");
    try
    {
      if (rmi) System.out.println("lib.allCustomers()");
      return lib.allCustomers();
    }
    catch (Exception e)
    {
      return null;
    }   
  }*/
  
  private void doExit(JComponent parent)
  {
    if (debug) System.out.println("Control.doExit()");
    if (debug) printComponents(parent);     
    MyJTitlePanel panel = (MyJTitlePanel)parent;    
    
    try
    {
      lib.close();
      lib = null;    
      if (rmi) System.out.println("lib.close()");
      System.gc();
      System.runFinalization();
      
      panel.setMessage("message: ");
      panel.setError("error: ");
      myJApplet.getLayeredPane().add(new MyJLoginPanel(this));
    }
    catch (Exception e)
    {
      if (rmi) System.out.println("error: "+e.getMessage());     
    }
  }
  
  private void printComponents(JComponent parent)
  {
    System.out.println("Control.printComponents("+parent+")");
    Component[] component = parent.getComponents();
    for (int i=0; i<component.length; i++)
    {
      System.out.println("comp["+i+"]="+component[i]);
    }    
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("Control.finalize()"); 
  }
}
