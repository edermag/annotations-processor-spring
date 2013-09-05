package br.com.yaw.config;

public final class ConverterTypeEntry {

	final Class<?> entityType;
	
	final Class<? extends Converter<?, ?>> converterType;
	
	ConverterTypeEntry(Class<?> entityType, Class<? extends Converter<?, ?>> converterType) {
		this.entityType = entityType;
		this.converterType = converterType;
	}
	
}
