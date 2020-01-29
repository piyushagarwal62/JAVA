package callback_implementation;
import java.util.Scanner;

public class Webservice{

	APIResponse callback;

	void setListener(APIResponse callback){
		this.callback = callback;
	}	

	public void readValue(){
		Scanner sc = new Scanner(System.in);
		String str = null;
		do{
			str = sc.nextLine();
			callback.read(str);
		}while(!str.equals("exit"));
		sc.close();
	}

}