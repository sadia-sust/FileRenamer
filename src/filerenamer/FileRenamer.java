package filerenamer;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class receives  algorithm choice.
 * According to choice it call different method
 * and rename the files
 */
 

public class FileRenamer{

    int choice,length;
    public UserInterface fileChoser;
    public String start;
    java.util.List<java.io.File> f = new ArrayList<>();
    java.util.List<java.io.File> resultFile = new ArrayList<>();
    java.util.List<java.io.File> temporaryFile = new ArrayList<>();
    /**
     * This is the constructor method for the class FileRenamer. It initializes some
     * variable and revives UserInterface class Object reference.
     *
     * @param f This receives the UserInterface Object reference.
     */
    public FileRenamer(UserInterface f)
    {
        fileChoser = f;
        
    }
    void setChoice(int algoChoice){
        choice=algoChoice;
    }
     /**
     * This starts the renaming process which is called in the applyAction method in
     * UserInterface class.
     */
    public void start(){
        if(fileChoser.isRenamed && fileChoser.isFilter==false)
        {
           
           f.clear();
           for(File file : resultFile)
           {
               f.add(file);
              
           }
           
        }
        else if(fileChoser.isFilter)
        {
            f.clear();
            for(File file : fileChoser.info.filteredFile)
           {
               f.add(file);
             
           }
        }
        
        else
        {
                 f.clear();
                 for(File file : fileChoser.info.extensionFile)
                 {
                  f.add(file);
        
                 }
        }
        try
        {
           reName();
        }catch(Exception ex)
        {
           // Logger.getLogger(FileRenamer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * filters renamed files
     * @throws Exception 
     */
    void afterRenamingFilter() throws Exception{
        fileChoser.info.filteredFile.clear();
        File file;
        int row;
        row = fileChoser.model.getRowCount();
            for (int i = 0; i < row; i++) {
                if (fileChoser.model.getValueAt(i, 0) == Boolean.TRUE) {
                    file = resultFile.get(i);
                    fileChoser.info.filteredFile.add(file);
                }
            }
        fileChoser.info.clearRow();
        for(File file2 : fileChoser.info.filteredFile){
           
            fileChoser.model.addRow(new Object[] {true,file2.getName(),null});
            
        }
        resultFile.clear();
        for(File file2 : fileChoser.info.filteredFile){
            resultFile.add(file2);
            
        }
        
    }
    
    /**
     * this method shows renamed file
     * and again list the all the files
     * of that directory
     * @throws Exception 
     */
    
    void showRenamedFile() throws Exception
    {
        fileChoser.info.clearRow();
        for(File file : resultFile){
           
            fileChoser.model.addRow(new Object[] {true,file.getName(),"success"});
            
        }
        fileChoser.isRenamed = true;
            
        fileChoser.info.listAll();
    }
     /**
     * this method previews renamed file
     * 
     * @throws Exception 
     */
    void showPreviewFile()throws Exception{
        fileChoser.info.clearRow();
        File tmp;
        int i=0;
        for(File file : temporaryFile){
           
            tmp = f.get(i);
            fileChoser.model.addRow(new Object[] {true,tmp.getName(),file.getName()});
            i++;
            
        }
       
    }
    /**
     * this method creates an object of Letter class
     * and call renameAllFile method if all file have to rename
     * or call renameSpecificFile method if specific file
     * have to rename by alphabetically
     * after renaming it call showPreviewFile
     * if user want to preview the renamed files
     * or call showRenamedFile to show renames files
     * @throws Exception 
     */
    void renameToLetter() throws Exception{
        
        temporaryFile.clear();
        Letter alphabet = new Letter(fileChoser,f);
        if(fileChoser.filetyp.equals(".*"))
        {
            temporaryFile =alphabet.renameAllFile();
        }
        else
        {
            temporaryFile = alphabet.renameSpecificFile();
            
        }
       if(fileChoser.isPreview)
       {
           showPreviewFile();
       }
       else{
           resultFile.clear();
           for(File file: temporaryFile)
               resultFile.add(file);
           showRenamedFile();
       }
      
        
    }
     /**
     * this method creates an object of Number class
     * and call renameAllFile method if all file have to rename
     * or call renameSpecificFile method if specific file
     * have to rename by neumerically
     * after renaming it call showPreviewFile
     * if user want to preview the renamed files
     * or call showRenamedFile to show renames files
     * @throws Exception 
     */
    void renameToNumber() throws Exception{
     
         temporaryFile.clear();
        Number num = new Number(fileChoser,f);
        if(fileChoser.filetyp.equals(".*"))
        {
           temporaryFile =num.renameAllFile();
        }
        else
        {
            temporaryFile=num.renameSpecificFile();
            
        }
      if(fileChoser.isPreview)
       {
           showPreviewFile();
       }
       else{
           resultFile.clear();
           for(File file: temporaryFile)
               resultFile.add(file);
           showRenamedFile();
       }
        
    }
     /**
     * this method creates an object of Insert class
     * and call insertPrefixAllFile method if all file have to rename
     * or call insertPrefixSpecificFile method if specific file
     * have to rename inserting prefix
     * after renaming it call showPreviewFile
     * if user want to preview the renamed files
     * or call showRenamedFile to show renames files
     * @throws Exception 
     */
    void insertPrefix() throws Exception{
       
         temporaryFile.clear();
        Insert ob = new Insert(fileChoser,f);
        if(fileChoser.filetyp.equals(".*"))
        {
           
           temporaryFile=ob.insertPrefixAllFile();
        }
        else
        {
           
            temporaryFile=ob.insertPrefixSpecificFile();
            
        }
       if(fileChoser.isPreview)
       {
           showPreviewFile();
       }
       else{
            resultFile.clear();
           for(File file: temporaryFile)
               resultFile.add(file);
           showRenamedFile();
       }
        
    }
     /**
     * this method creates an object of Insert class
     * and call insertSuffixAllFile method if all file have to rename
     * or call insertSuffixSpecificFile method if specific file
     * have to rename inserting suffix
     * after renaming it call showPreviewFile
     * if user want to preview the renamed files
     * or call showRenamedFile to show renames files
     * @throws Exception 
     */
     void insertSuffix() throws Exception{
        //start = start.trim();
          temporaryFile.clear();
        Insert ob = new Insert(fileChoser,f);
        if(fileChoser.filetyp.equals(".*"))
        {
           
           temporaryFile=ob.insertSuffixAllFile();
        }
        else
        {
           
            temporaryFile=ob.insertSuffixSpecificFile();
            
        }
      if(fileChoser.isPreview)
       {
           showPreviewFile();
       }
       else{
            resultFile.clear();
           for(File file: temporaryFile)
               resultFile.add(file);
           showRenamedFile();
       }
        
    }
      /**
     * this method creates an object of Insert class
     * and call insertPrefixSuffixAllFile method if all file have to rename
     * or call insertPrefixSuffixSpecificFile method if specific file
     * have to rename inserting prefix and suffix
     * after renaming it call showPreviewFile
     * if user want to preview the renamed files
     * or call showRenamedFile to show renames files
     * @throws Exception 
     */
      void insertPrefixSuffix() throws Exception{
        
        Insert ob = new Insert(fileChoser,f);
        temporaryFile.clear();
        if(fileChoser.filetyp.equals(".*"))
        {
           
           temporaryFile=ob.insertPrefixSuffixAllFile();
        }
        else
        {
           
            temporaryFile =ob.insertPrefixSuffixSpecificFile();
            
        }
      if(fileChoser.isPreview)
       {
           showPreviewFile();
       }
       else{
            resultFile.clear();
           for(File file: temporaryFile)
               resultFile.add(file);
           showRenamedFile();
       }
        
    }
    
     /**
      * this method will call specific method according to choice
      * @throws Exception 
      */
    void reName() throws Exception{
        if(choice==1){
            renameToNumber();
        }
        else if(choice==2){
            renameToLetter();
        }
        else if(choice==3){
            insertPrefixSuffix();
        }
        else if(choice==4){
            insertPrefix();
        }
        else if(choice == 5){
            insertSuffix();
        }
            
    }
    
 
    
}
