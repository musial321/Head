import java.io.*;
import java.util.Scanner;

public class Head {
	
	
	public static boolean parseArgs(String [] args)
	{
		boolean bool = true;
		
		char arg1_0=' ';
		char arg1_1=' ';
		String [] finalArgs = new String[3];
		
		
		
		if(args.length==3)
		{
			finalArgs = args;
		}
		if(args.length==1)
		{
			finalArgs[0]="-n";
			finalArgs[1]=Integer.toString(10);
			finalArgs[2]=args[0];
			
		}
		
		
		try
		{
		arg1_0 = finalArgs[0].charAt(0);
		arg1_1 = finalArgs[0].charAt(1);
		
		}
		catch(Exception e)
		{
			bool=false;
		}
		
		
		if(arg1_0 != '-' || arg1_1 != 'n')		
		{	
		
			bool = false;
		}
		
		try
		{
			finalArgs[1] = Integer.toString((Integer.parseInt(finalArgs[1])));
			
			if(Integer.parseInt(finalArgs[1])<1)
			{
				bool = false;
				
			}
		}
		catch(Exception e)
		{
			
			bool = false;
		
		}
		
		try
		{
		File input = new File(finalArgs[2]);
		if(!input.exists())
			{
				bool = false;
			}
			
		}
		catch(Exception e)
		{
			bool = false;
		}
		
		return bool;
		}
	
	
	public static void main(String [] args) throws IOException
	{
		
		
	
	boolean correctArgs;
	correctArgs = parseArgs(args);
	
	
	if(!correctArgs)
	{
		System.out.println("Argument error.");
	}
		
	if(correctArgs)
	{
	
	BufferedReader in = null;
	BufferedWriter out = null;
	
	
	String str = "";
	
	Scanner s = new Scanner(System.in);
	
	File input;
	
	if(args.length==3)
	{
	input = new File(args[2]);
	}
	else
	{
	input = new File(args[0]);
	}	
	
	//File output = new File("output.txt");
	
	in = new BufferedReader(new FileReader(input));
	//out = new BufferedWriter(new FileWriter(output));
	
	
	try
	{
		int i = 0;
		
		if(args.length==3)
		{
		while(i<Integer.parseInt(args[1]))
		{
			str = in.readLine();
			
			if(str!=null)
			{
				System.out.println(str);
			}
			
			i++;
		}
		}
		else
		{
			while(i<10)
			{
				str = in.readLine();
				
				if(str!=null)
				{
					System.out.println(str);
				}
				
				i++;
			}
		}
	}
	finally
	{
		if (in!=null)
		{
			in.close();
		}
		if(out!=null)
		{
			out.close();
		}
	}
	
	
	


	}


}
	
}



