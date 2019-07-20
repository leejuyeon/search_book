package com.sample.book.component.api.httpconnect;

import org.springframework.lang.Nullable;

public abstract class ConnectionFactory<A> {

	private final String providerId;

	private final ServiceProvider<A> serviceProvider;

	public ConnectionFactory(String providerId, ServiceProvider<A> serviceProvider) {
		this.providerId = providerId;
		this.serviceProvider = serviceProvider;
	}

	protected abstract A getApi(ServiceProvider<A> serviceProvider, @Nullable ConnectionData connection);

	public A getApi() {
		return getApi(null);
	}

	public A getApi(@Nullable ConnectionData connection) {
		return getApi(getServiceProvider(), connection);
	}

	public String getProviderId() {
		return providerId;
	}

	protected ServiceProvider<A> getServiceProvider() {
		return serviceProvider;
	}
}