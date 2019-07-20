package com.sample.book.component.api.httpconnect.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

import com.sample.book.component.api.httpconnect.ListableOptions;
import com.sample.book.component.api.httpconnect.client.RestTemplateOperations.Builder;

import okhttp3.OkHttpClient;

class DefaultRestTemplateOperationsBuilder implements Builder {

	@Nullable
	private OkHttpClient okHttpClient;

	@Nullable
	private List<HttpMessageConverter<?>> converters;

	@Nullable
	private UriTemplateHandler uriBuilderFactory;

	@Nullable
	private ResponseErrorHandler errorHandler;

	@Nullable
	private List<ClientHttpRequestInterceptor> interceptors;

	@Nullable
	private Consumer<RestTemplate> customizer;

	DefaultRestTemplateOperationsBuilder() {
	}

	DefaultRestTemplateOperationsBuilder(DefaultRestTemplateOperationsBuilder other) {
		this.okHttpClient = other.okHttpClient;
		this.converters = other.converters != null ? new ArrayList<>(other.converters) : null;
		this.uriBuilderFactory = other.uriBuilderFactory;
		this.errorHandler = other.errorHandler;
		this.interceptors = other.interceptors != null ? new ArrayList<>(other.interceptors) : null;
		this.customizer = other.customizer != null ? other.customizer : null;
	}

	@Override
	public Builder okHttpClientBuilder(Function<OkHttpClient.Builder, OkHttpClient> builder) {
		return okHttpClient(builder.apply(new OkHttpClient.Builder()));
	}

	@Override
	public Builder okHttpClient(Function<OkHttpClientOptions, OkHttpClient> options) {
		return okHttpClient(options.apply(new OkHttpClientOptions()));
	}

	@Override
	public Builder okHttpClient(OkHttpClient okHttpClient) {
		this.okHttpClient = okHttpClient;
		return this;
	}

	@Override
	public Builder messageConverter(Function<MessageConverterOptions, List<HttpMessageConverter<?>>> options) {
		this.converters = options.apply(new MessageConverterOptions());
		return this;
	}

	@Override
	public Builder uriBuilderFactory(String baseUri) {
		this.uriBuilderFactory = new DefaultUriBuilderFactory(baseUri);
		return this;
	}

	@Override
	public Builder uriBuilderFactory(UriTemplateHandler uriBuilderFactory) {
		this.uriBuilderFactory = uriBuilderFactory;
		return this;
	}

	@Override
	public Builder errorHandler(ResponseErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
		return this;
	}

	@Override
	public Builder interceptors(Function<ListableOptions<ClientHttpRequestInterceptor>, List<ClientHttpRequestInterceptor>> options) {
		this.interceptors = options.apply(new ListableOptions<ClientHttpRequestInterceptor>());
		return this;
	}

	@Override
	public Builder customizer(Consumer<RestTemplate> customizer) {
		this.customizer = customizer;
		return this;
	}

	@Override
	public RestTemplateOperations build() {
		return new DefaultRestTemplateOperations(this);
	}

	protected RestTemplate buildRestTemplate() {
		List<HttpMessageConverter<?>> messageConverters = !CollectionUtils.isEmpty(this.converters) ? this.converters : new MessageConverterOptions().build();
		RestTemplate client = new RestTemplate(messageConverters);

		OkHttpClient httpClient = this.okHttpClient != null ? this.okHttpClient : new OkHttpClientOptions().build();
		configureRequestFactory(client, httpClient);
		if (this.uriBuilderFactory != null) {
			configureUriBuilderFactory(client, this.uriBuilderFactory);
		}
		if (this.errorHandler != null) {
			configureErrorHandler(client, this.errorHandler);
		}
		if (!CollectionUtils.isEmpty(this.interceptors)) {
			configureInterceptors(client, this.interceptors);
		}
		if (this.customizer != null) {
			customizeRestTemplate(client, this.customizer);
		}
		return client;
	}

	private void configureRequestFactory(RestTemplate client, OkHttpClient okHttpClient) {
		ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
		client.setRequestFactory(new BufferingClientHttpRequestFactory(okHttp3ClientHttpRequestFactory));
	}

	private void configureUriBuilderFactory(RestTemplate client, UriTemplateHandler uriBuilderFactory) {
		client.setUriTemplateHandler(uriBuilderFactory);
	}

	private void configureErrorHandler(RestTemplate client, ResponseErrorHandler errorHandler) {
		client.setErrorHandler(errorHandler);
	}

	private void configureInterceptors(RestTemplate client, List<ClientHttpRequestInterceptor> interceptors) {
		client.setInterceptors(interceptors);
	}

	private void customizeRestTemplate(RestTemplate client, Consumer<RestTemplate> customizer) {
		customizer.accept(client);
	}

}