package com.sample.book.component.api.httpconnect.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.lang.Nullable;

public class InterceptorOptions {

	@Nullable
	private List<ClientHttpRequestInterceptor> interceptors;

	public InterceptorOptions interceptor(ClientHttpRequestInterceptor interceptor) {
		initInterceptors().add(interceptor);
		return this;
	}

	public InterceptorOptions interceptor(List<ClientHttpRequestInterceptor> interceptors) {
		initInterceptors().addAll(interceptors);
		return this;
	}

	public List<ClientHttpRequestInterceptor> build() {
		return this.interceptors == null ? Collections.emptyList() : this.interceptors;
	}

	private List<ClientHttpRequestInterceptor> initInterceptors() {
		if (this.interceptors == null) {
			this.interceptors = new ArrayList<>();
		}
		return this.interceptors;
	}

}