package gdsy.cijferlijst.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


class Utils {  
  private static final String scijferlijst = "Cijferlijst";
  
  @SuppressWarnings("unchecked")
  public static HashMap<String, Cijferlijst> getCijferlijst() {
	  System.out.println("Utils.getCijferlijst()");
	  
	  String filename = System.getProperty("user.dir")+File.separator+scijferlijst;
	  File file = new File(filename);
	  System.out.println("file="+file);
	  
	  if ( file.exists() && file.isFile() && file.canRead() && file.length()>0) {
		  FileInputStream fis = null;
		  ObjectInputStream ois = null;
		  try {
			  fis = new FileInputStream(file);
			  ois = new ObjectInputStream(fis);
			  HashMap<String, Cijferlijst> map = (HashMap<String, Cijferlijst>)ois.readObject();
			  printCijferlijst(map);
			  return map;
		  } catch (Exception ioe) {
			  System.out.println("error: "+ioe.getMessage());
			  return null;
		  }
		  
		  finally {
			  try {
				  if (ois != null) {
					  ois.close();
					  ois = null;
				  }
			  } catch (IOException e) {
				  System.out.println("error: "+e.getMessage());
			  }
			  
			  try {
				  if (fis != null) {
					  fis.close();
					  fis = null;
				  }
			  } catch (IOException e) {
				  System.out.println("error: "+e.getMessage());
			  }
		  }
	  }
	  return null;
  }
  
 
  
  public static void writeCijferlijst(HashMap<String, Cijferlijst> cijferlijst) {
	  System.out.println("Utils.writeCijferlijst()");
	  
	  printCijferlijst(cijferlijst);
	  String filename = System.getProperty("user.dir")+File.separator+scijferlijst;
	  File file    = new File(filename);
	  System.out.println("file="+file);
	  File filetmp = new File(filename+"tmp");
	  
	  FileOutputStream fos = null;
	  ObjectOutputStream oos = null;
	  try {
	      fos = new FileOutputStream(filetmp);  
	      oos = new ObjectOutputStream(fos);     
	      oos.writeObject(cijferlijst);    
	      oos.close();  
	      oos = null;
	      fos.close();
	      fos = null;
	      try {
	    	  delete(file);
	    	  rename(filetmp, file);
	      } catch (Exception e) {
	    	  System.out.println("error: "+e.getMessage());
	    	  e.printStackTrace();
	      }
	  } catch (Exception e) {
		  System.out.println("error: "+e.getMessage());
		  e.printStackTrace();
	  }
	  
	  finally {
		  try {
			  if (oos  != null) {
				  oos.close();
				  oos = null;
			  }
		  } catch (Exception e) {
			  System.out.println("error: "+e.getMessage());
			  e.printStackTrace();
		  }    
		  
		  try {
			  if (fos  != null) {
				  fos.close();
				  fos = null;
			  }
		  } catch (Exception e) {
			  System.out.println("error: "+e.getMessage());
			  e.printStackTrace();
		  }
	  }
  }
  

  private static void delete(File file) throws Exception {
	  if (!file.exists() || !file.isFile()) {
		  return;
	  }
	  
	  int i=10;
	  while (i > 0) {
		  try {
			  boolean delete = file.delete();          
			  if (delete) {
				  return;
			  }
		  } catch (Exception e) {       
			  System.out.println("error: "+e.getMessage());   
		  }
		  
		  i--;      
		  try { Thread.sleep(500); } catch (InterruptedException ie){}
	  }
	  throw new Exception("Utils.delete(): deleting file "+ file + " failed");
  }

  private static void rename(File file, File newFile) throws Exception {       
	  if (!file.exists() || !file.isFile()) {
		  return;
	  }
           
	  int i=10;
	  while (i > 0) {
		  try {
			  boolean rename = file.renameTo(newFile);          
			  if (rename) {
				  return;
			  }
		  } catch (Exception e) {       
			  System.out.println("error: "+e.getMessage());
		  }
		  
		  i--;     
		  try { Thread.sleep(500); } catch (InterruptedException ie){}
	  }
	  throw new Exception("DiskIO.rename(): renaming file "+ file + " failed");
  }
  
  private static void printCijferlijst(HashMap<String, Cijferlijst> map) {
	  System.out.println("\nUtils.printCijferlijst()");
	  for (String title : map.keySet()) {
		  System.out.println(map.get(title).getInfo());
	  } 
	  System.out.println("\n");
  }  
}
