package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.PaypalPayment;

/**
 * DAO for PaypalPayment
 */
@Stateless
public class PaypalPaymentDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(PaypalPayment entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		PaypalPayment entity = em.find(PaypalPayment.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public PaypalPayment findById(Long id) {
		return em.find(PaypalPayment.class, id);
	}

	public PaypalPayment update(PaypalPayment entity) {
		return em.merge(entity);
	}

	public List<PaypalPayment> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<PaypalPayment> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM PaypalPayment p ORDER BY p.paypalPaymentId",
						PaypalPayment.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
