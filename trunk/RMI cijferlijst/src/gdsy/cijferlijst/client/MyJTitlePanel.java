package gdsy.cijferlijst.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

class MyJTitlePanel
extends JPanel
{
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
  private static MyJLabel message = null;
  private static MyJLabel error   = null;
  private static MyJLabel footer  = null;
  private boolean debug = false;

  MyJTitlePanel()
  {
    if (debug) System.out.println("MyJTitlePanel()");
    init();
  }
  
  MyJTitlePanel(int width, int height)
  {
    if (debug) System.out.println("MyJTitlePanel("+width+", "+height+")");
    int d1 = width/16;
    int d2 = height/9;
    d  = (d1+d2)/2; // resolution   
    w  = width;     // Panel width
    h  = height;    // Panel height
    s  = 5*d;       // Panel split  
    b  = d/4;       // border
    aw = d/2;       // horizontal diameter
    ah = d/2;       // vertical diameter

    mx = 3*b;
    my = 3*d/2+4*b;
    mw = s-5*b;
    mh = h-5*d/2-8*b;
    
    sx = s+2*b;
    sy = 3*d/2+4*b;
    sw = w-s-5*b;
    sh = h-5*d/2-8*b;
    
    Rectangle t = new Rectangle(2*b,   2*b    , w-4*b, d  );
    Rectangle m = new Rectangle(2*b,   2*b+d  , w-4*b, d/2);
    Rectangle e = new Rectangle(2*b, h-2*b-d  , w-4*b, d/2);
    Rectangle f = new Rectangle(2*b, h-2*b-d/2, w-4*b, d/2);
    
    title   = new MyJLabel("ABC-LIBRARY", JLabel.CENTER, t); 
    message = new MyJLabel("message: "  , JLabel.LEFT  , m);
    error   = new MyJLabel("error: "    , JLabel.LEFT  , e);
    footer  = new MyJLabel("efg"        , JLabel.RIGHT , f);
    init();
  }
  
  private void init()
  {
    if (debug) System.out.println("MyJTitlePanel.init()");
    setLayout(null);
    setSize(w, h);
    add(title);
    add(message);
    add(error);
    add(footer);        
  }
  
  void setMessage(String text)
  {
    if (debug) System.out.println("MyJTitlePanel.setMessage("+text+")");
    message.setText(text);
  }
  
  void setError(String text)
  {
    if (debug) System.out.println("MyJTitlePanel.setError("+text+")");
    int index = text.lastIndexOf("ion:");   
    if (index > 0)
    {
      error.setText(text.substring(index+4));
    }
    else
    {
      error.setText(text);      
    }
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    if (debug) System.out.println("MyJTitlePanel.paintComponent("+g.getClass().getName()+")");
    g.setColor(new Color(240, 240, 255));
    g.fillRect(0, 0, w, h);
    g.setColor(Color.BLUE);
    g.drawRoundRect(  b, b, w-2*b, h-2*b, aw, ah);
    g.drawRoundRect(2*b, 3*d/2+3*b,   s-3*b, h-5*d/2-6*b, aw, ah);
    g.drawRoundRect(s+b, 3*d/2+3*b, w-s-3*b, h-5*d/2-6*b, aw, ah);    
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