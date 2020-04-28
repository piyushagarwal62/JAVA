package file_handling.byte_stream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedOutputSteamDemo {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("Enter few lines of data");
		FileOutputStream fos = new FileOutputStream("resource/temp2.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		try {
			String str = null;
			while (!(str = br.readLine()).equals("stop")) {
				bos.write(str.getBytes());
				bos.write("\n".getBytes());
			}
			bos.flush();
		} catch (IOException e) {
			System.out.println("IO Excetion: " + e);
		}finally {
			try {
				bos.close();
			} catch (IOException e) {
				System.out.println("IO Excetion: " + e);
			}
		}
	}

}
