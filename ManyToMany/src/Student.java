
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rollno;
	private String sname;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	private String addr;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Student_course",joinColumns={@JoinColumn(name="rollno")},inverseJoinColumns={@JoinColumn(name="cid")})

	
	Set<Course> scourse=new HashSet<Course>();
	public Set<Course> getScourse() {
		return scourse;
	}
	public void setScourse(Set<Course> scourse) {
		this.scourse = scourse;
	}
	
	
	
	

}
