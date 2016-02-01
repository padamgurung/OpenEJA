package openeja.app;




import openeja.bo.javadb.Test;
import openeja.generate.EntityGenerator;



public class Program {

	public static void main(String[] args) {

	
		EntityGenerator e = new EntityGenerator();
		e.generateEntity("test","javadb");
		e.generateAllEntities("javadb");
		Test test = new Test();
		test.setId(8);
		test.setAddresss("Sundhara");
		test.setCreatedDate("2016-12-12");
		test.setEmail("padam.gurung@outook.com");
		test.setMobile("9843740777");
		test.setName("Padam Raj Gurung");
		test.setPrice(12.12);
	 //test.add();
		//test.update();
		test.remove();
		//test.load();
		System.out.println(test.getAddresss());
		System.out.println(test.getCreatedDate());
		System.out.println(test.getEmail());
		System.out.println(test.getId());
		System.out.println(test.getMobile());
		System.out.println(test.getName());
		System.out.println(test.getPrice());
		
		
		
		
	}

}
