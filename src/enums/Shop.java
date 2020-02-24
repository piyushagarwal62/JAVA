package enums;

enum Product{
	SMALL, MEDIUM, LARGE;
};

enum ClothSize{
	XS(32, "XS", 12), 
	S(36){
	//known as Constant specific class body	
		int getSize(){
			return number * 3;
		}
	}, M(38), L(40), XL(42), XXL; 
	
	int number;
	String sizeStr;
	int euro;
	
	//Can add different type of constructor in Enum as well
	ClothSize(){}
	
	ClothSize(int number){
		this.number = number;
	}
	
	ClothSize(int number, String sizeStr, int euro){
		this.number = number;
		this.sizeStr = sizeStr;
		this.euro = euro;
	}
	
	int getNumber(){
		return number;
	}
	
	public String toString(){
		return sizeStr + ": " + number;
	}
	
	int getSize(){
		return number / 2;
	}
};


/**
 * @author piyush
 *
 */
public class Shop{

	//Can add enum inside class or create a file with enums separately 
	enum ITEMS{
		GROCERY, Stationary,HARDWARE
	}
	
	public static void main(String args[]){
		
		Product prod;
		prod = Product.SMALL;
		System.out.println(prod.ordinal());

		//Different methods available in for enums
		//ex. values(), name(), ordinal()
		ClothSize[] values = ClothSize.values();
		for (int i = 0; i < values.length; i++) {
			if(values[i].getNumber()== 44){
				System.out.println(values[i].ordinal());
			}
			System.out.println(values[i].getNumber());
			System.out.println(values[i].name());
		}
		ClothSize cs = ClothSize.S;
		System.out.println(cs.getNumber());
		System.out.println(ClothSize.XS.getSize());
		System.out.println(ClothSize.S.getSize());
		System.out.println(ClothSize.XXL.getSize());
	}
}
