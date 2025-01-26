package com.midominio.proyecto_basico.status;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.proyecto_basico.clients.ClientRepository;
import com.midominio.proyecto_basico.utils.ApiResponse;

@RestController
public class StatusController {
	
	 @Autowired
	    private ClientRepository clientRepository;

    @GetMapping("/status")
    public StatusDTO checkStatus() {
        StatusDTO status = new StatusDTO();
        try {
            clientRepository.findAll(); 
            status.setDatabase("success"); 
        } catch (Exception e) {
            status.setDatabase("failure"); 
        }

        File file = new File("/");  
        long freeSpace = file.getFreeSpace();
        if (freeSpace > 0) {
            status.setDisk("success");  
        } else {
            status.setDisk("failure");  
        }

        try {
            URL url = new URL("https://www.google.com"); 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);  
            connection.connect();

            if (connection.getResponseCode() == 200) {
                status.setNetwork("success"); 
            }
        } catch (IOException e) {
            status.setNetwork("failure");  
        }

        return status;
    }
}