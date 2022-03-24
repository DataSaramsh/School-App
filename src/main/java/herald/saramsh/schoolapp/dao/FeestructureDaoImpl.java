package herald.saramsh.schoolapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import herald.saramsh.schoolapp.entities.EFeestructure;
@Repository
public class FeestructureDaoImpl implements FeestructureDao {

	@PersistenceContext
	private EntityManager manager;
	
	public boolean saveFeestructure(EFeestructure feestructure) {
		try {
			manager.persist(feestructure);
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
	public List<EFeestructure> getAllFeestructures(){
		Query q =manager.createQuery("SELECT f FROM EFeestructure f");
		List<EFeestructure> dd= q.getResultList();
		return dd;

		}
	
		public EFeestructure getFeestructureById(int id){
		Query q=manager.createQuery("SELECT f FROM EFeestructure f WHERE f.feestructureid = :idss");  
		q.setParameter("idss",id);
		EFeestructure u = (EFeestructure) q.getSingleResult();
		return u;
	}
	
	
	
	
	
}
