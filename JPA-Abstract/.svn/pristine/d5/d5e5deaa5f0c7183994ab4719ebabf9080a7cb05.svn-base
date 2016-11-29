package com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		read();

	}

	private static void read() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Jp_Test");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
		Root<UserEntity> t2 = cq.from(UserEntity.class);
		cq.select(t2);
		TypedQuery<UserEntity> q = em.createQuery(cq);
		List<UserEntity> ue = null;
		try {
			ue = q.getResultList();
		} catch (RuntimeException e) {
			tx.rollback();
		} finally {
			em.close();
		}
		for (UserEntity i : ue) {
			System.out.println("\n ****" + i.getName());

		}

	}

}
