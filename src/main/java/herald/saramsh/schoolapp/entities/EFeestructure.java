package herald.saramsh.schoolapp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="feestructures")
public class EFeestructure implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer feestructureid;
	private Integer grade;
	private String monthlyfee;
	private String examfee;
	
	public Integer getFeestructureid() {
		return feestructureid;
	}
	public void setFeestructureid(Integer feestructureid) {
		this.feestructureid = feestructureid;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getMonthlyfee() {
		return monthlyfee;
	}
	public void setMonthlyfee(String monthlyfee) {
		this.monthlyfee = monthlyfee;
	}
	public String getExamfee() {
		return examfee;
	}
	public void setExamfee(String examfee) {
		this.examfee = examfee;
	}
	
	

	
}
