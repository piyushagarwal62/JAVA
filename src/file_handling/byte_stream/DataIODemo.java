package file_handling.byte_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIODemo {

	public static void main(String[] args) {
		
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("resource/data.txt"));){
			dout.writeInt(2343);
			dout.writeDouble(12.23);
			dout.writeBoolean(true);
			dout.writeChar('=');
		}catch(FileNotFoundException fe){
			System.out.println("cannot open the file");
			return;
		}catch(IOException ioe){
			System.out.println("IO Exception: " + ioe);
		}
		
		try(DataInputStream din = new DataInputStream(new FileInputStream("resource/data.txt"));){
			int i = din.readInt();
			double d = din.readDouble();
			boolean bool = din.readBoolean();
			char c = din.readChar();
			System.out.println("Values read: " + i + " " + d + " " + bool + " " + c);
		}catch(FileNotFoundException fe){
			System.out.println("cannot open the file");
			return;
		}catch(IOException ioe){
			System.out.println("IO Exception: " + ioe);
		}
	}

}
