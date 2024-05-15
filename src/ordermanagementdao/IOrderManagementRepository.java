package ordermanagementdao;

import model.*;
import exception.*;
public interface IOrderManagementRepository {

    void createOrder(Order o);
	void cancelOrder(int orderId,int userId) throws OrderNotFound;
	void createProduct(Product p);
	void createUser(User u);
	void getAllProducts();
	void getOrderByUser(int userid) throws UserNotFound;
}
