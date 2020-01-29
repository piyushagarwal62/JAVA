package callback_implementation;

public class APIImpl implements APIResponse{

	public void read(String str){

		System.out.println("Value read is: "+ str);
	}

	void init(){
		Webservice webservice = new Webservice();
		webservice.setListener(this);
		webservice.readValue();
	}


	public static void main(String args[]){

		APIImpl obj = new APIImpl();
		obj.init();
	}

}