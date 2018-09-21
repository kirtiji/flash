import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test {
	public static void main(String[] args) {
		Student stu=new Student();
		Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter the student name");
	
		stu.setSname(sc.next());
		System.out.println("Enter the address");
		stu.setAddr(sc.next());
		Course c=new Course();
		System.out.println("Enter the course name");
		c.setCname(sc.next());
		Course c1=new Course();
		System.out.println("Enter the course name");
		c1.setCname(sc.next());
		stu.getScourse().add(c);
		stu.getScourse().add(c1);
		
		SessionFactory sf=Hibernateutil1.getSessionFactory();
		Session session=sf.openSession();
		session.save(stu);
		session.beginTransaction().commit();
		
		SessionFactory sf1=Hibernateutil1.getSessionFactory();
		Session session1=sf1.openSession();
		CriteriaBuilder builder=session1.getCriteriaBuilder();
		CriteriaQuery<Student> cquery=builder.createQuery(Student.class);
		Root<Student> root=cquery.from(Student.class);
		//cquery.select(root);
		//cquery.select(root).where(builder.equal(root.get("rollno"),1));
	//	cquery.select(root.get("sname"));
		
		Query query=session.createQuery(cquery);
		List<Student> liststu=query.getResultList();
		for(Student s:liststu)
		{
			System.out.println(s.getRollno());
			System.out.println(s.getSname());
			System.out.println(s.getAddr());
			session.save(s);
			session.beginTransaction().commit();
			
		}
	}

}
