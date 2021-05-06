package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Account {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String user;
		private String pass;


		
		public Account() {
			
		}
		public Account(int id, String user, String pass) {
			this.id=id;
			this.user =user;
			this.pass = pass;
		}
		
		public Account(int id) {
			this.id=id;
		}
		
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		
		public int getId() {
			return id;
		}
		public void setId(String id) {
			try {
				this.id = Integer.parseInt(id);	
			}
			catch (NumberFormatException | NullPointerException e) {
				
			}
		}

}
