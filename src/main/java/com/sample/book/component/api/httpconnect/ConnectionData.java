package com.sample.book.component.api.httpconnect;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.lang.Nullable;

@SuppressWarnings("serial")
public class ConnectionData implements Serializable {

	@Nullable
	private final String accessToken;

	public ConnectionData(@Nullable String accessToken) {
		this.accessToken = accessToken;
	}

	@Nullable
	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public int hashCode() {
		int hashCode = 7;
		return Optional.ofNullable(accessToken).map(token -> hashCode + token.hashCode()).orElse(hashCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ConnectionData)) {
			return false;
		}
		ConnectionData other = (ConnectionData) obj;
		return Optional.ofNullable(accessToken).map(token -> token.equals(other.accessToken)).orElseGet(() -> other.accessToken == null);
	}

	@Override
	public String toString() {
		return "ConnectionData [accessToken=" + Optional.ofNullable(accessToken).orElse("-") + "]";
	}
}