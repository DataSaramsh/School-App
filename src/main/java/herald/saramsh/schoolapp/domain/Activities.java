package herald.saramsh.schoolapp.domain;

import java.util.Date;

import javax.validation.constraints.Size;

public class Activities {

	private int id;
	
	@Size(min=2,max=20,message="Name must be between 2 and 20 characters long.")
	private String name;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
