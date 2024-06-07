package day5_25;

import java.io.IOException;
import java.util.Random;

public class check {
	static int rd(int l,int r) {
		Random random = new Random();
		return random.nextInt(r-l+1)+l;
		
	}
	public static void main(String[] args) throws Exception {
		String[] cp_data = new String[] {"cmd","/c","javac data.java"};
		String[] cp_force_code = new String[] {"cmd","/c","javac force_code.java"};
		String[] cp_new_code = new String[] {"cmd","/c","javac new_code.java"};
		
		String[] run_data = new String[] {"cmd","/c","java data > input.txt"};
		String[] run_force_code = new String[] {"cmd","/c","java force_code < input.txt > out1.txt"};
		String[] run_new_code = new String[] {"cmd","/c","java new_code < input.txt > out2.txt"};
		
		String[] fc = new String[] {"cmd","/c","fc out1.txt out2.txt"};
		
		Runtime.getRuntime().exec(cp_data).waitFor();
		Runtime.getRuntime().exec(cp_force_code).waitFor();
		Runtime.getRuntime().exec(cp_new_code).waitFor();
		while(true) {
			Runtime.getRuntime().exec(run_data).waitFor();
			Runtime.getRuntime().exec(run_force_code).waitFor();
			Runtime.getRuntime().exec(run_new_code).waitFor();
			
			int ans = Runtime.getRuntime().exec(fc).waitFor();
			if(ans==0) {
				System.out.println("AC");
			}else {
				System.out.println("WA");
				break;
			}
		}
	}
}
