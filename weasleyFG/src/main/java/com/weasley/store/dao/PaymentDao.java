package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.Payment;

/**
 * DAO for Payment
 */
@Stateless
public class PaymentDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(Payment entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Payment entity = em.find(Payment.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Payment findById(Long id) {
		return em.find(Payment.class, id);
	}

	public Payment update(Payment entity) {
		return em.merge(entity);
	}

	public List<Payment> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Payment> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Payment p ORDER BY p.paymentId",
				Payment.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
