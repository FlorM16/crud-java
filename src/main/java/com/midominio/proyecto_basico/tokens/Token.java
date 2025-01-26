package com.midominio.proyecto_basico.tokens;

import com.midominio.proyecto_basico.clients.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    private String token;
    
    @Column(insertable = false, updatable = false)
    private String clientId;
    
    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
    private Client client;

    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
