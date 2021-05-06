package Revue2.Revue2;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger log = Logger.getLogger("revue");  
	
	
    public static void main( String[] args )throws IOException,SQLException
    {
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
    	PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        System.out.println( "Hello World  sd3tina a najla !" );
        log.debug("Hello this is a debug message");  
        log.info("Hello this is an info message");  
    }
}
