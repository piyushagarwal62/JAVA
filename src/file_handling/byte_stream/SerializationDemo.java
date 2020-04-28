package file_handling.byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
		
		//Serialization of object
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resource/modelobject.obj"));){
			ModelClass obj = new ModelClass(34, 43.22, false, "Hello World!");
			System.out.println("Object Information before writing: " + obj);
			oos.writeObject(obj);
			oos.writeInt(433);
		}catch(IOException ioe){
			System.out.println("IO Exception due to serialization: " + ioe);
		}

		//DeSerialization of object
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resource/modelobject.obj"));){
			
			ModelClass obj = (ModelClass) ois.readObject();
			System.out.println("Object Information after read: " + obj);
			System.out.println("Int value" + ois.readInt());
		}catch(IOException ioe){
			System.out.println("IO Exception due to serialization: " + ioe);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found of serializable: " + e);
		}
	}

}
