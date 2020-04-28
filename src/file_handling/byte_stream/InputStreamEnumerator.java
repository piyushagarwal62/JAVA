package file_handling.byte_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class InputStreamEnumerator implements Enumeration<FileInputStream> {

	private Enumeration<String> files;

	public InputStreamEnumerator(Vector<String> files) {
		this.files = files.elements();
	}
	
	@Override
	public boolean hasMoreElements() {
		return files.hasMoreElements();
	}

	@Override
	public FileInputStream nextElement() {
		try{
			return new FileInputStream(files.nextElement().toString());
		}catch(IOException e){
			return null;
		}
	}
	
}
