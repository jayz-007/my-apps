import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.techlab.entity.User;
import com.techlab.repository.UserRepository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Test {
	public static void main(String args[]) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		User jay = new User();
		jay.setId("101");
		jay.setFirstName("jay");
		jay.setLastName("shelke");
		jay.setEmail("j@gmail.com0");
		jay.setUsermame("j007");
		jay.setPassword("12345");
		
		System.out.println(jay.getFirstname());
		
		
		List<User> users = new UserRepository().getUsers();
		System.out.println(users.size());
		//new UserRepository().addUser(jay.getFirstName(), jay.getLastName(), jay.getEmail(), jay.getUsermame(), jay.getPassword());
		jay.setLastName("jayEdited");
		
	}

}
