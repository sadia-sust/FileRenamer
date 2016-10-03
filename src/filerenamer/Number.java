package filerenamer;

import java.io.File;
import java.util.ArrayList;

/**
 * this class rename the files neumerically
 */
public class Number {
    java.util.List<java.io.File> processedFile = new ArrayList<>();
    java.util.List<java.io.File> finalFile = new ArrayList<>();
    int start,pos,increase;
    String extension,tmp,process,subStr,preStr,sufStr;
    File tmpFile,processFile;
    UserInterface f;
    boolean addPrefix = false ,addSuffix = false ;
    /**
     * This is the constructor method for the class Number. It initializes some
     * variable and revives UserInterface class Object reference.
     *
     * @param f This receives the UserInterface Object reference.
     * @param fl this receives the file list which have to rename
     */
    Number(UserInterface f,java.util.List<java.io.File> fl)
    {
        this.f=f;
        processedFile=fl;
    }
    /**
     * this method rename all file according to choice
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> renameAllFile() throws Exception
    {
        increase = Integer.parseInt(f.stepSize.getValue().toString());
        start = Integer.parseInt(f.numberIncrement.getValue().toString());
        
        if(f.prefix.isSelected())
        {
            
            preStr = f.insertPrefix.getText();
            preStr = preStr.trim();
            if(preStr.equals("")==false)
            {
                addPrefix = true;
            }
        }
        if(f.suffix.isSelected())
        {
            
            sufStr = f.insertSuffix.getText();
            sufStr = sufStr.trim();
            if(sufStr.equals("")==false)
            {
              addSuffix = true;
            }
        }
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
            pos=process.lastIndexOf('\\');
            subStr=process.substring(0,pos+1);
            pos=process.lastIndexOf('.');
            extension=process.substring(pos); 
            tmp = subStr;
            if(addPrefix)
                tmp+=preStr;
            tmp+=start;
            if(addSuffix)
                tmp+=sufStr;
            tmp+=extension;
          
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
            start+=increase;
           
        }
        return finalFile;
    }
    /**
     * this method rename specific file according to choice
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> renameSpecificFile() throws Exception
    {
        increase = Integer.parseInt(f.stepSize.getValue().toString());
        start = Integer.parseInt(f.numberIncrement.getValue().toString());
        extension = f.filetyp;
        if(f.prefix.isSelected())
        {
            
            preStr = f.insertPrefix.getText();
            preStr = preStr.trim();
            if(preStr.equals("")==false)
            {
                addPrefix = true;
            }
        }
        if(f.suffix.isSelected())
        {
            
            sufStr = f.insertSuffix.getText();
            sufStr = sufStr.trim();
            if(sufStr.equals("")==false)
            {
              addSuffix = true;
            }
        }
        
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
            pos=process.lastIndexOf('\\');
            break;
        }
        for(File oldFile : processedFile)
        {
            subStr=oldFile.getAbsolutePath().substring(0,pos+1);
            tmp = subStr;
            if(addPrefix)
                tmp+=preStr;
            tmp+=start;
            if(addSuffix)
                tmp+=sufStr;
            tmp+=extension;
            //tmp=subStr+start+extension;
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
            start+=increase;
        }
       
        return finalFile;
    }
    
}
