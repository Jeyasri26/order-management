package client;

import java.util.Scanner;
import ordermanagementdao.*;
import model.*;
import exception.*;
import connect.*;


public class OrderManagement {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        OrderManagement ordm = new OrderManagement();
        while (true) {
            System.out.println("1. createUser");
            System.out.println("2. createProduct");
            System.out.println("3. createOrder");
            System.out.println("4. cancelOrder");
            System.out.println("5. getAllProducts");
            System.out.println("6. getOrderbyUser");
            System.out.println("7. exit");

            System.out.println("Enter your choice: ");

            int ch = sc.nextInt();
            if (ch == 1) {
                ordm.createUser();

            } else if (ch == 2) {
                ordm.createProduct();

            } else if (ch == 3) {
                ordm.createOrder();

            } else if (ch == 4) {
                ordm.cancelOrder();

            }

            else if (ch == 5) {
                ordm.getAllProducts();

            }

            else if (ch == 6) {
                ordm.getOrderbyUser();

            }

            else if (ch == 7) {

                return;

            }

        }

    }
}
