package test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Vote;
import beans.Voter;

public class Client {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Voter v = new Voter();
		v.setVid(111);
		v.setVname("Allen");
		v.setVage(25);
		Vote vt1 = new Vote();
		vt1.setPname("Congress");
		vt1.setCdate(new Date());
		vt1.setVoter(v);
		Vote vt2 = new Vote();
		vt2.setPname("Congress");
		vt2.setCdate(new Date());
		vt2.setVoter(v);
		s.save(v);
		s.save(vt1);
		// can not save two vote with one voter.if we will do Hibernate show exception
		// s.save(vt2);
		t.commit();
		System.out.println("Insertion Successfull");
		s.close();
		sf.close();
	}
}
