package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class Jpa3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("runs");
		read();
		// update();
		// insert();
		// delete();
		delete1();
		update1();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Jpa3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Test> cq = cb.createQuery(Test.class);
		
		
		Root<Test> t2 = cq.from(Test.class);
		cq.select(t2);
		TypedQuery<Test> q = em.createQuery(cq);
		List<Test> allPets = null;
		try {
			allPets = q.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
		} finally {
			em.close();
		}
		// Iterator<Test> it=allPets.iterator();
		// while(it.hasNext()){
		// System.out.println("\n the result is"+it.next());
		// }
		for (Test si : allPets) {
			System.out.println("**** id is  " + si.getId());
			System.out.println(" **** name is  " + si.getName()+"\n");

		}
		// System.out.print("***runs"+allPets);

	}

	private static void update1() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Jpa3");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaUpdate<Test> update=cb.createCriteriaUpdate(Test.class);
		Root<Test>e=update.from(Test.class);
		update.set("name", "babak");
		update.where(cb.equal(e.get("id"), 8));
		Query query=em.createQuery(update);
		query.executeUpdate();
		em.getTransaction().commit();
		
	}

	private static void delete1() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Jpa3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	//	Cri
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaDelete delete=cb.createCriteriaDelete(Test.class);
		Root e=delete.from(Test.class);
		delete.where(cb.equal(e.get("id"), 1));
		Query query=em.createQuery(delete);
		query.executeUpdate();
		
	//	TypedQuery<Test> tq=em.createQuery(cd);
	//	Query query=em.createQuery(cd);
	//	int rowCount = query.executeUpdate();
		
		
		
		em.getTransaction().commit();

	}

	private static void delete() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Jpa3");
		EntityManager em = emf.createEntityManager();
		Test t = new Test();
		try {
			em.getTransaction().begin();
			Test userx = em.find(Test.class, 4);
			em.remove(userx);
			em.getTransaction().commit();
		} finally {
			em.close();

		}

	}

	private static void insert() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Jpa3");
		EntityManager em = emf.createEntityManager();
		Test t = new Test();
		t.setId(6);
		t.setName("patrick");
		System.out.println("inside");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(t);

		tx.commit();

	}

	private static void update() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Jpa3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		Test t = em.find(Test.class, 1);
		em.getTransaction().begin();
		t.setName("babak");

		em.getTransaction().commit();

		// CriteriaQuery<Test>qc=cb.createQuery(Test.class);
		// Test test=new Test();
		// test.setName("gov");
		// qc.where(cb.qbe(qc.from(Test.class), test);
		// tx.begin();
		//
		// // String qu="UPDATE test SET name = 'john' WHERE id =2";
		//
		// Query q = em.createQuery("UPDATE test SET name = 'john'+"
		// + " WHERE id =2");
		// CriteriaUpdate<Test> q1 = cb.createCriteriaUpdate(Test.class);
		// int update= q.executeUpdate();
		// //
		// tx.commit();

		// Updates the salary to 90,000 of all Employee's making more than
		// 100,000.
		// CriteriaUpdate update = cb.createCriteriaUpdate(Test.class);
		// Root e = update.from(Employee.class);
		// update.set("salary", 90000);
		// update.where(cb.greaterThan(e.get("salary"), 100000));
		// Query query = em.createQuery(update);
		// int rowCount = query.executeUpdate();
		//
		// // Gives all Employees a 10% raise.
		// CriteriaUpdate update = cb.createCriteriaUpdate(Employee.class);
		// Root e = update.from(Employee.class);
		// update.set(e.get("salary"), cb.sum(e.get("salary"),
		// cb.quot(e.get("salary"), 10));
		// Query query = em.createQuery(update);
		// int rowCount = query.executeUpdate();
	}

	private static void read() {
		// TODO Auto-generated method stub
		System.out.print("\n system propert file is "+System.getProperty("user.home"));
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Jpa3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Test> cq = cb.createQuery(Test.class);
		Root<Test> t2 = cq.from(Test.class);
		cq.select(t2);

		ParameterExpression<Integer> p = cb.parameter(Integer.class);
		
	//	cq.where(((CriteriaBuilder) cb.equal(t2.get("id"), 8)).and(cb.equal(t2.get("name"), "babak")) );
		 Predicate pre1=cb.equal(t2.get("id"),8);
		 Predicate pre2=cb.equal(t2.get("name"),"babak");
		 
		 cq.where(cb.and(pre1,pre2));
		
		//cq.where(cb.equal(t2.get("id"), 8));
		TypedQuery<Test> q = em.createQuery(cq);
		List<Test> allPets = null;
		try {
			allPets = q.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
		} finally {
			em.close();
		}
		// Iterator<Test> it=allPets.iterator();
		// while(it.hasNext()){
		// System.out.println("\n the result is"+it.next());
		// }
		for (Test si : allPets) {
			System.out.println("\n ****@@   read " + si.getId());
			System.out.println("\n **** @@  read " + si.getName());
		}

	}

}
