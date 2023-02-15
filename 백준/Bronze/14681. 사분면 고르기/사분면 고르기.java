import java.util.Scanner;

public class Main {
    public static int getQuadrant(int x, int y) {
        int q = 0;
        if((-1000<=x && x<=1000 && x != 0) && (-1000<=y && y<=1000 && y!=0)) {
            if(x>0 && y>0) {
                q = 1;
            } else if(x<0 && y>0) {
                q = 2;
            } else if(x<0 && y<0) {
                q = 3;
            } else {
                q = 4;
            }
        } 
        return q;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        System.out.println(getQuadrant(x, y));
    }
}