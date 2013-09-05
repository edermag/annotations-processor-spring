package br.com.yaw;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.yaw.config.ConverterProcessor;
import br.com.yaw.model.Client;
import br.com.yaw.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
                
        ConverterProcessor processor = ctx.getBean(ConverterProcessor.class);
        
        Client c = new Client();
		c.setName("Jose da Silva");
		c.setAddress("Av Paulista");
		
		Product m = new Product();
		m.setDescription("Notebook");
		m.setValue(1000.5);
		
		System.out.println(processor.makeConversion(c));
		System.out.println(processor.makeConversion(m));
		
		System.out.println(processor.makeConversion("Ih"));
		
		//TODO colocar esse close nos projetos da yaw
		ctx.close();
    }
}
