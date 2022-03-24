package herald.saramsh.schoolapp.dao;

import java.util.List;
import herald.saramsh.schoolapp.entities.EActivities;

public interface ActivitiesDao {

	public boolean saveActivities(EActivities activity);
	public List<EActivities> getAllActivities();
	public EActivities getActivityById(int id);
}
