package file_handling.byte_stream;

import java.io.Serializable;

public class ModelClass implements Serializable{
	
	private static final long serialVersionUID = 12312312313l;
	
	int i;
	double d;
	boolean b;
	String str;

	public ModelClass(int i, double d, boolean b, String str) {
		super();
		this.i = i;
		this.d = d;
		this.b = b;
		this.str = str;
	}
	
	@Override
	public String toString() {
		return "i=" + i + " | " + "d=" + d + " | " + "b=" + b + " | " + "str=" + str;
	}
}
