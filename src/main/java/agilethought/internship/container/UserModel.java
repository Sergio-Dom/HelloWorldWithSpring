package agilethought.internship.container;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private String firstName;
    private String lastName;
    private String email;
    

    @Override
    public String toString() {
        return String.format("UserModel{firstName='%s', lastName='%s', email = '%s'}", 
        		firstName, lastName, email);
    }


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}