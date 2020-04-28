package file_handling.character_stream;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderDemo {

	public static void main(String[] args) {
		try(FileReader fr = new FileReader("resource/temp.txt");
				FileWriter fw = new FileWriter("resource/temp4.txt")){
			BufferedReader br = new BufferedReader(new CharArrayReader("Hello All, welcome!!".toCharArray()));
			
			String line = null;
			while((line = br.readLine()) != null){
				fw.write(line);
			}
		}catch(IOException io){
			System.out.println("IO Error" + io);
		}
	}
}
