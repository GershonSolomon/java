package com.super_market.curdfunc;
import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
class SuperMarket{
	public void customer_table()throws Exception {
		String url = "jdbc:mysql://localhost:3306/super_market";
		String username = "root";
		String pass = "Gero@2002";
		Connection c = DriverManager.getConnection(url, username, pass);
		
		ResultSet rs;
		PreparedStatement st;
		Statement stmt = c.createStatement();

		String q = "";
		int choice;
		long phone_number,customer_id;
		String customer_name, address,col;
		String dob;

		Scanner s = new Scanner(System.in);

		System.out.println("      Customer Details:");
		System.out.println("----------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Select");
		System.out.println("3.Update");
		System.out.println("4.Delete");
		System.out.println("5.Exit");

		System.out.println("Enter your choice :");

		choice = s.nextInt();

		switch (choice) {

		case 1:

			System.out.println("----------------------------------");
			System.out.println("Inserting new data");
			System.out.println("Enter the Customer id:");
			customer_id = s.nextLong();
			System.out.println("Enter the Customer name:");
			customer_name = s.next();
			System.out.println("Enter the mobile number :");
			phone_number = s.nextLong();
			System.out.println("Enter the dob:(in yyyy-mm-dd format)");
			//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dob = s.next();
			System.out.println("Enter the address :");
			address = s.next();
			while(s.hasNext()) 
			{
				address = address + s.next();
				break;
			}
			q = "insert into customer (customer_id,customer_name,phone_number,address,dob) values(?,?,?,?,?)";
			st = c.prepareStatement(q);
			st.setLong(1, customer_id);
			st.setString(2, customer_name);
			st.setLong(3,phone_number);
			st.setString(4, address);
			st.setString(5,  dob);

			st.executeUpdate();
			System.out.println("Data Insert Success");
			break;

		case 2:
			
			System.out.println("----------------------------------");
			System.out.println("Print all records");
			q = "SELECT customer_id,customer_name,phone_number,address,dob FROM customer";
			stmt = c.prepareStatement(q);
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				customer_id = rs.getLong("customer_id");
				customer_name = rs.getString("customer_name");
				phone_number = rs.getLong("phone_number");
				address = rs.getString("address");
				dob = rs.getString("dob");

				System.out.print(customer_id + " 	");
				System.out.print(customer_name + " 	");
				System.out.print(phone_number + " 	");
				System.out.print(address + " 	");
				System.out.println(dob + " 	");

			}

			break;
			
		case 3:
			
			System.out.println("----------------------------------");
			System.out.println("Update the existing customer details ");
			System.out.println("Enter the customer ID:");
			customer_id = s.nextLong();
			System.out.println("Enter the customer dob:(in yyyy-mm-dd format)");
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			dob = s.next();
			System.out.println("Enter the customer name:");
			customer_name = s.next();
			System.out.println("Enter the customer phone number:");
			phone_number = s.nextLong();
			System.out.println("Enter the customer address:");
			address = s.next();
			while(s.hasNext()) 
			{
				address = address + s.next();
				break;
			}
			
			
			q = "update customer set customer_name = ?, phone_number = ?, address = ?, dob = ? where customer_id = ?";
			st = c.prepareStatement(q);
			st.setString(1, customer_name);
			st.setLong(2, phone_number);
			st.setString(3, address);
			st.setString(4, dob);
			st.setLong(5, customer_id);

			st.executeUpdate();
			System.out.println("Data update Success");
			break;
			
		case 4:
			
			System.out.println("----------------------------------");
			System.out.println("Deleting a customer");
			System.out.println("Enter the customer id:");
			customer_id = s.nextLong();
			
			q= "Delete from customer where customer_id=?";
			st = c.prepareStatement(q);
			st.setLong(1, customer_id);
			
			st.execute();
			System.out.println("Deleted successfully");
			break;
			
		case 5:
			
			System.out.println("----------------------------------");
			System.out.println("Thank You");
			System.exit(0);
			break;
			
		default:

			System.out.println("Invalid choice");
			break;

		}
	}

