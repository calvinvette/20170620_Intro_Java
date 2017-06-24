package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.ZipCode;

/**
 * DAO for ZipCode
 */
@Stateless
public class ZipCodeDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(ZipCode entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		ZipCode entity = em.find(ZipCode.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ZipCode findById(Long id) {
		return em.find(ZipCode.class, id);
	}

	public ZipCode update(ZipCode entity) {
		return em.merge(entity);
	}

	public List<ZipCode> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<ZipCode> findAllQuery = em.createQuery(
				"SELECT DISTINCT z FROM ZipCode z ORDER BY z.zipCodeId",
				ZipCode.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
