package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.TwitterAssociations;

/**
 * DAO for TwitterAssociations
 */
@Stateless
public class TwitterAssociationsDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(TwitterAssociations entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		TwitterAssociations entity = em.find(TwitterAssociations.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public TwitterAssociations findById(Long id) {
		return em.find(TwitterAssociations.class, id);
	}

	public TwitterAssociations update(TwitterAssociations entity) {
		return em.merge(entity);
	}

	public List<TwitterAssociations> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<TwitterAssociations> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT t FROM TwitterAssociations t ORDER BY t.associationId",
						TwitterAssociations.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
