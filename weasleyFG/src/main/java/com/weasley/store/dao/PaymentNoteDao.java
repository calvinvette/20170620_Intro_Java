package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.PaymentNote;

/**
 * DAO for PaymentNote
 */
@Stateless
public class PaymentNoteDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(PaymentNote entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		PaymentNote entity = em.find(PaymentNote.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public PaymentNote findById(Long id) {
		return em.find(PaymentNote.class, id);
	}

	public PaymentNote update(PaymentNote entity) {
		return em.merge(entity);
	}

	public List<PaymentNote> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<PaymentNote> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM PaymentNote p ORDER BY p.paymentNoteId",
						PaymentNote.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
