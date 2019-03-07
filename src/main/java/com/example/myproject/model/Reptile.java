package com.example.myproject.model;

public class Reptile {
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Reptile(String url) {
		super();
		this.url = url;
	}

	@Override
	public String toString() {
		return "Reptile [url=" + url + "]";
	}
	
	
	
}
