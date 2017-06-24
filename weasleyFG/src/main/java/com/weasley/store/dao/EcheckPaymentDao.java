package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.EcheckPayment;

/**
 * DAO for EcheckPayment
 */
@Stateless
public class EcheckPaymentDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(EcheckPayment entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		EcheckPayment entity = em.find(EcheckPayment.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public EcheckPayment findById(Long id) {
		return em.find(EcheckPayment.class, id);
	}

	public EcheckPayment update(EcheckPayment entity) {
		return em.merge(entity);
	}

	public List<EcheckPayment> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<EcheckPayment> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM EcheckPayment e ORDER BY e.echeckPaymentId",
						EcheckPayment.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
