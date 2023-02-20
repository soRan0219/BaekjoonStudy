import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        
        String str = a>b ? ">" : (a<b ? "<" : "==");
        
        System.out.println(str);
        
        
    } //main
}