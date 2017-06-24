package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.Orders;

/**
 * DAO for Orders
 */
@Stateless
public class OrdersDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(Orders entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Orders entity = em.find(Orders.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Orders findById(Long id) {
		return em.find(Orders.class, id);
	}

	public Orders update(Orders entity) {
		return em.merge(entity);
	}

	public List<Orders> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Orders> findAllQuery = em.createQuery(
				"SELECT DISTINCT o FROM Orders o ORDER BY o.orderId",
				Orders.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
