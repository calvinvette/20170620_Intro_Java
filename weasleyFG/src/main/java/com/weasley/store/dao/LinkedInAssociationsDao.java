package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.LinkedInAssociations;

/**
 * DAO for LinkedInAssociations
 */
@Stateless
public class LinkedInAssociationsDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(LinkedInAssociations entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		LinkedInAssociations entity = em.find(LinkedInAssociations.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public LinkedInAssociations findById(Long id) {
		return em.find(LinkedInAssociations.class, id);
	}

	public LinkedInAssociations update(LinkedInAssociations entity) {
		return em.merge(entity);
	}

	public List<LinkedInAssociations> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<LinkedInAssociations> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT l FROM LinkedInAssociations l ORDER BY l.associationId",
						LinkedInAssociations.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
