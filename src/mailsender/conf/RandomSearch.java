/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailsender.conf;

import java.io.File;
import java.util.Random;

/**
 *
 * @author Aydin
 */
public class RandomSearch {
    
        String[] file_list;
//        String PATH_F = "C:\\Users\\Aydin\\Documents\\NetBeansProjects\\PinguMail\\src\\mailsender\\attack\\";
//        File folder = new File("..");
//        File file_folder = "C:\\Users\\Aydin\\Documents\\NetBeansProjects\\PinguMail\\src\\mailsender\\attack\\";



        
	public String senderFileName() {
            int fayillarin_sayi = new RandomSearch().listFileSize();
            int index = new RandomSearch().randomWhile(fayillarin_sayi);
         
            String name = new RandomSearch().listFiles(index);
               
            return name;
        }
        
        public int randomWhile(int j){
                    Random randNumber = new Random();
                    int iNumber = randNumber.nextInt(j) + 0;
                    return iNumber;
        }
        
        public String listFiles(int index){
            
            String name = "";
            
              File folder = new File("C:\\Users\\Aydin\\Documents\\NetBeansProjects\\PinguMail\\src\\mailsender\\attack\\");
              File[] listOfFiles = folder.listFiles();

//                for (File file : listOfFiles) {
                        File file = listOfFiles[index];
                   if (file.isFile()) {
                       name = file.getName();
                   }
//                }
                
                return name;
        }
        
        public int listFileSize(){
            String name = "";
            
              File folder = new File("C:\\Users\\Aydin\\Documents\\NetBeansProjects\\PinguMail\\src\\mailsender\\attack\\");
              File[] listOfFiles = folder.listFiles();
              int i = listOfFiles.length;
        
            return i;
        }
}
    