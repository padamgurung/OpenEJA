package openeja.bo.javadb;

import openeja.annotation.*;
import openeja.orm.Entity;

@Table(name = "user")
public class User extends Entity {

	@Id
	@AutoGenerated
	@Column(name = "id", type = "int")
	private int id;

	@Column(name = "name", type = "varchar", length = "256")
	private String name;

	@Column(name = "email", type = "varchar", length = "256")
	private String email;

	@Column(name = "mobile_number", type = "varchar", length = "256")
	private String mobileNumber;

	public User(){
		this.id = 0;
		this.name = "";
		this.email = "";
		this.mobileNumber = "";

	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}
	public String getMobileNumber(){
		return mobileNumber;
	}
}
