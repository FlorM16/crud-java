package com.midominio.proyecto_basico.tokens;

public class TokenIntrospectResponse {
    private String clientId;

    public TokenIntrospectResponse(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}

