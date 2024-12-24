package Users;

import java.util.ArrayList;

import Databases.OrderDB;
import Databases.ReceiveNoteDB;
import Databases.UserDB;
import Order.Order;
import Products.Book;
import Products.Product;
import Products.Toy;
import ReceiveNote.ReceiveNote;
import Store.Store;

public class Admin extends Staff {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";

	public Admin(String username, String password) throws Exception {
		super(username, password);
        UserDB userdb = new UserDB();
        userdb.update(this);
	}

    public void changeUserUsername(User u, String newname) throws Exception
    {
        u.setUsername(newname);
    }
    
    public void changeUserPassword(User u, String newpassword) throws Exception
    {
        u.setPassword(newpassword);
    }
}
