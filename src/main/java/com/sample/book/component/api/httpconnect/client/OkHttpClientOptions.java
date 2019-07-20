package com.sample.book.component.api.httpconnect.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

import com.sample.book.component.api.httpconnect.ListableOptions;

import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class OkHttpClientOptions {

	private OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

	public OkHttpClientOptions connectionPool(int maxIdleConnections, int keepAliveDurationSeconds) {
		okHttpClientBuilder.connectionPool(new ConnectionPool(maxIdleConnections, keepAliveDurationSeconds, TimeUnit.SECONDS));
		return this;
	}

	public OkHttpClientOptions connectTimeout(int timeoutMillis) {
		okHttpClientBuilder.connectTimeout(timeoutMillis, TimeUnit.MILLISECONDS);
		return this;
	}

	public OkHttpClientOptions readTimeout(int timeoutMillis) {
		okHttpClientBuilder.readTimeout(timeoutMillis, TimeUnit.MILLISECONDS);
		return this;
	}

	public OkHttpClientOptions interceptors(Function<ListableOptions<Interceptor>, List<Interceptor>> options) {
		List<Interceptor> interceptors = options.apply(new ListableOptions<Interceptor>());
		interceptors.forEach(interceptor -> okHttpClientBuilder.addInterceptor(interceptor));
		return this;
	}

	public OkHttpClientOptions networkInterceptors(Function<ListableOptions<Interceptor>, List<Interceptor>> options) {
		List<Interceptor> interceptors = options.apply(new ListableOptions<Interceptor>());
		interceptors.forEach(interceptor -> okHttpClientBuilder.addNetworkInterceptor(interceptor));
		return this;
	}

	public OkHttpClientOptions proxy(Consumer<ProxyOptions> proxyConsumer) {
		proxyConsumer.accept(new ProxyOptions(okHttpClientBuilder));
		return this;
	}

	public OkHttpClient build() {
		return okHttpClientBuilder.build();
	}

	public static class ProxyOptions {

		private final OkHttpClient.Builder builder;

		private ProxyOptions(OkHttpClient.Builder builder) {
			this.builder = builder;
		}

		public ProxyOptions host(String hostName, int port) {
			builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostName, port)));
			return this;
		}

		public ProxyOptions basic(String userName, String password) {
			return authenticator(new Authenticator() {
				@Override
				public Request authenticate(Route route, Response response) throws IOException {
					String credential = Credentials.basic(userName, password);
					return response.request().newBuilder().header("Proxy-Authorization", credential).build();
				}
			});
		}

		public ProxyOptions authenticator(Authenticator authenticator) {
			builder.proxyAuthenticator(authenticator);
			return this;
		}

	}

}