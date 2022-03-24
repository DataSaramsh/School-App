package herald.saramsh.schoolapp.services;

import java.util.List;

import herald.saramsh.schoolapp.domain.Activities;
import herald.saramsh.schoolapp.domain.User;
import herald.saramsh.schoolapp.services.exceptions.UserAlreadyPresentException;

public interface UserService {

	public boolean registerUser(User user) throws UserAlreadyPresentException;

	public List<Activities> getAllActivities();
	
		
	

}
