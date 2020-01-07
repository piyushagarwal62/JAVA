package math_package;

import java.util.Scanner;
/**
 * Write a description of class CricketGame here.
 *
 */
public class CricketGame
{
    public static void main(String arg[]){
        cricket();
    }
    
    public static void cricket(){
        int wicket = 0;
        int total = 0;
        int player = 0;
        int noOfPlayers = 3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Lets start the inning");
        while(true){
            sc.next();
            int runs = (int)(Math.random() * 100%11);
            if(runs >= 8){
                wicket++;
                System.out.println("OOHH!!! That's out");
                if(runs == 8){
                    System.out.println("You are Clean Bowled");
                }else if(runs == 9){
                    System.out.println("That's a LBW");
                }else if(runs == 10){
                    System.out.println("That's a catch out");
                }
                System.out.println("Previous Player Score: " + player);
                System.out.println("Current Team Score: " + total + "/"+ wicket);
                player = 0;
                if(wicket == noOfPlayers){
                    System.out.println("Team Inning Ends");
                    break;
                }
            }else{
                System.out.println("Score on Current Ball Played: " + runs);
                total += runs;
                player += runs;
            }
        }
    }
}