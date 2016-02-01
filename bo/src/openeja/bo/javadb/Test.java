package openeja.bo.javadb;

import openeja.annotation.*;
import openeja.orm.Entity;

@Table(name = "test")
public class Test extends Entity {

	@Id
	@AutoGenerated
	@Column(name = "id", type = "int")
	public int id;

	@Column(name = "name", type = "varchar", length = "50")
	public String name;

	@Column(name = "email", type = "varchar", length = "256")
	public String email;

	@Column(name = "mobile", type = "varchar", length = "15")
	public String mobile;

	@Column(name = "addresss", type = "text", length = "65535")
	public String addresss;

	@Column(name = "created_date", type = "datetime")
	public String createdDate;

	@Column(name = "price", type = "double")
	public double price;

	public Test(){
		this.id = 0;
		this.name = "";
		this.email = "";
		this.mobile = "";
		this.addresss = "";
		this.createdDate = "2016/02/01 22:00:32";
		this.price = 0.0;

	}
}