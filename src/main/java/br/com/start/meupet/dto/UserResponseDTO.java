package br.com.start.meupet.dto;

import br.com.start.meupet.domain.entities.User;

public class UserResponseDTO {

	private long id;
	private String name;
	private String password;
	private String email;
	private String cellPhoneNumber;

	public UserResponseDTO(User user) {
		this.id = user.getId().longValue();
		this.name = user.getName();
		this.password = user.getPassword();
		this.email = user.getEmail().toString();
		this.cellPhoneNumber = user.getCellPhoneNumber().toString();
	}

	public UserResponseDTO(long id, String name, String password, String email, String cellPhoneNumber) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

}