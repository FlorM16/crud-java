package com.midominio.proyecto_basico.status;

public class StatusDTO {
	 private String database;
	    private String disk;
	    private String network;

	    // Getters y setters
	    public String getDatabase() {
	        return database;
	    }

	    public void setDatabase(String database) {
	        this.database = database;
	    }

	    public String getDisk() {
	        return disk;
	    }

	    public void setDisk(String disk) {
	        this.disk = disk;
	    }

	    public String getNetwork() {
	        return network;
	    }

	    public void setNetwork(String network) {
	        this.network = network;
	    }
	}