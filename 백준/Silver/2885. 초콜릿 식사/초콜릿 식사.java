import java.util.Scanner;

public class Main {
	
    static boolean power2(int num) {
        String result = Integer.toBinaryString(num & (num-1));
        for(int i=0; i<result.length(); i++) {
            if(result.charAt(i)=='1') return false;
        }
        return true;
	}
    
	static void chocolate(int k) {
		int divide = 0;
		int choco = 0;
		int tmp = 0;
		
		if(power2(k)) {
			choco = k;
		} else {
			for(int i=0; ; i++) {
				tmp = (int)Math.pow(2, i);
				if(tmp<k) continue;
				else break;
			}
			choco = tmp;
			
			int i = 0;
			while(!power2(k)) {
				tmp = (int)Math.pow(2, i);
				if(tmp < k) i++;
				else {
					tmp -= (int)Math.pow(2, --i);
					k -= tmp;
					i = 0;
				}
			}
			
			for(int j=choco; j!=k; j/=2) {
				divide++;
			}
		}
		System.out.println(choco + " " + divide);
		
	} //chocolate()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		
		chocolate(k);
		
	} //main()
}
