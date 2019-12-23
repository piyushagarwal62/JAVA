package sizeof_implementation;

/*
 * Use to show implementation of sizeof in Java since 
 *  sizeof keyword is not available in Java
 *
 * @author Piyush Agarwal
 */
public class SizeOf{

	public static void main(String[] args) {
		System.out.println(" size of int in Java is (in bytes) :  " + sizeOf(int.class));
		System.out.println(" size of int in Java is (in bytes) :  " + sizeOf(Integer.class));
	}
		
	/*
	 * Returns value in bits
	 * e.g. int size is returned as 32bit
	 */
	public static int sizeOf(Class dataType) 
	{ 
		
		if (dataType == null) 
		{ 
			throw new NullPointerException(); 
		} 
		if (dataType == byte.class || dataType == Byte.class) 
		{ 
			return Byte.SIZE; 
		} 
		if (dataType == short.class || dataType == Short.class) 
		{ 
			return Short.SIZE; 
		}
		if (dataType == char.class || dataType == Character.class) 
		{ 
			return Character.SIZE; 
		} 
		if (dataType == int.class || dataType == Integer.class) 
		{ 
			return Integer.SIZE;
		} 
		if (dataType == long.class || dataType == Long.class) 
		{ 
			return Long.SIZE; 
		} 
		if (dataType == float.class || dataType == Float.class) 
		{ 
			return Float.SIZE; 
		} 
		if (dataType == double.class || dataType == Double.class) 
		{ 
			return Double.SIZE; 
		} if (dataType == boolean.class || dataType == Boolean.class) 
		{ 
			return 1; 
		} 
		
		return 4; // default for 32-bit memory pointer 
	
	}

}
