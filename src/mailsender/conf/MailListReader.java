/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailsender.conf;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Aydin
 */
public class MailListReader {
    
   public int mail_list_size( String file_name){

		File list_file = new File(file_name);
		char verilenler[] = new char[(int) list_file.length()];
		int verilenler_olcusu = verilenler.length;
		String oturulecek=" ";
		int list_size = 0;

		try{

			FileReader fr = new FileReader(list_file);
			fr.read(verilenler);

			// String oxunan = new String(verilenler);
			// String[] arrOfStr = oxunan.split("\n");
			String[] arrOfStr = new String(verilenler).split("\n");

			list_size = arrOfStr.length;
		
			// oturulecek = arrOfStr[mail_index];

			// int i = 2;
			// System.out.println(arrOfStr[i]); 
		
		}
		catch(Exception e){
		   	e.printStackTrace();
		}

		return  list_size;

	}
    
    public String mail_list_reader( String file_name, int mail_index){

		File list_file = new File(file_name);
		char verilenler[] = new char[(int) list_file.length()];
		//int verilenler_olcusu = verilenler.length;
		String oturulecek=" ";

		try{

			FileReader fr = new FileReader(list_file);
			fr.read(verilenler);

			// String oxunan = new String(verilenler);
			// String[] arrOfStr = oxunan.split("\n");
			String[] arrOfStr = new String(verilenler).split("\n");


//			System.out.println(arrOfStr[0]);
			oturulecek = arrOfStr[mail_index];

			// int i = 2;
			// System.out.println(arrOfStr[i]); 
		
		}
		catch(IOException e){
                    e.printStackTrace();
		}

		return  oturulecek;

	}
    
}
