package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.CreditCardPayment;

/**
 * DAO for CreditCardPayment
 */
@Stateless
public class CreditCardPaymentDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(CreditCardPayment entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		CreditCardPayment entity = em.find(CreditCardPayment.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public CreditCardPayment findById(Long id) {
		return em.find(CreditCardPayment.class, id);
	}

	public CreditCardPayment update(CreditCardPayment entity) {
		return em.merge(entity);
	}

	public List<CreditCardPayment> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<CreditCardPayment> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM CreditCardPayment c ORDER BY c.creditCardPaymentId",
						CreditCardPayment.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
