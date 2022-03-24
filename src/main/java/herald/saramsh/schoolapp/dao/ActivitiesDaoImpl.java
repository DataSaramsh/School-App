package herald.saramsh.schoolapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import herald.saramsh.schoolapp.entities.EActivities;

@Repository
public class ActivitiesDaoImpl implements ActivitiesDao{

	@PersistenceContext
	private EntityManager manager;
	
	public boolean saveActivities(EActivities activity) {
		try {
			manager.persist(activity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public List<EActivities> getAllActivities(){
		Query q =manager.createQuery("SELECT a FROM EActivities a");
		List<EActivities> dd= q.getResultList();
		return dd;
	}
	
	public EActivities getActivityById(int id) {
	Query q=manager.createQuery("SELECT a FROM EActivities a WHERE a.activitiesid = :idss\"");
	q.setParameter("idss",id);
	EActivities a = (EActivities) q.getSingleResult();
	return a;
	
	}
}
