package herald.saramsh.schoolapp.dao;

import java.util.List;
import herald.saramsh.schoolapp.entities.EFeestructure;

public interface FeestructureDao {
	
	public boolean saveFeestructure(EFeestructure feestructure);
	public List<EFeestructure> getAllFeestructures();
	public EFeestructure getFeestructureById(int id);

}
