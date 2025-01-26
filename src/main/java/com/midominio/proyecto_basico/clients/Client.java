package com.midominio.proyecto_basico.clients;

import java.util.List;

import com.midominio.proyecto_basico.tokens.Token;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(unique = true)
    private String clientId;
    private String clientSecret;
    
    @OneToMany(mappedBy = "client")  
    private List<Token> tokens;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}