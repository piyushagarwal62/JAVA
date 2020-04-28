package file_handling.byte_stream;

import java.io.*;

public class ByteArrayStreamDemo {
	
	public static void main(String args[]) throws IOException {
		String str = "Hello this is India, We like to welcome all!!!";
		byte[] bytes = str.getBytes();
		//Two different constructor used for ByteArrayOutputStream
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteArrayOutputStream bos1 = new ByteArrayOutputStream(30);
		
		System.out.println();
		//Two different constructor used for ByteArrayInputStream
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		try(ByteArrayInputStream bis1 = new ByteArrayInputStream(bytes, 0, bytes.length/2);
				FileOutputStream fos = new FileOutputStream("resource/temp2.txt");){
			int read;
			//Reading and writing to one of the outputStream
			while((read = bis.read()) != -1){
				if(Character.isLowerCase((char)read)){
					System.out.print((char)Character.toUpperCase(read));
				}else{
					System.out.print((char)Character.toLowerCase(read));
				}
				bos.write(read);
				if((char)read == ','){
					bis.mark(0);
				}
			}
			bis.reset();
			byte[] bytes2 = new byte[50];
			int totalRead = bis.read(bytes2);
			//Writing to a stream
			bos1.write(bytes2, 0, totalRead);
			//Writing to a file
			bos1.writeTo(fos);
			System.out.println("\n"+bos1.toString());
			byte[] byteArray = bos.toByteArray();
			
			System.out.println(new String(byteArray, 0, byteArray.length));
		}catch(IOException ioe){
			
		}		
	}
}