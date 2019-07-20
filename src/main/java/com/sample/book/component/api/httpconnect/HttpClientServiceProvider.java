package com.sample.book.component.api.httpconnect;

public abstract class HttpClientServiceProvider<C, H extends HttpClientOperations<C>, A> implements ServiceProvider<A> {

	private final H operations;

	public HttpClientServiceProvider(H operations) {
		this.operations = operations;
	}

	public H getOperations() {
		return this.operations;
	}

	public C getClient() {
		return this.operations.getClient();
	}

}