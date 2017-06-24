package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.ShoppingCart;

/**
 * DAO for ShoppingCart
 */
@Stateless
public class ShoppingCartDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(ShoppingCart entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		ShoppingCart entity = em.find(ShoppingCart.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ShoppingCart findById(Long id) {
		return em.find(ShoppingCart.class, id);
	}

	public ShoppingCart update(ShoppingCart entity) {
		return em.merge(entity);
	}

	public List<ShoppingCart> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<ShoppingCart> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM ShoppingCart s ORDER BY s.shoppingCartId",
						ShoppingCart.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
