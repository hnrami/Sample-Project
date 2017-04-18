package com.onlinetutorialspoint.camel;

import org.apache.camel.main.Main;

public class Executor 
{

	public static void main ( String [] args ) throws Exception
	{

		Main main = new Main ();
		EmailRoutes emailRoutes = new EmailRoutes();
		
		main.addRouteBuilder(emailRoutes);
		
		main.enableHangupSupport ();
		main.run ();
	
		
	}

	
}
