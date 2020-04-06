package file_handling;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class to demonstrate File class and its methods
 * 
 * @author piyush.agarwal
 *
 */
public class FileClassDemo {

	public static void main(String[] args) throws URISyntaxException, IOException {
		String dirName = ".." + File.separator + ".." + File.separatorChar + "dummy_data";
		File file = new File(dirName + "/" + "temp.txt");
		useURIClass(file, dirName);
		useFileClass(dirName);
		useFileListingMethod(dirName);
	}

	private static void useFileListingMethod(String dirName) {
		File file = new File(dirName);
		System.out.println("\nListing all files in the mentioned directory");
		String[] list = file.list();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

		// Added a filter to display only file having extension java
		FilenameFilter ext = new CustomFilter("java");
		list = file.list(ext);
		System.out.println("\nListing file which ends with or have extension as java");
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

		// Adding anonymous filter to display file which starts with "B" and
		// using listFiles() method
		File list1[] = file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("B");
			}
		});
		System.out.println("\nListing file which starts with B");
		for (int i = 0; i < list1.length; i++) {
			System.out.println(list1[i].getName());
		}

		// Adding anonymous filter to display file which are directory and using
		// listFiles() method
		list1 = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
		System.out.println("\nListing file which are directory");
		for (int i = 0; i < list1.length; i++) {
			System.out.println(list1[i].getName());
		}

	}

	private static void useFileClass(String dirName) throws IOException {
		File file = new File("../../dummy_data/temp.txt");
		// Used to create new file with the name and path mentioned
		boolean isCreated = file.createNewFile();
		System.out.println("New File created: " + isCreated);
		System.out.println("Is File exists: " + file.exists());
		System.out.println("Is File Directory: " + file.isDirectory());
		System.out.println("File Absolute Path: " + file.getAbsolutePath());
		System.out.println("File Name: " + file.getName());
		System.out.println("File Path: " + file.getPath());
		System.out.println("File Parent: " + file.getParent());
		System.out.println("File Parent File: " + file.getParentFile());
		System.out.println("File Cononical Path: " + file.getCanonicalPath());
		System.out.println("File Cononical File: " + file.getCanonicalFile());
		System.out.println("File last modified date: " + file.lastModified());
		System.out.println("File length: " + file.length() + "bytes");
		System.out.println(
				"Free space available on that file system: " + file.getFreeSpace() / 1024 / 1024 / 1024 + "GB");
		System.out.println("Total space on that file system: " + file.getTotalSpace() / 1024 / 1024 / 1024 + "GB");
		System.out.println("Usable space on that file system: " + file.getUsableSpace() / 1024 / 1024 / 1024 + "GB");
		File newDir = new File(file.getParent() + "/B/C/D");
		// mkdirs is use to create directory recursively.
		System.out.println("New Directory created: " + newDir.mkdirs());
		newDir = new File(file.getParent() + "/E");
		// mkdir is use to create directory but not recursively.
		System.out.println("New Directory created: " + newDir.mkdir());
		System.out.println("Deleting New Directory: " + newDir.delete());

		System.out.println("==========================");
		File file1 = new File("../../dummy_data/");
		// Used to create new temp file with the name and path mentioned
		File file2 = File.createTempFile("hello", ".c", file1);
		System.out.println("Path of temp file at specified location: " + file2.getAbsolutePath());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after deleting the file: " + file2.delete());

		file2 = File.createTempFile("hello", ".c");
		System.out.println("Path of temp file with two parameter: " + file2.getAbsolutePath());
		// It deletes the file after termination of VM
		file2.deleteOnExit();
	}

	/**
	 * Note: URI class does not verify if the file exist or not
	 */
	private static void useURIClass(File file, String dir) throws URISyntaxException {
		// Example when path is given as string to URI
		URI uri = new URI(dir);
		System.out.println("URI with string parameter");
		System.out.println("URI toString: " + uri.toString());
		System.out.println("URI getRawPath: " + uri.getRawPath());
		System.out.println("URI getPath: " + uri.getPath());
		// Scheme would be null since a string parameter was provided for
		// constructor
		System.out.println("Scheme using URI: " + uri.getScheme());
		System.out.println("Scheme specific part: " + uri.getSchemeSpecificPart());
		System.out.println("===========================");

		// Example when scheme and path is given as string to URI
		URI uri1 = new URI("file", null, file.getAbsolutePath(), null);
		System.out.println("URI with scheme & string parameter");
		System.out.println("URI toString: " + uri1.toString());
		System.out.println("URI getRawPath: " + uri1.getRawPath());
		System.out.println("URI getPath: " + uri1.getPath());
		System.out.println("Scheme using URI: " + uri1.getScheme());
		System.out.println("Scheme specific part: " + uri1.getSchemeSpecificPart());
		System.out.println("===========================");

		// Getting URI from file
		URI uri2 = file.toURI();
		System.out.println("Using URI via File class:");
		System.out.println("URI toString: " + uri2.toString());
		System.out.println("URI getRawPath: " + uri2.getRawPath());
		System.out.println("URI getPath: " + uri2.getPath());
		System.out.println("Scheme using URI: " + uri2.getScheme());
		System.out.println("Scheme specific part: " + uri1.getSchemeSpecificPart());
		System.out.println("===========================");
	}

}
