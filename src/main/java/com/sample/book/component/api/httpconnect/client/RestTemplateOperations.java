package com.sample.book.component.api.httpconnect.client;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import com.sample.book.component.api.httpconnect.HttpClientOperations;
import com.sample.book.component.api.httpconnect.ListableOptions;

import okhttp3.OkHttpClient;

public interface RestTemplateOperations extends HttpClientOperations<RestTemplate> {

	Builder mutate();

	static Builder builder() {
		return new DefaultRestTemplateOperationsBuilder();
	}

	interface Builder {

		Builder okHttpClientBuilder(Function<OkHttpClient.Builder, OkHttpClient> builder);

		Builder okHttpClient(Function<OkHttpClientOptions, OkHttpClient> options);

		Builder okHttpClient(OkHttpClient okHttpClient);

		Builder messageConverter(Function<MessageConverterOptions, List<HttpMessageConverter<?>>> options);

		Builder uriBuilderFactory(String baseUri);

		Builder uriBuilderFactory(UriTemplateHandler uriBuilderFactory);

		Builder errorHandler(ResponseErrorHandler errorHandler);

		Builder interceptors(
				Function<ListableOptions<ClientHttpRequestInterceptor>, List<ClientHttpRequestInterceptor>> options);

		Builder customizer(Consumer<RestTemplate> customizer);

		RestTemplateOperations build();

	}

}