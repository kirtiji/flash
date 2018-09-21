import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test1 {
	
	public static void main(String[] args) {
		SessionFactory sf=Hibernateutil1.getSessionFactory();
		Session session=sf.openSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Object[]> cquery=builder.createQuery(Object[].class);
		Root<Student> sroot=cquery.from(Student.class);
		Root<Course> croot=cquery.from(Course.class);
		cquery.multiselect(croot,sroot);
		cquery.where(builder.equal(croot.get("cname"),sroot.get("sname")));
		Query<Object[]> query=session.createQuery(cquery);
		List<Object[]> listemp=query.getResultList();
		System.out.println(listemp);
		for(Object[] obj:listemp)
		{
			Student s=(Student)obj[0];
			Course c=(Course)obj[1];
			//System.out.println(s);
			System.out.println("hii");
			System.out.println(s.getSname());
			System.out.println(s.getRollno());
			System.out.println(s.getAddr());
			System.out.println(c.getCid());
			System.out.println(c.getCname());
			
			//session.save(s);
			//session.beginTransaction().commit();
			
			/*System.out.println(obj[0]);
			System.out.println(obj[1]);*/
			
			
		}
		
	}

}
