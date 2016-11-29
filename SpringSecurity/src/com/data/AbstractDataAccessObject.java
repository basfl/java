package com.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDataAccessObject<T> {

	protected abstract Class<T> getEntityType();

	public List<T> read() {

		EntityManagerFactory emf = Persistence

		.createEntityManagerFactory("SpringSecurity");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<T> cq = cb.createQuery(getEntityType());

		Root<T> t2 = cq.from(getEntityType());

		cq.select(t2);

		TypedQuery<T> q = em.createQuery(cq);

		List<T> ue = null;
		try {

			ue = q.getResultList();
		} catch (RuntimeException e) {

			tx.rollback();

		} finally {

			em.close();

		}

		return ue;

	}

	public void creat(T entity) {
		EntityManagerFactory emf = Persistence

		.createEntityManagerFactory("SpringSecurity");

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

		} catch (RuntimeException e) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) {
				tx.rollback();
				throw e;
			}

		} finally {
			em.close();

		}

	}

	public void update(T entity) {
		EntityManagerFactory emf = Persistence

		.createEntityManagerFactory("SpringSecurity");

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();

		} catch (RuntimeException e) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) {
				tx.rollback();
				throw e;
			}

		} finally {
			em.close();

		}

	}

	public void delete(T entity) {
		EntityManagerFactory emf = Persistence

		.createEntityManagerFactory("SpringSecurity");

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();

		} catch (RuntimeException e) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) {
				tx.rollback();
				throw e;
			}

		} finally {
			em.close();

		}

	}

}
