package Revue2.Revue2;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        System.out.println( "Hello World  sd3tina a najla !" );
    }
}
