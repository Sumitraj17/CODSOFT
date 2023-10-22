package Code;
import java.util.*;
import java.lang.*;
public class NumberGame {
	public int random() {
		int range=100-0+1;
		int ans=(int)(Math.random()*range);
		return ans;
	}
	public static void main(String[] args) {
		System.out.println("\n\t\t***** Welcome to the Number Game *****\t\t\n");
		Scanner sc=new Scanner(System.in);
		NumberGame obj=new NumberGame();
		boolean choice=true;
		int successCount=0,attempts=0;
		while(choice) {
			int n=3;
			attempts++;
			boolean success=false;
			int randomNumber=obj.random();
			System.out.println("\n\t\t***** Please Guess The Number *****\t\t\n");
			while(n>0) {
				n--;
				int guessNumber=sc.nextInt();
				if(guessNumber>randomNumber+10 ) {
					System.out.println("\n\t\t***** Too High *****\t\t\n");
					System.out.println("\n\t\t***** Please try again *****\t\t\n");
				}
				else if( guessNumber<randomNumber-10) {
					System.out.println("\n\t\t***** Too Low *****\t\t\n");
					System.out.println("\n\t\t***** Please try again *****\t\t\n");
				}
				else if(guessNumber==randomNumber) {
					System.out.println("\n\t\t***** You got the right answe r*****\t\t\n");
					success=true;
					successCount++;
					break;
				}
				else {
					System.out.println("\n\t\t*****Close Enough*****\t\t\n");
				}
				System.out.println("\n\t\t***** Attempts left "+n+" *****\t\t\n");
			}
			if(!success) {
				System.out.println("\n\t\t***** Better Luck Next Time *****\t\t\n");
				System.out.println("\n\t\t***** The Correct Answer is " +randomNumber+" *****\t\t\n");
			}
			System.out.println("\n\t\t***** Do you want to continue [y-yes\\n-no] *****\t\t\n");
			char c=sc.next().charAt(0);
			if(c=='n') {
				choice=false;
			}
		}
		System.out.println("\n\t\t***** The Success Ratio is "+(successCount/(float)attempts)*100+" *****\t\t\n");
	}
	

}
