import java.io.*;

public class Head 
{
	static File input;
	static int n=10;
	
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
			n = Integer.parseInt(finalArgs[1]);
			
			if(n<1)
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
			input = new File(finalArgs[2]);
		
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
			in = new BufferedReader(new FileReader(input));
			String str = "";
	
			try
			{
					int i = 0;
		
					while(i<n)
					{
						str = in.readLine();
			
						if(str!=null)
						{
							System.out.println(str);
						}
						
						i++;
					}		
			}
			finally
			{
				if (in!=null)
				{
					in.close();
				}
			}
		}
	}
}