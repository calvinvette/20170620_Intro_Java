package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.CreditCard;

/**
 * DAO for CreditCard
 */
@Stateless
public class CreditCardDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(CreditCard entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		CreditCard entity = em.find(CreditCard.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public CreditCard findById(Long id) {
		return em.find(CreditCard.class, id);
	}

	public CreditCard update(CreditCard entity) {
		return em.merge(entity);
	}

	public List<CreditCard> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<CreditCard> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM CreditCard c ORDER BY c.creditCardId",
				CreditCard.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
