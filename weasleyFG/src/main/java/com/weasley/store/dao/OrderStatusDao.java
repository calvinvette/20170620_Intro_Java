package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.OrderStatus;

/**
 * DAO for OrderStatus
 */
@Stateless
public class OrderStatusDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(OrderStatus entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		OrderStatus entity = em.find(OrderStatus.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public OrderStatus findById(Long id) {
		return em.find(OrderStatus.class, id);
	}

	public OrderStatus update(OrderStatus entity) {
		return em.merge(entity);
	}

	public List<OrderStatus> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<OrderStatus> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT o FROM OrderStatus o ORDER BY o.orderStatusId",
						OrderStatus.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
