package herald.saramsh.schoolapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import herald.saramsh.schoolapp.dao.ActivitiesDao;
import herald.saramsh.schoolapp.dao.EnrolledstudentDao;
import herald.saramsh.schoolapp.dao.FeestructureDao;
import herald.saramsh.schoolapp.domain.Activities;
import herald.saramsh.schoolapp.domain.Enrolledstudent;
import herald.saramsh.schoolapp.domain.Feestructure;
import herald.saramsh.schoolapp.entities.EActivities;
import herald.saramsh.schoolapp.entities.EEnrolledstudent;
import herald.saramsh.schoolapp.entities.EFeestructure;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
@Autowired
FeestructureDao feestructuredaoimpl; //help to inject all dao objects

@Autowired
ActivitiesDao activitiesdaoimpl;

@Autowired
EnrolledstudentDao enrolledstudentdaoimpl;

public List<Feestructure> getAllFeestructures() {
	
	List<EFeestructure> allfeestructuresfromdb = feestructuredaoimpl.getAllFeestructures();
	//change entity objects to domain objects
	List<Feestructure> feestructurestoreturn= new ArrayList();
	for(EFeestructure fee:allfeestructuresfromdb) {
		Feestructure f = new Feestructure();
		f.setId(fee.getFeestructureid());
		f.setGrade(fee.getGrade());
		feestructurestoreturn.add(f);
	}
	
	return feestructurestoreturn;
}
public boolean Feestructure(Feestructure feestructure) {
	
	EFeestructure efee = new EFeestructure();
	efee.setGrade(feestructure.getGrade());
	
	return feestructuredaoimpl.saveFeestructure(efee);
}
public boolean addNewActivities(Activities activity) {
	
	
	EActivities dbactivities = new EActivities();
	dbactivities.setActivitiesdate(activity.getDate());
	dbactivities.setActivitiesname(activity.getName());

	
	boolean databaseaddresult = activitiesdaoimpl.saveActivities(dbactivities);
	return databaseaddresult;
	}

public List<Enrolledstudent> getAllEnrolledstudent(){
	List<EEnrolledstudent> allenrolledstudentindb=enrolledstudentdaoimpl.getAllEnrolledstudents();
	List<Enrolledstudent> allenrolledstudent = new ArrayList();
	
	for(EEnrolledstudent enrolledstudent:allenrolledstudentindb) {
		Enrolledstudent aa=new Enrolledstudent();
		aa.setId(enrolledstudent.getEnrolledstudentid());
		aa.setDate(enrolledstudent.getEnrolleddate());
		aa.setPhoneno(enrolledstudent.getPhoneno());
		aa.setUsername(enrolledstudent.getStudentname());
	}
	return allenrolledstudent;
}
public boolean addNewFeestructure(herald.saramsh.schoolapp.domain.Feestructure feestructure) {
	// TODO Auto-generated method stub
	return false;
}


}
