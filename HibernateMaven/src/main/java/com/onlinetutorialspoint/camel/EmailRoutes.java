package com.onlinetutorialspoint.camel;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class EmailRoutes extends RouteBuilder{
	
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	@Override
	public void configure() throws Exception {
	
		
		
		@Override
	public void configure() throws Exception {
	
		
		
		
		from("imaps://imap.gmail.com?username=spring@gmail.com&password=springboot@94270"
			    + "&delete=false&unseen=true&consumer.delay=6000")
		
		
		.process ( new Processor () {
			@SuppressWarnings("unchecked")
			public void process ( Exchange exchange ) throws Exception
			{
				
			
				String from = exchange.getIn().getHeader("from").toString();
				
				String emailSubject = exchange.getIn ().getHeader ( "subject" ).toString();
				
				String bodyContent = exchange.getIn().getBody(String.class);
				
				System.out.println("from:-"+from);
				
				String fromarry[] = from.split("<");
				
				System.out.println(fromarry[1].substring(0, fromarry[1].length()-1));
//				
//				System.out.println("Subject:"+emailSubject);
//				
//				System.out.println("Body:"+bodyContent);
				
				System.out.println(Util.AddUsers(fromarry[1].substring(0, fromarry[1].length()-1), emailSubject, bodyContent));
				System.out.println("end");
				
				
			}
		});

}
	
	
		
		
		
		
		
	
}
