package file_handling.byte_stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws FileNotFoundException {
		int c;
		InputStream input = null;
//		input = new SequenceInputStream(new FileInputStream("resource/temp.txt"), new FileInputStream("resource/temp1.txt"));
		
		Vector<String> files = new Vector<String>();
		files.addElement("resource/temp.txt");
		files.addElement("resource/temp1.txt");
		files.addElement("resource/temp2.txt");
		
		InputStreamEnumerator ise =  new InputStreamEnumerator(files);
		input = new SequenceInputStream(ise);
		
		try{
			while((c = input.read()) != -1){
				System.out.print((char)c);
			}
		}catch (NullPointerException npe) {
			System.out.println("Error Opening file." + npe);
		}catch (IOException ioe) {
			System.out.println("IO Exception: " + ioe);
		}finally{
			try{
				input.close();
			}catch(IOException e){
				System.out.println("Error while closing SequenceInputStream");
			}
		}
	}

}
