package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.CustomerNote;

/**
 * DAO for CustomerNote
 */
@Stateless
public class CustomerNoteDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(CustomerNote entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		CustomerNote entity = em.find(CustomerNote.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public CustomerNote findById(Long id) {
		return em.find(CustomerNote.class, id);
	}

	public CustomerNote update(CustomerNote entity) {
		return em.merge(entity);
	}

	public List<CustomerNote> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<CustomerNote> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM CustomerNote c ORDER BY c.customerNoteId",
						CustomerNote.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
