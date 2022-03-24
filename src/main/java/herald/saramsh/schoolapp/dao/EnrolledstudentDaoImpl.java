package herald.saramsh.schoolapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import herald.saramsh.schoolapp.entities.EEnrolledstudent;

@Repository
public class EnrolledstudentDaoImpl implements EnrolledstudentDao{

    @PersistenceContext
    private EntityManager manager;
    
    public boolean saveEnrolledstudent(EEnrolledstudent enrolledstudents) {
    	try {
			manager.persist(enrolledstudents);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    public List<EEnrolledstudent> getAllEnrolledstudents(){
    	
    	Query q =manager.createQuery("SELECT e FROM EEnrolledstudent e");
		List<EEnrolledstudent> dd= q.getResultList();
		return dd;
    	
    }

}
