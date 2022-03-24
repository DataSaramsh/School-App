package herald.saramsh.schoolapp.services;

import java.util.List;

import herald.saramsh.schoolapp.domain.Activities;
import herald.saramsh.schoolapp.domain.Enrolledstudent;
import herald.saramsh.schoolapp.domain.Feestructure;

public interface AdminService {

	    public List<Feestructure> getAllFeestructures();
		public boolean addNewFeestructure(Feestructure feestructure);
		public boolean addNewActivities(Activities activity);
		public List<Enrolledstudent> getAllEnrolledstudent();
	}

