package filerenamer;

import java.io.File;
import java.util.ArrayList;

/**
 * This class receives directory path .It generates list of
 * all files of the directory and gathers required information
 *
 */
public class Data {
    UserInterface f;
    java.util.List<java.io.File> totFile = new ArrayList<>();
    java.util.List<java.io.File> extensionFile = new ArrayList<>();
    java.util.List<java.io.File> filteredFile = new ArrayList<>();
    int length;
    String extension;
    
    /**
     * This is the constructor method for the class Data. It initializes some
     * variable and revives UserInterface class Object reference.
     *
     * @param f This receives the UserInterface Object reference.
     */
    
    Data(UserInterface f)
    {
        this.f=f;
    }
    
    /**
     * this method clears the row
     * of jtable
     */
    
    void clearRow()
    {
        f.model.setRowCount(0);
    }
    
    /**
     * This method traverses the all files from selected directory recursively
     * and collect informations.
     */
    
    void listAll() throws Exception
    {
         File directory = new File(f.pathName);
         File[] tmpList = directory.listFiles();
         totFile.clear();
         for (File file : tmpList) {
            if (file.isFile()) {
               totFile.add(file);
            }
        }
    }
    
    /**
     * list only one file
     */
    
    void listOne(){
        totFile.clear();
        totFile.add(f.fileName);
       // extensionFile.add(f.fileName);
    }
    /**
     * this method shows all file 
     * which was listed in listAll method
     * @param extensionFile it will store all files
     * if user chooses all file extension
     *
     */
    
    void showAllFile()
    {
        clearRow();
        extensionFile.clear();
        for(File file : totFile){
            extensionFile.add(file);
           
            f.model.addRow(new Object[] {true,file.getName(),null});
            
        }
      
    }
 
    /**
     * this method shows all file 
     * of a specific extension
     * @param extensionFile it will store specific files
     * if user chooses any specific file extension
     *
     */
    
    void specificExtension(){
        String fileName;
        extensionFile.clear();
        extension = f.filetyp;
        for(File file: totFile)
        {
            fileName = file.getName();
            if( fileName.endsWith(extension))
            {
                extensionFile.add(file);
            }
                
        }
        clearRow();
        for(File file : extensionFile){
            
            f.model.addRow(new Object[] {true,file.getName(),null});
            
        }
    }
    
    /**
     * this method filters all file 
     * of extensionFile array if user can include,exclude
     * any file
     * @param filteredFile it will store filtered files
     *
     */
    
    void filter(){
        filteredFile.clear();
        File file;
        int row;
        row = f.model.getRowCount();
            for (int i = 0; i < row; i++) {
                if (f.model.getValueAt(i, 0) == Boolean.TRUE) {
                    file = extensionFile.get(i);
                    filteredFile.add(file);
                }
            }
        clearRow();
        for(File file2 : filteredFile){
           
            f.model.addRow(new Object[] {true,file2.getName(),null});
            
        }
    }
   
   
}
