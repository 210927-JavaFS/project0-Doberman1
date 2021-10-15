import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.UserDAOImpl;
import com.revature.models.UserModel;
import com.revature.services.UserService;

public class UserServiceTests {
	
	public static UserService userservice;
	public static int ID;
	public static String name;
	public static UserModel user;
	public static String pass;
	public static int type;
	public static boolean boo;
	public static ArrayList<UserModel> list = new ArrayList<UserModel>();
	public static UserDAOImpl userDao = new UserDAOImpl();
	public static Logger log = LoggerFactory.getLogger(UserServiceTests.class);
	
	
	
	@BeforeEach
	public void setValues() {
		ID= 4;
		name = "jibob";
		pass = "Biggy";
		type = 1;
		boo = true;
		log.info("In setValues");
	}
	
	@Test
	public void testfindAllUsers() {
		log.info("In testfindAllUsers");
		list = (ArrayList<UserModel>) UserService.findAllUsers();
		assertEquals(list, userDao.findAll());
	}
	
	@Test
	public void testfindByID() {
		log.info("In testfindByID");
		user = userservice.findByID(ID);
		assertEquals(user, userDao.findByID(4));
	}
	
	@Test
	public void testfindByName() {
		log.info("In testfindByName");
		user = UserService.findByName(name);
		assertEquals(user, userDao.findByName("jibob"));
	}
	
	@Test
	public void testnewUser() {
		log.info("In testnewUser");
		boo = UserService.newUser(user);
		assertEquals(boo, userDao.addUser(user));
	}
	
	@Test
	public void testcheckPass() {
		log.info("In testcheckPass");
		boo = UserService.checkPass(pass, user);
		assertEquals(boo, userDao.checkPass("biggy", user));
	}
	
	@Test
	public void testchangeType() {
		log.info("In testfindAllUsers");
		boo = UserService.changeType(name, type);
		assertEquals(boo, userDao.changeType("jibob", 1));
	}
	
	
	@AfterEach
	public void clearValues() {
		user = null;
		list = null;
		boo = false;
		log.info("In clearValues");
	}
	
	@AfterAll 
	public static void clearuserservice() {
		userservice = null;
		log.info("in clearuserservice");
	}
	

}
