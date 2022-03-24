package herald.saramsh.schoolapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="enrolledstudents")
public class EEnrolledstudent implements Serializable {
	
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
private Integer enrolledstudentid;
private String studentname;
private Date enrolleddate;
private String address;
private String phoneno;
private String email;

public Integer getEnrolledstudentid() {
	return enrolledstudentid;
}
public void setEnrolledstudentid(Integer enrolledstudentid) {
	this.enrolledstudentid = enrolledstudentid;
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public Date getEnrolleddate() {
	return enrolleddate;
}
public void setEnrolleddate(Date enrolleddate) {
	this.enrolleddate = enrolleddate;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}




}
