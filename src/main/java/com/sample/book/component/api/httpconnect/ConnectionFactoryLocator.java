package com.sample.book.component.api.httpconnect;

public interface ConnectionFactoryLocator {

	ConnectionFactory<?> getConnectionFactory(String providerId);

	<T> T getConnectionFactory(String providerId, Class<T> factoryType);

}