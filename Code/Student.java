package Number_Game;
import java.util.*;
import java.lang.*;
public class Student {
    private char gradeFunction(float num){
        char c;
        if(num>=85){
            return 'A';
        }
        else if(num<85 && num>=70){
            return 'B';
        }
        else if(num<70 && num>=60){
            return 'C';
        }
        else if (num<60 && num>=50)
            return 'D';
        else if(num<50 && num>=35)
            return 'E';
        else
            return 'F';
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\t\t***** Student Calculator *****\t\t\n");
        System.out.print("Enter the no of subjects:- ");
        int n=sc.nextInt();
        int totalMarks=0;
        Student obj=new Student();
        ArrayList<Integer> subject=new ArrayList<Integer>(n);
        for(int i=0;i<n;i++) {
            int j=i+1;
            System.out.print("Subject "+j+" :- ");
            int x=sc.nextInt();
            subject.add(x);
            totalMarks+=x;
        }
        float avgMarks=totalMarks/(float)n;
        System.out.println("Total Marks :- "+totalMarks);
        System.out.println("Average Marks :- "+avgMarks+" %");
        System.out.println("Grades Obtained :- "+obj.gradeFunction(avgMarks));
    }
}
