package com.sample.book.component.api.httpconnect.client;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageConverterOptions {

	@Nullable
	private List<HttpMessageConverter<?>> converters;

	public MessageConverterOptions string() {
		return string(new StringHttpMessageConverter());
	}

	public MessageConverterOptions string(StringHttpMessageConverter converter) {
		initConverters().add(converter);
		return this;
	}

	public MessageConverterOptions form() {
		FormHttpMessageConverter converter = new FormHttpMessageConverter();
		converter.setCharset(StandardCharsets.UTF_8);
		converter.setMultipartCharset(StandardCharsets.UTF_8);
		List<HttpMessageConverter<?>> partConverters = new ArrayList<>(3);
		partConverters.add(new ByteArrayHttpMessageConverter());
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
		stringHttpMessageConverter.setWriteAcceptCharset(false);
		partConverters.add(stringHttpMessageConverter);
		partConverters.add(new ResourceHttpMessageConverter());
		converter.setPartConverters(partConverters);
		return form(converter);
	}

	public MessageConverterOptions form(FormHttpMessageConverter converter) {
		initConverters().add(converter);
		return this;
	}

	public MessageConverterOptions jackson() {
		return jackson(new MappingJackson2HttpMessageConverter());
	}

	public MessageConverterOptions jackson(MappingJackson2HttpMessageConverter converter) {
		initConverters().add(converter);
		return this;
	}

	public MessageConverterOptions jackson(ObjectMapper mapper) {
		initConverters().add(new MappingJackson2HttpMessageConverter(mapper));
		return this;
	}

	public MessageConverterOptions byteArray() {
		return byteArray(new ByteArrayHttpMessageConverter());
	}

	public MessageConverterOptions byteArray(ByteArrayHttpMessageConverter converter) {
		initConverters().add(converter);
		return this;
	}

	public MessageConverterOptions converters(Consumer<List<HttpMessageConverter<?>>> converterConsumer) {
		converterConsumer.accept(initConverters());
		return this;
	}

	private List<HttpMessageConverter<?>> initConverters() {
		if (this.converters == null) {
			this.converters = new ArrayList<>();
		}
		return this.converters;
	}

	public List<HttpMessageConverter<?>> build() {
		return CollectionUtils.isEmpty(this.converters) ? getDefaultConverters() : this.converters;
	}

	private List<HttpMessageConverter<?>> getDefaultConverters() {
		initConverters().clear();
		return string().form().jackson().byteArray().build();
	}

}