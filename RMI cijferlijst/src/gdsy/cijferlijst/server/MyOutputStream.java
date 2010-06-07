package gdsy.cijferlijst.server;

import java.awt.Color;
import java.io.OutputStream;

public class MyOutputStream
extends OutputStream
{
  private Control control = null;

  public MyOutputStream(Control newControl)
  {
    control = newControl;
  }

  @Override
  public void write(int b)
  {
    if (control != null) control.log(100, Color.BLACK, "" + (char) b);
  }

  @Override
  public void write(byte[] b, int off, int len)
  {
    if (control != null) control.log(100, Color.BLACK, "" + new String(b, off, len));
  }
}
