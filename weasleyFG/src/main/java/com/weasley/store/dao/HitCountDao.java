package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.HitCount;

/**
 * DAO for HitCount
 */
@Stateless
public class HitCountDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(HitCount entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		HitCount entity = em.find(HitCount.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public HitCount findById(Long id) {
		return em.find(HitCount.class, id);
	}

	public HitCount update(HitCount entity) {
		return em.merge(entity);
	}

	public List<HitCount> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<HitCount> findAllQuery = em.createQuery(
				"SELECT DISTINCT h FROM HitCount h ORDER BY h.hitCountId",
				HitCount.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
