package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.DeliveryType;

/**
 * DAO for DeliveryType
 */
@Stateless
public class DeliveryTypeDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(DeliveryType entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		DeliveryType entity = em.find(DeliveryType.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public DeliveryType findById(Long id) {
		return em.find(DeliveryType.class, id);
	}

	public DeliveryType update(DeliveryType entity) {
		return em.merge(entity);
	}

	public List<DeliveryType> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<DeliveryType> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT d FROM DeliveryType d ORDER BY d.deliveryTypeId",
						DeliveryType.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
