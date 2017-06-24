package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.OrderItem;

/**
 * DAO for OrderItem
 */
@Stateless
public class OrderItemDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(OrderItem entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		OrderItem entity = em.find(OrderItem.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public OrderItem findById(Long id) {
		return em.find(OrderItem.class, id);
	}

	public OrderItem update(OrderItem entity) {
		return em.merge(entity);
	}

	public List<OrderItem> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<OrderItem> findAllQuery = em.createQuery(
				"SELECT DISTINCT o FROM OrderItem o ORDER BY o.orderItemId",
				OrderItem.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
