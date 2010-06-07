package gdsy.cijferlijst.server.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class MyJTextField 
extends JTextField
implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private Font font = new Font("monospaced", Font.PLAIN, 12);
  
  public MyJTextField(String cmd, String text, int columns, boolean editable, ActionListener al)
  {
    super(text, columns);
    //System.out.println("MyJTextField("+cmd+","+text+", "+columns+", "+editable+", "+al+")");
    setFont(font);
    setEditable(editable);
    setActionCommand(cmd);
    addActionListener(al);
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0)
  {
    File file = fireJFileChooser();
    if (file != null)
    {
      String oldPath = getText();
      String newPath = file.getPath();
      if (!oldPath.equals(newPath))
      {
        setText(newPath);
        fireActionPerformed();
      }
    } 
  }
  
  private File fireJFileChooser()
  {
    File currentDirectory = new File(getText());
    System.out.println("currentDirectory="+currentDirectory);
    FileSystemView fsv = FileSystemView.getFileSystemView(); 
    JFileChooser chooser = new JFileChooser(currentDirectory, fsv);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setFileHidingEnabled(true);
    int returnVal = chooser.showOpenDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION) 
    {
      File file = chooser.getSelectedFile();
      return file;
    }
    return null;
  }
}
