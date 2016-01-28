package OpenEJA.BO;

import OpenEJA.Annotation.Id;
import OpenEJA.Annotation.Table;
import OpenEJA.ORM.Entity;

@Table
public class User extends Entity {
	public User(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}



	@Id
	public String name;
	@Id
	public String email;
	public String mobileNumber;
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
