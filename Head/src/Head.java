import java.io.*;

public class Head {
	static File input;
	static int n=10;
	
	public static boolean parseArgs(String [] args) {
		boolean validArgs = true;
		String [] finalArgs = new String[3];
		
		if(args.length==3) { 
			finalArgs = args;
		}
		if(args.length==1) { //If user does not use -n, the new array defaults to {-n, 10, filename.txt}
			finalArgs[0]="-n";
			finalArgs[1]=Integer.toString(10);
			finalArgs[2]=args[0];
		}
		
		if(!finalArgs[0].equals("-n")) { //Makes sure first argument is -n	
			validArgs = false;
		}
		
		try {
			n = Integer.parseInt(finalArgs[1]); //Tries to store the number following -n as an integer
			
			if(n < 1) { //Makes sure n is greater than or equal to 1
				validArgs = false;
			}
		}
		catch(Exception e) {
			validArgs = false;
		}
		
		try { //Tries to store final argument as a file
			input = new File(finalArgs[2]);
		
			if(!input.exists()) { //If file does not exist, lines cannot be read
				validArgs = false;
			}
		}
		catch(Exception e) {
			validArgs = false;
		}
		
		return validArgs; //Returns whether or not the arguments given can be used
	}
	
	public static void main(String [] args) throws IOException {
		boolean correctArgs;
		correctArgs = parseArgs(args);
	
		if(!correctArgs) { //If arguments cannot be used
			System.out.println("Argument error.");
		}
		else {
			BufferedReader in = null;
			in = new BufferedReader(new FileReader(input));
			String str = "";
	
			try {
				int i = 0;
		
				while(i < n) { //Prints lines to console up to line n
					str = in.readLine();
			
					if(str != null) {
						System.out.println(str);
					}
						
					i++;
				}		
			}
			finally { //Closes BufferedReader
				if (in != null) {
					in.close();
				}
			}
		}
	}
}