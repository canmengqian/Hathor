package com.zzz.hathor.cache.util.anotation;


public enum ExpireType {
	INTERNAL("INTERNAL"),
	TIME("TIME");
	private String type;

	
	public String getType() {
	
		return type;
	}

	
	public void setType(String type) {
	
		this.type = type;
	}


	private ExpireType(String type) {

		this.type = type;
	}
	
		
}
