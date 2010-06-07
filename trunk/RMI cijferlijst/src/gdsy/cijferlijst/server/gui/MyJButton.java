package gdsy.cijferlijst.server.gui;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class MyJButton extends JButton
{
  private static final long serialVersionUID = 1L;

  public MyJButton(Icon icon, String cmd, boolean enabled, ActionListener al)
  {
    super(icon);
    //System.out.println("MyJButton("+icon+", "+cmd+", "+al+")");
    setMargin(new Insets(0,0,0,0));
    setActionCommand(cmd);
    setEnabled(enabled);
    addActionListener(al);
  }
}
