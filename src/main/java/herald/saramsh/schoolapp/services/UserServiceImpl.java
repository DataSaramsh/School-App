package herald.saramsh.schoolapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import herald.saramsh.schoolapp.dao.ActivitiesDao;
import herald.saramsh.schoolapp.dao.UserDao;
import herald.saramsh.schoolapp.domain.Activities;
import herald.saramsh.schoolapp.domain.User;
import herald.saramsh.schoolapp.entities.EActivities;
import herald.saramsh.schoolapp.entities.EUser;
import herald.saramsh.schoolapp.services.exceptions.UserAlreadyPresentException;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdaoimpl;
	@Autowired
	private ActivitiesDao activitiesdaoimpl;

	public boolean registerUser(User user) throws UserAlreadyPresentException {
		// to check whether the user is register or not
		EUser currentUser = userdaoimpl.getUser(user.getUsername());
		if(currentUser!=null)
			throw new UserAlreadyPresentException("The username is already registered!");
		//Add new user to database
		EUser dbuser=new EUser();
		dbuser.setAddress(user.getAddress());
		dbuser.setEmail(user.getEmail());
		dbuser.setFname(user.getFname());
		dbuser.setLname(user.getLname());
		dbuser.setPhoneno(user.getPhoneno());
		dbuser.setUsername(user.getUsername());
		dbuser.setRole(2);
		dbuser.setStatus(true);
	//Bcrypt for hashing
		String hashedpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		dbuser.setPassword(hashedpw);
		boolean result=userdaoimpl.saveUser(dbuser);
		return result;	
	}

	public List<Activities> getAllActivities() {
		//first we need to get all the activities from database .. for that we need to ask dao layer to do it
				List<EActivities> alldbactivities = activitiesdaoimpl.getAllActivities();
				
				//if no activities were found in db , return null
				if(alldbactivities == null || alldbactivities.size()==0)
					return null;
				
				//change entity objects to domain objects
				List<Activities> allactivities = new ArrayList<Activities>();
				for(EActivities ep:alldbactivities) {
					Activities a = new Activities();
					a.setId(ep.getActivitiesid());
					a.setName(ep.getActivitiesname());
					a.setDate(ep.getActivitiesdate());
					allactivities.add(a);
				}
				
				return allactivities;	
				
			}
	
}
