package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.OrderNote;

/**
 * DAO for OrderNote
 */
@Stateless
public class OrderNoteDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(OrderNote entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		OrderNote entity = em.find(OrderNote.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public OrderNote findById(Long id) {
		return em.find(OrderNote.class, id);
	}

	public OrderNote update(OrderNote entity) {
		return em.merge(entity);
	}

	public List<OrderNote> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<OrderNote> findAllQuery = em.createQuery(
				"SELECT DISTINCT o FROM OrderNote o ORDER BY o.orderNoteId",
				OrderNote.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
