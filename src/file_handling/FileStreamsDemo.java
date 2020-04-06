package file_handling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class to check with mark and reset Even checking other ways of reading and
 * writing using byte array
 * 
 * @author piyush.agarwal
 *
 */
public class FileStreamsDemo {

	public static void main(String[] args) {
		int size;
		BufferedInputStream bis = null;
		try (FileInputStream fis = new FileInputStream("resource/temp.txt");
				FileOutputStream fos = new FileOutputStream("resource/temp1.txt");
				FileOutputStream fos2 = new FileOutputStream("resource/temp2.txt")) {
			bis = new BufferedInputStream(fis);
			System.out.println(bis.available());
			byte b[] = new byte[10];
			int count = 0;
			while ((size = bis.read(b, 0, b.length / 2)) != -1) {
				count++;
				fos.write(b, 0, size);
				System.out.println(new String(b, 0, size));
				System.out.println(bis.available());
				if (count == 3 && bis.markSupported())
					bis.mark(0);
			}
			bis.reset();
			while ((size = bis.read(b)) != -1) {
				fos2.write(b);
			}
			System.out.println(bis.available());
		} catch (IOException io) {
			System.out.println("Exception caught:" + io);
		} finally {
			try {
				bis.close();
			} catch (IOException io) {
				System.out.println("Exception caugth: " + io);
			}
		}
	}

}
