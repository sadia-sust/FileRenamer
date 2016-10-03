/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filerenamer;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Sadia
 */
public class Insert {
    java.util.List<java.io.File> processedFile = new ArrayList<>();
    java.util.List<java.io.File> finalFile = new ArrayList<>();
    int start,pos;
    String extension,tmp,process,subStr,preStr,sufStr,name;
    File tmpFile,processFile;
    UserInterface f;
    //boolean addPrefix = false ,addSuffix = false;
    /**
     * This is the constructor method for the class Insert. It initializes some
     * variable and revives UserInterface class Object reference.
     *
     * @param f This receives the UserInterface Object reference.
     * @param fl this receives the file list which have to rename
     */
    Insert(UserInterface f,java.util.List<java.io.File> fl)
    {
        this.f = f;
        processedFile=fl;
       
    }
    /**
     * this method rename all file inserting prefix,suffix
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> insertPrefixSuffixAllFile() throws Exception
    {
        
        preStr = f.insertPrefix.getText();
        preStr = preStr.trim();
      
        sufStr = f.insertSuffix.getText();
        sufStr = sufStr.trim();
        
        int pos2;
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
            pos=process.lastIndexOf('\\');
            subStr=process.substring(0,pos+1);
            pos2=process.lastIndexOf('.');
           // subStr=process.substring(0,pos);
            name = process.substring(pos+1, pos2);
            extension=process.substring(pos2); 
            //tmp=subStr+start+extension;
           // name = process.substring(pos+1, pos);
            tmp = subStr+preStr+name+sufStr+extension;
          
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
           
        }
      
        return finalFile;
    }
    /**
     * this method rename specific file inserting prefix,suffix
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> insertPrefixSuffixSpecificFile() throws Exception
    {
        preStr = f.insertPrefix.getText();
        preStr = preStr.trim();
        sufStr = f.insertSuffix.getText();
        sufStr = sufStr.trim();
        int pos2;
        extension = f.filetyp;
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
            pos=process.lastIndexOf('\\');
            break;
        }
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
           // 0 pos=process.lastIndexOf('\\');
            subStr=process.substring(0,pos+1);
            pos2=process.lastIndexOf('.');
           // subStr=process.substring(0,pos);
            name = process.substring(pos+1, pos2);
            extension=process.substring(pos2); 
            //tmp=subStr+start+extension;
           // name = process.substring(pos+1, pos);
            tmp = subStr+preStr+name+sufStr+extension;
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
        }
        return finalFile;
    }
    /**
     * this method rename all file inserting prefix
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> insertPrefixAllFile() throws Exception
    {
         preStr = f.insertPrefix.getText();
         preStr = preStr.trim();
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
            pos=process.lastIndexOf('\\');
            subStr=process.substring(0,pos+1);
            //pos=process.lastIndexOf('.');
           // extension=process.substring(pos); 
           // tmp=subStr+start+extension;
            tmp = subStr+preStr+oldFile.getName();
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
           
        }
        return finalFile;
    }
    /**
     * this method rename all file inserting suffix
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> insertSuffixAllFile() throws Exception
    {
        sufStr = f.insertSuffix.getText();
        sufStr = sufStr.trim();
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
           // pos=process.lastIndexOf('\\');
            //subStr=process.substring(0,pos+1);
            pos=process.lastIndexOf('.');
            subStr=process.substring(0,pos);
            extension=process.substring(pos); 
            //tmp=subStr+start+extension;
            tmp = subStr+sufStr+extension;
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
           
        }
        return finalFile;
    }
    /**
     * this method rename specific file inserting prefix
     * @return renamed files
     * @throws Exception 
     */
    java.util.List<java.io.File> insertPrefixSpecificFile() throws Exception
    {
        preStr = f.insertPrefix.getText();
        preStr = preStr.trim();
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
            pos=process.lastIndexOf('\\');
            break;
        }
        for(File oldFile : processedFile)
        {
            subStr=oldFile.getAbsolutePath().substring(0,pos+1);
            tmp=subStr+preStr+oldFile.getName();
            
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
        }
        return finalFile;
    }
    /**
     * this method rename specific file inserting suffix
     * @return renamed files
     * @throws Exception 
     */
      java.util.List<java.io.File> insertSuffixSpecificFile() throws Exception
    {
        sufStr = f.insertSuffix.getText();
        sufStr = sufStr.trim();
        for(File oldFile : processedFile)
        {
            process=oldFile.getAbsolutePath();
           // pos=process.lastIndexOf('\\');
            //subStr=process.substring(0,pos+1);
            pos=process.lastIndexOf('.');
            subStr=process.substring(0,pos);
            extension=process.substring(pos); 
            //tmp=subStr+start+extension;
            tmp = subStr+sufStr+extension;
            tmpFile = new File(tmp);
            if(f.isPreview==false)
            oldFile.renameTo(tmpFile);
            finalFile.add(tmpFile);
           
        }
        return finalFile;
    }
    
}
