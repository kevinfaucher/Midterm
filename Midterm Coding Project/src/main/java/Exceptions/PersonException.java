package Exceptions;

import java.util.Date;

public class PersonException extends Exception {
	
	private Date DOB;
	private String phoneNumber;
	public PersonException(Date DOB){
		this.DOB = DOB;
	}
	public Date getDOB(){
		return DOB;
	}
	
	public PersonException(String phonenumber){
		this.phoneNumber = phonenumber;
	}
	public String getpn(){
		return phoneNumber;
	}

}