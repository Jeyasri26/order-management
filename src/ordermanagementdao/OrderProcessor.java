package ordermanagementdao;

import exception.UserNotFound;
import ordermanagementdao.*;
import model.*;
import connect.*;
import client.*;
public class OrderProcessor implements IOrderManagementRepository
{

	private Connection con;
	PreparedStatement stat;

	public OrderProcessor()
	{
		con=DBUtil.getConnect();
	}

	@Override
	public void createOrder(Order o)
	{
		try 
		{
			stat=con.prepareStatement("insert into orders values (?,?,?)");
			stat.setInt(1,o.getOrderId());
			stat.setInt(2, o.getUserId());
			stat.setInt(3, o.getProductId());
			stat.executeUpdate();
		} 
		catch (exception e) 
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void createProduct(Product p) 
	{
		try 
		{
			stat=con.prepareStatement("insert into Product (productId,userId,productName,description,price,quantityInStock,type) values (?,?,?,?,?,?,?)");
			stat.setInt(1, p.getProductId());
			stat.setInt(2,p.getUserId());
			stat.setString(3,p.getProductName());
			stat.setString(4,p.getDescription());
			stat.setDouble(5,p.getPrice());
			stat.setInt(6, p.getQuantityInStock());
			stat.setString(7,p.getType());
			stat.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void cancelOrder(int orderId, int userId) throws OrderNotFound {
		try 
		{
			boolean b=false;
			stat=con.prepareStatement("select * orders where orderid=? AND userid=?");
			stat.setInt(1, orderId);
			stat.setInt(2, userId);
			ResultSet r=stat.executeQuery();
			if(!b) 
			{
				throw new OrderNotFound("Order ID not found");

			}
		
			else 
			{
				stat=con.prepareStatement("delete from orders where orderid=? AND userid=?");
				stat.setInt(1, orderId);
				stat.setInt(2, userId);
			    stat.executeUpdate();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("The entered is Order ID not found   "+e.getMessage());
		}	
	}

	@Override
	public void createUser(User u) 
	{
		try {
			stat=con.prepareStatement("insert into user (userId,userName,password,role) values (?,?,?,?)");
			stat.setInt(1, u.getUserId());
			stat.setString(2,u.getUserName());
			stat.setString(3,u.getPassword());
			stat.setString(4,u.getRole());
			stat.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getAllProducts() 
	{
		try 
		{
			stat=con.prepareStatement("select * from product");
			ResultSet r=stat.executeQuery();
			while(r.next()){
            System.out.print("Product ID: "+r.getInt(1)+" "+"Product Name is :"+r.getString(2)+" "+"Description :"+" "+r.getString(3)+" "+"Price :"+" "+r.getInt(4)+" "+"Quantity in stock :"+" "+r.getInt(5)+" "+"Type :"+" "+r.getString(6)+"User ID :"+" "+r.getInt(7));
            System.out.println();
            System.out.println();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void getOrderByUser(int userId) throws UserNotFound{
	    try {
	        stat = con.prepareStatement("SELECT * FROM product WHERE userId = ?");
	        stat.setInt(1, userId);
	        ResultSet rs = stat.executeQuery();

	        boolean userFound = false; 

	        while (rs.next()) {
	            System.out.println("Product ID: " + rs.getInt(1) + " Product Name: " + rs.getString(2) + " Description: " + rs.getString(3) + " Price: " + rs.getInt(4) + " Quantity in stock: " + rs.getInt(5) + " Type: " + rs.getString(6) + " User ID: " + rs.getInt(7));

	            userFound = true;
	        }
	        if (!userFound) {
	            throw new UserNotFound("User with ID " + userId + " not found.");
	        }
	    } catch (SQLException e) {
	        e.getMessage(); 
	    }
	}

}
