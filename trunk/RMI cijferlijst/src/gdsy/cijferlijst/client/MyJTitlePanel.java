package gdsy.cijferlijst.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

class MyJTitlePanel extends JPanel {
  private static final long serialVersionUID = 1L;
  
  private static int  d = 0; // resolution
  private static int  w = 0; // Panel width
  private static int  h = 0; // Panel height
  private static int  s = 0; // Panel split  
  private static int  b = 0; // border
  private static int aw = 0; // horizontal diameter
  private static int ah = 0; // vertical diameter

  protected static int mx = 0;
  protected static int my = 0;
  protected static int mw = 0;
  protected static int mh = 0;
  
  protected static int sx = 0;
  protected static int sy = 0;
  protected static int sw = 0;
  protected static int sh = 0;
    
  private static MyJLabel title   = null; 

  private boolean loginScherm = false;
  private boolean debug = false;

  MyJTitlePanel()
  {
    if (debug) System.out.println("MyJTitlePanel()");
    init();
  }
  
  MyJTitlePanel(boolean loginScherm, int width, int height)
  {
    if (debug) System.out.println("MyJTitlePanel("+width+", "+height+")");
    
    this.loginScherm = loginScherm;
    
    int d1 = width/16;
    int d2 = height/9;
    d  = (d1+d2)/2; // resolution   
    w  = width;     // Panel width
    h  = height;    // Panel height
    //s  = 5*d;       // Panel split  
    b  = d/4;       // border
    aw = 10;       // horizontal diameter
    ah = 10;       // vertical diameter

    //mx = 3*b;
    //my = 3*d/2+4*b;
    //mw = s-5*b;
    //mh = h-5*d/2-8*b;
    
    //sx = s+2*b;
    //sy = 3*d/2+4*b;
    //sw = w-s-5*b;
    //sh = h-5*d/2-8*b;
    
    Rectangle t = new Rectangle(0,   0, w, 30);
    
    title   = new MyJLabel("RMI CIJFERLIJST", JLabel.CENTER, t);
    init();
  }
  
  private void init()
  {
    if (debug) System.out.println("MyJTitlePanel.init()");
    setLayout(null);
    setSize(w, h);
    add(title);       
  }
  
  public void setTitle (String text) {
	  MyJTitlePanel.title.setText(text);
  }
  
  void setMessage(String text)
  {
    if (debug) System.out.println("MyJTitlePanel.setMessage("+text+")");
    // TODO
  }
  
  void setError(String text)
  {
    if (debug) System.out.println("MyJTitlePanel.setError("+text+")");
    // TODO
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    if (debug) System.out.println("MyJTitlePanel.paintComponent("+g.getClass().getName()+")");
    // grijze achtergrond
    g.setColor(new Color(238, 238, 238));
    g.fillRect(0, 0, w, h);
    
    // titelbalk
    g.setColor(new Color(212, 208, 200));
    g.fillRoundRect(0, 0, w-1, 30, aw, ah);
    g.setColor(new Color(144,143,140));
    g.drawRoundRect(0, 0, w-1, 30, aw, ah);
    
    if (loginScherm) {
    	//body
    	g.setColor(new Color(212, 208, 200));
        g.fillRoundRect(0, 40, w-1, h-80, aw, ah);
        g.setColor(new Color(144,143,140));
        g.drawRoundRect(0, 40, w-1, h-80, aw, ah);

    	//footer
    	g.setColor(new Color(212, 208, 200));
        g.fillRoundRect(0, h-31, w-1, 30, aw, ah);
        g.setColor(new Color(144,143,140));
        g.drawRoundRect(0, h-31, w-1, 30, aw, ah);
    } else {
    	//body
    	g.setColor(new Color(212, 208, 200));
        g.fillRoundRect(0, 40, w-1, h-120, aw, ah);
        g.setColor(new Color(144,143,140));
        g.drawRoundRect(0, 40, w-1, h-120, aw, ah);

    	//footer 1
    	g.setColor(new Color(212, 208, 200));
        g.fillRoundRect(0, h-71, w-1, 30, aw, ah);
        g.setColor(new Color(144,143,140));
        g.drawRoundRect(0, h-71, w-1, 30, aw, ah);

    	//footer 2
    	g.setColor(new Color(212, 208, 200));
        g.fillRoundRect(0, h-31, w-1, 30, aw, ah);
        g.setColor(new Color(144,143,140));
        g.drawRoundRect(0, h-31, w-1, 30, aw, ah);
    }
  }
  
  /***************************************************************************
   * finalize
   ***************************************************************************/
  @Override
  protected void finalize()
  throws Throwable
  {
    System.out.println("MyJTitlePanel.finalize()"); 
  }
}