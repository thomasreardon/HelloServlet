package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.ErsUser;
public class EmployeeUser extends ErsUser {

		List<ErsUser> users = new ArrayList<>();
		Map<String, ErsUser> usersByEmail = new HashMap<>();
		public void create(EmployeeUser user) {
			if (usersByEmail.containsKey(user.getEmail())) {
				//throw new HttpException(400, "Email in use.");
			}
			
			users.add(user);
			usersByEmail.put(user.getEmail(), user);
		
		}
		
		public void findEmployee (int id) {
			
		}
		
		public int findIdBy(String username, String password) {
			int id=0;
			return id;
		}
}
