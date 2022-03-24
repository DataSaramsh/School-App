package herald.saramsh.schoolapp.dao;

import java.util.List;
import herald.saramsh.schoolapp.entities.EEnrolledstudent;

public interface EnrolledstudentDao {
	
	public boolean saveEnrolledstudent(EEnrolledstudent enrolledstudents);
	public List<EEnrolledstudent> getAllEnrolledstudents();

}
