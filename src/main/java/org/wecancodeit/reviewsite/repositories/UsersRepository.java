package org.wecancodeit.reviewsite.repositories;


import java.util.List;

import org.wecancodeit.reviewsite.models.PersonForm;

public class UsersRepository {

		private List<PersonForm> users;

		public UsersRepository(List<PersonForm> users) {
			this.users = users;
		}

		public List<PersonForm> getUsers() {
			return users;
		}

		public void addUser(PersonForm user) {
			users.add(user);
		}
		
		@Override
		public String toString() {
			return "UsersRepository [Users=" + users + "]";
		}
		

		
		
		
		
}
