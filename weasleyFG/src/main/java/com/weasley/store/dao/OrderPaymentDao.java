package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.OrderPayment;

/**
 * DAO for OrderPayment
 */
@Stateless
public class OrderPaymentDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(OrderPayment entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		OrderPayment entity = em.find(OrderPayment.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public OrderPayment findById(Long id) {
		return em.find(OrderPayment.class, id);
	}

	public OrderPayment update(OrderPayment entity) {
		return em.merge(entity);
	}

	public List<OrderPayment> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<OrderPayment> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT o FROM OrderPayment o ORDER BY o.orderPaymentId",
						OrderPayment.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
