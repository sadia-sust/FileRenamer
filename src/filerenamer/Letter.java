package filerenamer;

import java.io.File;
import java.util.ArrayList;

/**
 * this class rename the files alphabetically
 */
public class Letter {
    
    java.util.List<java.io.File> processedFile = new ArrayList<>();
    java.util.List<java.io.File> finalFile = new ArrayList<>();
    int pos,i=0;
    String start;
    String extension,tmp,process,subStr,preStr,sufStr;
    File tmpFile,processFile;
    UserInterface f;
     boolean addPrefix = false ,addSuffix = false;
     /**
     * This is the constructor method for the class Letter. It initializes some
     * variable and revives UserInterface class Object reference.
     *
     * @param f This receives the UserInterface Object reference.
     * @param fl this receives the file list which have to rename
     */
    Letter(UserInterface f,java.util.List<java.io.File> fl){
        processedFile=fl;
        this.f=f;
        
    }
    /**
     * it generates one length alphabetical string 
     * @return generated one length string
     */
    String oneLength(){
        String name="";
        char ch;
        ch = start.charAt(0);
        if(ch == 'z')
        {
            name="aa";
        }     
        else{
           
            ch++;
            name+=ch;
       
            
        }
        start=name;
        return name;
    }
     /**
     * it generates two length alphabetical string 
     * @return generated two length string
     */
    String twoLength(){
        String name="";
        char ch;
        if(start=="zz")
        {
            name = "aaa";
        }
        else
        {
            ch = start.charAt(1);
            if(ch!='z'){
                 name+=start.charAt(0);
                 ch = start.charAt(1);
                 ch++;
                 name+=ch;
            }
            else{
               ch = start.charAt(0);
               ch++;
               name+=ch+"a";
            }
        }
        start=name;
        return name;
    }
     /**
     * it generates three length alphabetical string 
     * @return generated three length string
     */
     String threeLength(){
        String name="";
        char ch1,ch2,ch0;
        if(start=="zzz")
        {
            name = "aaaa";
        }
        else
        {
            ch1=start.charAt(1);
            ch2 = start.charAt(2);
            if(ch1=='z' && ch2=='z'){
                ch0=start.charAt(0);
                ch0++;
                name+=ch0+"aa";
                
            }
            else{
              //ch = start.charAt(1);
                if(ch2=='z'){
                 name+=start.charAt(0);  
                 ch1++;
                 name+=ch1+"a";
                 }
                else{
                  name+=start.substring(0,1);
                  ch2++;
                  name+=ch2;
               }
              
            }
        }
        start=name;
        return name;
    }
     /**
      * creates next alphabetical string
      * @return generated string
      */
    String increment(){
        String name="";
        i++;
        if(i==1)
        return start;
        else
        {
            if(start.length()==1)
                name = oneLength();
            else if(start.length()==2)
            {
                name = twoLength();
            }
            else if(start.length()==3)
            {
                name = threeLength();
            }
            return name;
        }
    }
    /**
     * this method rename all file according to choice
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> renameAllFile() throws Exception{
       // String name;
        start = f.letterIncrement.getValue().toString();
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
            tmp += increment();
            if(addSuffix)
                tmp+=sufStr;
            tmp+=extension;
           // name = increment();
            //tmp=subStr+name+extension;
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
           
        }
       
        return finalFile;
    }
    
    
    /**
     * this method rename specific file according to choice
     * @return renamed files
     * @throws Exception 
     */
    
    java.util.List<java.io.File> renameSpecificFile() throws Exception{
       // String name;
        start = f.letterIncrement.getValue().toString();
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
            tmp = oldFile.getAbsolutePath().substring(0,pos+1);
            if(addPrefix)
                tmp+=preStr;
            tmp += increment();
            if(addSuffix)
                tmp+=sufStr;
            tmp+=extension;
            //tmp=subStr+name+extension;
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
        }
       
        return finalFile;
    }
    
    
}
