package Main3;

import java.io.IOException;

public class check {
	public static void main(String[] args) throws InterruptedException, IOException {
		String[] cp_data = new String[] {"cmd","/c","javac data.java"};
		String[] cp_force_code = new String[] {"cmd","/c","javac force_code.java"};
		String[] cp_new_code = new String[] {"cmd","/c","javac new_code.java"};
		
		String[] run_data = new String[] {"cmd","/c","java data > input.txt"};
		String[] run_force_code = new String[] {"cmd","/c","java force_code < input.txt > fout.txt"};
		String[] run_new_code = new String[] {"cmd","/c","java new_code < input.txt > nout.txt"};
		String[] fc = new String[] {"cmd","/c","fc fout.txt nout.txt"};
		
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
