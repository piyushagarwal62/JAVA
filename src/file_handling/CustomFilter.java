package file_handling;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author piyush.agarwal
 *
 */
public class CustomFilter implements FilenameFilter {

	String ext;

	public CustomFilter(String ext) {
		this.ext = "." + ext;
	}

	public boolean accept(File directory, String filename) {
		return filename.endsWith(ext);
	}
}