public void product_table()throws Exception {
	String url = "jdbc:mysql://localhost:3306/super_market";
	String username = "root";
	String pass = "Gero@2002";
	Connection c = DriverManager.getConnection(url, username, pass);
	
	ResultSet rs;
	PreparedStatement st;
	Statement stmt = c.createStatement();

	String q = "";
	int choice;
	long product_id,category_id,supplier_id;
	String product_name,col;
	float price;

	Scanner s = new Scanner(System.in);

	System.out.println("      Product Details:");
	System.out.println("----------------------------------");
	System.out.println("1.Insert");
	System.out.println("2.Select");
	System.out.println("3.Update");
	System.out.println("4.Delete");
	System.out.println("5.Exit");

	System.out.println("Enter your choice :");

	choice = s.nextInt();

	switch (choice) {

	case 1:

		System.out.println("----------------------------------");
		System.out.println("Inserting new data");
		System.out.println("Enter the Product id:");
		product_id = s.nextLong();
		System.out.println("Enter the product name :");
		product_name = s.next();
		System.out.println("Enter the Category_id:");
		category_id = s.nextLong();
		System.out.println("Enter the Supplier_id :");
		supplier_id = s.nextLong();
		
		System.out.println("Enter the price :");
		price = s.nextFloat();
		
		q = "insert into product (product_id,product_name,category_id,price,supplier_id) values(?,?,?,?,?)";
		st = c.prepareStatement(q);
		st.setLong(1, product_id);
		st.setString(2, product_name);
		st.setLong(3,category_id);
		st.setFloat(4, price);
		st.setLong(5,  supplier_id);

		st.executeUpdate();
		System.out.println("Data Insert Success");
		break;

	case 2:
		
		System.out.println("----------------------------------");
		System.out.println("Print all records");
		q = "SELECT product_id,product_name,category_id,price,supplier_id FROM product";
		stmt = c.prepareStatement(q);
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			product_id = rs.getLong("customer_id");
			product_name = rs.getString("customer_name");
			category_id = rs.getLong("phone_number");
			price = rs.getFloat("address");
			supplier_id = rs.getLong("dob");

			System.out.print(product_id + " 	");
			System.out.print(product_name + " 	");
			System.out.print(category_id + " 	");
			System.out.print(price + " 	");
			System.out.println(supplier_id + " 	");

		}

		break;
		
	case 3:
		
		System.out.println("----------------------------------");
		System.out.println("Update the existing product details ");
		System.out.println("Enter the product ID:");
		product_id= s.nextLong();
		System.out.println("Enter product name:");
		
		product_name = s.next();
		System.out.println("Enter the category_id:");
		category_id = s.nextLong();
		System.out.println("Enter the price:");
		price = s.nextFloat();
		System.out.println("Enter the supplier_id:");
		supplier_id = s.nextLong();
		
		
		
		q = "update product set  product_name = ?, category_id = ?, price = ?, supplier_id =? where product_id = ?";
		st = c.prepareStatement(q);
		st.setString(1, product_name);
		st.setLong(2, category_id);
		st.setFloat(3, price);
		st.setLong(4, supplier_id);
		st.setLong(5, product_id);

		st.executeUpdate();
		System.out.println("Data update Success");
		break;
		
	case 4:
		
		System.out.println("----------------------------------");
		System.out.println("Deleting a product");
		System.out.println("Enter the product id:");
		product_id = s.nextLong();
		
		q= "Delete from customer where customer_id=?";
		st = c.prepareStatement(q);
		st.setLong(1, product_id);
		
		st.execute();
		System.out.println("Deleted successfully");
		break;
		
	case 5:
		
		System.out.println("----------------------------------");
		System.out.println("Thank You");
		System.exit(0);
		break;
		
	default:

		System.out.println("Invalid choice");
		break;

	}
}
public void category_table()throws Exception {
	String url = "jdbc:mysql://localhost:3306/super_market";
	String username = "root";
	String pass = "Gero@2002";
	Connection c = DriverManager.getConnection(url, username, pass);
	
	ResultSet rs;
	PreparedStatement st;
	Statement stmt = c.createStatement();

	String q = "";
	int choice;
	long category_id;
	String name,description;
	

	Scanner s = new Scanner(System.in);

	System.out.println("      Category Details:");
	System.out.println("----------------------------------");
	System.out.println("1.Insert");
	System.out.println("2.Select");
	System.out.println("3.Update");
	System.out.println("4.Delete");
	System.out.println("5.Exit");

	System.out.println("Enter your choice :");

	choice = s.nextInt();

	switch (choice) {

	case 1:

		System.out.println("----------------------------------");
		System.out.println("Inserting new data");
		System.out.println("Enter category id:");
		category_id = s.nextLong();
		System.out.println("Enter the category name :");
		name = s.next();
		
		System.out.println("Enter the Description :");
		description = s.next();
		
		
		
		q = "insert into category (category_id,name,description) values(?,?,?)";
		st = c.prepareStatement(q);
		st.setLong(1, category_id);
		st.setString(2, name);
		st.setString(3,description);
		

		st.executeUpdate();
		System.out.println("Data Insert Success");
		break;

	case 2:
		
		System.out.println("----------------------------------");
		System.out.println("Print all records");
		q = "SELECT category_id,name,description FROM category";
		stmt = c.prepareStatement(q);
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			category_id = rs.getLong("category_id");
			name = rs.getString("name");
			description = rs.getString("description");
			

			System.out.print(category_id + " 	");
			System.out.print(name + " 	");
			System.out.print(description + " 	");
			

		}

		break;
		
	case 3:
		
		System.out.println("----------------------------------");
		System.out.println("Update the existing category details ");
		System.out.println("Enter the category ID:");
		category_id= s.nextLong();
		System.out.println("Enter  name:");
		
		name = s.next();
		System.out.println("Enter the description:");
		description = s.next();
		
		
		
		
		q = "update category set  name = ?,description=? where category_id = ?";
		st = c.prepareStatement(q);
		st.setString(1, name);
		st.setString(2, description);
		st.setLong(3, category_id);
		
		st.executeUpdate();
		System.out.println("Data update Success");
		break;
		
	case 4:
		
		System.out.println("----------------------------------");
		System.out.println("Deleting a category");
		System.out.println("Enter the category id:");
		category_id = s.nextLong();
		
		q= "Delete from category where category_id=?";
		st = c.prepareStatement(q);
		st.setLong(1, category_id);
		
		st.execute();
		System.out.println("Deleted successfully");
		break;
		
	case 5:
		
		System.out.println("----------------------------------");
		System.out.println("Thank You");
		System.exit(0);
		break;
		
	default:

		System.out.println("Invalid choice");
		break;

	}
}
public void supplier_table()throws Exception {
	String url = "jdbc:mysql://localhost:3306/super_market";
	String username = "root";
	String pass = "Gero@2002";
	Connection c = DriverManager.getConnection(url, username, pass);
	
	ResultSet rs;
	PreparedStatement st;
	Statement stmt = c.createStatement();

	String q = "";
	int choice;
	long phone_number,supplier_id;
	String supplier_name, address,col;
	

	Scanner s = new Scanner(System.in);

	System.out.println("      Supplier Details:");
	System.out.println("----------------------------------");
	System.out.println("1.Insert");
	System.out.println("2.Select");
	System.out.println("3.Update");
	System.out.println("4.Delete");
	System.out.println("5.Exit");

	System.out.println("Enter your choice :");

	choice = s.nextInt();

	switch (choice) {

	case 1:

		System.out.println("----------------------------------");
		System.out.println("Inserting new data");
		System.out.println("Enter the supplier id:");
		supplier_id = s.nextLong();
		System.out.println("Enter the supplier name:");
		supplier_name = s.next();
		System.out.println("Enter the mobile number :");
		phone_number = s.nextLong();
		
		System.out.println("Enter the address :");
		address = s.next();
		while(s.hasNext()) 
		{
			address = address + s.next();
			break;
		}
		q = "insert into supplier (supplier_id,supplier_name,phone_number,address) values(?,?,?,?)";
		st = c.prepareStatement(q);
		st.setLong(1, supplier_id);
		st.setString(2, supplier_name);
		st.setLong(3,phone_number);
		st.setString(4, address);
		

		st.executeUpdate();
		System.out.println("Data Insert Success");
		break;

	case 2:
		
		System.out.println("----------------------------------");
		System.out.println("Print all records");
		q = "SELECT supplier_id,supplier_name,phone_number,address FROM supplier";
		stmt = c.prepareStatement(q);
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			supplier_id = rs.getLong("supplier_id");
			supplier_name = rs.getString("supplier_name");
			phone_number = rs.getLong("phone_number");
			address = rs.getString("address");
			

			System.out.print(supplier_id + " 	");
			System.out.print(supplier_name + " 	");
			System.out.print(phone_number + " 	");
			System.out.print(address + " 	");

		}

		break;
		
	case 3:
		
		System.out.println("----------------------------------");
		System.out.println("Update the existing customer details ");
		System.out.println("Enter the supplier ID:");
		supplier_id = s.nextLong();

		System.out.println("Enter the supplier name:");
		supplier_name = s.next();
		System.out.println("Enter the supplier phone number:");
		phone_number = s.nextLong();
		System.out.println("Enter the supplier address:");
		address = s.next();
		while(s.hasNext()) 
		{
			address = address + s.next();
			break;
		}
		
		
		q = "update supplier set supplier_name = ?, phone_number = ?, address = ? where supplier_id = ?";
		st = c.prepareStatement(q);
		st.setString(1, supplier_name);
		st.setLong(2, phone_number);
		st.setString(3, address);
		st.setLong(4, supplier_id);

		st.executeUpdate();
		System.out.println("Data update Success");
		break;
		
	case 4:
		
		System.out.println("----------------------------------");
		System.out.println("Deleting a supplier");
		System.out.println("Enter the supplier id:");
		supplier_id = s.nextLong();
		
		q= "Delete from supplier where supplier_id=?";
		st = c.prepareStatement(q);
		st.setLong(1, supplier_id);
		
		st.execute();
		System.out.println("Deleted successfully");
		break;
		
	case 5:
		
		System.out.println("----------------------------------");
		System.out.println("Thank You");
		System.exit(0);
		break;
		
	default:

		System.out.println("Invalid choice");
		break;

	}
}


}


public class Curd {
	public static void main(String[] args)throws Exception {
		int choice;
		Scanner scan=new Scanner(System.in);
		
		/*String url = "jdbc:mysql://localhost:3306/super_market";
		String username = "root";
		String pass = "Gero@2002";
		Connection c = DriverManager.getConnection(url, username, pass);

		Statement stmt = c.createStatement();
		ResultSet rs;
		PreparedStatement st;*/

		SuperMarket obj=new SuperMarket();
		
		System.out.println("Enter 1 to do operation in customer_table");
		System.out.println("Enter 2 to do operation in product_table");
		System.out.println("Enter 3 to do operation in category_table");
		System.out.println("Enter 4 to do operation in supplier_table");
		choice=scan.nextInt();
		switch(choice) {
		case 1:
			obj.customer_table();
			break;
		case 2:
			obj.product_table();
			break;
		case 3:
			obj.category_table();
			break;
		case 4:
			obj.supplier_table();
			break;
		default:

			System.out.println("Invalid choice");
			break;
		}
		scan.close();
		}
	}
	


