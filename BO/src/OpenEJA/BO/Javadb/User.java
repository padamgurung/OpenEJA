package OpenEJA.BO.Javadb;

import OpenEJA.Annotation.*;
import OpenEJA.ORM.Entity;

@Table(name = "user")
public class User extends Entity {

	@Id
	@AutoGenerated
	@Column(name = "id", type = "int")
	public int id;

	@Column(name = "name", type = "varchar", length = "256")
	public String name;

	@Column(name = "email", type = "varchar", length = "256")
	public String email;

	@Column(name = "mobile_number", type = "varchar", length = "256")
	public String mobileNumber;

	public User(){
		this.id = 0;
		this.name = "";
		this.email = "";
		this.mobileNumber = "";

	}
}
