package file_handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Basic example of Copying data in another file skipping 2 bytes everytime
 * 
 * @author piyush.agarwal
 *
 */
public class FileHandlingDemo {

	public static void main(String[] args) {
		File file = new File("resource/temp.txt");
		FileInputStream fis = null;
		try (FileOutputStream fos = new FileOutputStream("resource/temp1.txt")) {
			fis = new FileInputStream(file);
			int i = -1;
			do {
				// Reading and writing one byte at a time with read()/write()
				// method
				i = fis.read();
				fis.skip(2);
				if (i != -1) {
					fos.write(i);
					System.out.print(((char) i));
				}
			} while (i != -1);
		} catch (FileNotFoundException fe) {
			System.out.println("File not found:" + fe);
		} catch (IOException io) {
			System.out.println("IOException found:" + io);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
