package com.daw.onepiece.dtos;

import java.util.List;

public class JwtDTO {
	private String token;
	private String type = "Bearer";
	
	private String usuario;
	private List<String> roles;
	
	public JwtDTO(String token, String usuario, List<String> roles) {
		super();
		this.token = token;
		this.usuario = usuario;
		this.roles = roles;
		}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
