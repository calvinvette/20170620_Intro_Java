package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.FacebookAssociations;

/**
 * DAO for FacebookAssociations
 */
@Stateless
public class FacebookAssociationsDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(FacebookAssociations entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		FacebookAssociations entity = em.find(FacebookAssociations.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public FacebookAssociations findById(Long id) {
		return em.find(FacebookAssociations.class, id);
	}

	public FacebookAssociations update(FacebookAssociations entity) {
		return em.merge(entity);
	}

	public List<FacebookAssociations> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<FacebookAssociations> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT f FROM FacebookAssociations f ORDER BY f.associationId",
						FacebookAssociations.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
