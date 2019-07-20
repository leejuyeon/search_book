package com.sample.book.component.api.httpconnect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ConnectionFactoryRegistry implements ConnectionFactoryLocator {

	private final Map<String, ConnectionFactory<?>> connectionFactories = new HashMap<>(1);

	public void addConnectionFactory(ConnectionFactory<?> connectionFactory) {
		if (connectionFactories.containsKey(connectionFactory.getProviderId())) {
			throw new IllegalArgumentException("A ConnectionFactory for provider '" + connectionFactory.getProviderId() + "' has already been registered");
		}
		connectionFactories.put(connectionFactory.getProviderId(), connectionFactory);
	}

	public void setConnectionFactories(List<ConnectionFactory<?>> connectionFactories) {
		connectionFactories.forEach(this::addConnectionFactory);
	}

	@Override
	public ConnectionFactory<?> getConnectionFactory(String providerId) {
		return Optional.ofNullable(connectionFactories.get(providerId))
				.orElseThrow(() -> new IllegalArgumentException("No connection factory for service provider '" + providerId + "' is registered"));
	}

	@Override
	public <T> T getConnectionFactory(String providerId, Class<T> factoryType) {
		ConnectionFactory<?> factory = getConnectionFactory(providerId);
		return factoryType.cast(factory);
	}

}