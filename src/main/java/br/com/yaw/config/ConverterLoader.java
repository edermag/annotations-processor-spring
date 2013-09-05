package br.com.yaw.config;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Looking by @Convertable classes to open the converters, using Spring Framework.
 * 
 * @author eder.magalhaes
 */
public class ConverterLoader implements ApplicationContextAware, InitializingBean {

	private ApplicationContext context;
	
	@Autowired
	private ConverterRepository repository;
	
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}
	
	public void afterPropertiesSet() throws Exception {
		Map<String, Object> beans = context.getBeansWithAnnotation(Convertable.class);
		
		for (Object b: beans.values()) {
			Class<?> beanClass = b.getClass();
			Convertable annotation = beanClass.getAnnotation(Convertable.class);
			Class<? extends Converter<?, ?>> converterType = annotation.type();
			ConverterTypeEntry typeEntry = new ConverterTypeEntry(beanClass, converterType);
			repository.registerConverter(typeEntry);
		}
	}
	
	public void close() {
		System.out.println("\n ja elvis...\n");
	}
}
