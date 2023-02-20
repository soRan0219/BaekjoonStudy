import java.util.Scanner;

public class Main {
    static String grade(int inScore) {
        String grade = "";
        int score = inScore/10;
        if(inScore>=0 && inScore<=100) {
            switch(score) {
                case 10:
                case 9: grade = "A"; break;
                case 8: grade = "B"; break;
                case 7: grade = "C"; break;
                case 6: grade = "D"; break;
                default: grade = "F"; 
            }
        } //if
        return grade;
    } //grade
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int score = s.nextInt();
        System.out.println(grade(score));
    } //main
}