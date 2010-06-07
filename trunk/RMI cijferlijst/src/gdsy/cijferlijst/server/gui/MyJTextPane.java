package gdsy.cijferlijst.server.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyJTextPane 
extends JTextPane
{
  private static final long serialVersionUID = 1L;
  private Color background = new Color(240, 240, 255);
   
  public MyJTextPane()
  {
    //System.out.println("MyJTextPane()");
    setName("MyJTextPane"); 
    setBackground(background);
    setEditable(true);
    setSelectionColor(background);
    setMargin(new Insets(10, 10, 10, 10));
    setRequestFocusEnabled(false);
  } 
  
  @Override
  public boolean getScrollableTracksViewportWidth()
  {
    return false;
  }
  
  @Override
  public boolean getScrollableTracksViewportHeight()
  {
    return false;
  }
  
  @Override
  public Dimension getPreferredSize()
  {
    //System.out.println("MyJTextpane.getpreferredSize()");
    Dimension d = super.getPreferredSize();
    return new Dimension(Math.max(1010, d.width), Math.max(431, d.height));
  }
    
  public void append(Color color, String str) 
  {
    //System.out.println("MyJTextPane.append("+color+", "+str+")");
    Document document = getDocument();
    if (document != null) 
    {
      if (document instanceof DefaultStyledDocument)
      {
        DefaultStyledDocument doc = (DefaultStyledDocument)document;
        try 
        {
          MutableAttributeSet attributes = new SimpleAttributeSet();
          StyleConstants.setForeground(attributes, color);
          StyleConstants.setFontFamily(attributes, "CourierNew");
          StyleConstants.setBold(attributes, false);
          StyleConstants.setItalic(attributes, false);
          StyleConstants.setFontSize(attributes, 14);
          doc.insertString(doc.getLength(), str+"", attributes);
          this.setCaretPosition(doc.getLength());
        } 
        catch (BadLocationException e)
        {
          // Never happens !
        }
      }
    }
  } 
}
