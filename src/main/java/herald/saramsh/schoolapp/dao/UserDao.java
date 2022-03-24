package herald.saramsh.schoolapp.dao;

import herald.saramsh.schoolapp.entities.EUser;

public interface UserDao {
	
	public boolean saveUser(EUser user);
	public EUser getUser(String username);

}
