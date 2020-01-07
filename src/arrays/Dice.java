package arrays;

import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do{
			rollDice();
			System.out.println("Do you want to roll dice, say y or n");
			choice = sc.next().charAt(0);
		}while(choice != 'n');
	}
	
	public static void rollDice(){
		System.out.println("Rolling the dices");
		int dice1[] = {0,1,2,3,4,5};
		int dice2[] = {0,1,2,6,7,8,9};
		int random1 = (int)(Math.random()*10 % 6);
		int random2 = 0;

		if(dice1[random1] < 3){
			random2 = (int)(Math.random()*10 % 7);
			System.out.println("Correct Date is : [" + dice1[random1] +"," + dice2[(random1 == 0 && random2 == 0)? random2 +1 : random2]+"]" );
		}
		else if(dice1[random1] == 3){
			random2 = (int)(Math.random()*10 % 2);
			System.out.println("Correct Date is : [" + dice1[random1] +"," + dice2[random2]+"]" );
		}else{
			random2 = (int)(Math.random()*10 % 3);
			System.out.println("Correct Date is : [" + dice2[random2] +"," + dice1[random1]+"]" );
		}
	}

}
