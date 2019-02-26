//package org.wecancodeit.reviewsite.repositories;
//
//
//import java.util.List;
//
//import org.wecancodeit.reviewsite.models.User;
//
//public class OriginalUsersRepository {
//
//		private List<User> users;
//
//		public OriginalUsersRepository(List<User> users) {
//			this.users = users;
//		}
//
//		public List<User> getUsers() {
//			return users;
//		}
//
//		public void addUser(User user) {
//			users.add(user);
//		}
//		
//		@Override
//		public String toString() {
//			return "UsersRepository [Users=" + users + "]";
//		}
//
//		public User findUser(String userName) {
//			User foundUser = null;
//			for (User user : users) {
//				if(user.getUserName().equals(userName)) {
//					foundUser = user;
//				}
//			}
//			return foundUser;
//		}
//
//		
//		
//		
//		
//}
