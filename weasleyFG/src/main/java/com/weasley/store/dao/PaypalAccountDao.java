package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.PaypalAccount;

/**
 * DAO for PaypalAccount
 */
@Stateless
public class PaypalAccountDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(PaypalAccount entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		PaypalAccount entity = em.find(PaypalAccount.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public PaypalAccount findById(Long id) {
		return em.find(PaypalAccount.class, id);
	}

	public PaypalAccount update(PaypalAccount entity) {
		return em.merge(entity);
	}

	public List<PaypalAccount> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<PaypalAccount> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM PaypalAccount p ORDER BY p.paypalAccountId",
						PaypalAccount.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
