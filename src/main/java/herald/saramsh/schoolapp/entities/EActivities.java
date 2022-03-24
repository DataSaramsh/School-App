package herald.saramsh.schoolapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="activities")
public class EActivities implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue
	private Integer activitiesid;
	private String activitiesname;
	private Date activitiesdate;
	
	public Integer getActivitiesid() {
		return activitiesid;
	}
	public void setActivitiesid(Integer activitiesid) {
		this.activitiesid = activitiesid;
	}
	public String getActivitiesname() {
		return activitiesname;
	}
	public void setActivitiesname(String activitiesname) {
		this.activitiesname = activitiesname;
	}
	public Date getActivitiesdate() {
		return activitiesdate;
	}
	public void setActivitiesdate(Date activitiesdate) {
		this.activitiesdate = activitiesdate;
	}
	
	
	
	

}
