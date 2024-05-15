package ordermanagementdao;

import java.util.Scanner;

import exception.OrderNotFound;
import ordermanagementdao.*;
import model.*;
import connect.*;
import client.*;

public class OrderManagement {
    Scanner sc;
	OrderProcessor OP;

	public OrderManagement()
	{
		sc=new Scanner(System.in);
		OP=new OrderProcessor();
	}
	public void createOrder()
	{
		Order o=new Order();
		System.out.println("Enter order id :");
		o.setOrderId(sc.nextInt());
		System.out.println("Enter user ID :");
		o.setUserId(sc.nextInt());
		System.out.println("Enter product ID :");
		o.setProductId(sc.nextInt());

		OP.createOrder(o);
	}

	public void cancelOrder()
	{
		Order o=new Order();
		System.out.println("Enter order id  to cancel :");
		int orderid=sc.nextInt();
		System.out.println("Enter userid :");
		int userid=sc.nextInt();
	    try {
			OP.cancelOrder(orderid, userid);
		} 
	    catch (OrderNotFound e){
			e.getMessage();
		}
	}
	public void creatProduct()
	{
		Product p=new Product();

		System.out.println("Enter product ID :");
		p.setProductId(sc.nextInt());
		System.out.println("Enter user ID :");
		p.setUserId(sc.nextInt());
		System.out.println("Enter product name :");
		sc.nextLine();
		p.setProductName(sc.nextLine());
		System.out.println("Enter product description :");
		p.setDescription(sc.nextLine());
		System.out.println("Enter price :");
		p.setPrice(sc.nextDouble());
		System.out.println("Enter quantity in stock :");
		p.setQuantityInStock(sc.nextInt());
		System.out.println("Enter type either Clothing or Electronics :");
		sc.nextLine();
		p.setType(sc.nextLine());

		OP.createProduct(p);
	}

	public void createUser()
	{
		User u=new User();
		System.out.println("Enter user ID :");
		u.setUserId(sc.nextInt());
		System.out.println("Enter User name :");
		sc.nextLine();
		u.setUserName(sc.nextLine());
		System.out.println("Enter Password :");
		u.setPassword(sc.nextLine());
		System.out.println("Enter role either Admin or User :");
		u.setRole(sc.nextLine());
		OP.createUser(u);
	}

	public void getAllProducts()
	{
		OP.getAllProducts();
	}
	public void getorderByuser() 
	{
		System.out.println("Enter user ID to get product name :");
		int userid=sc.nextInt();
		try {
			OP.getOrderByUser(userid);
		} catch (UserNotFound e) 
		{
			e.printStackTrace();
		}

	}
}
    
