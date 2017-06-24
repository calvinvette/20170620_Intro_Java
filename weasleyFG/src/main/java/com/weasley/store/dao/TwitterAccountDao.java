package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.TwitterAccount;

/**
 * DAO for TwitterAccount
 */
@Stateless
public class TwitterAccountDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(TwitterAccount entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		TwitterAccount entity = em.find(TwitterAccount.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public TwitterAccount findById(Long id) {
		return em.find(TwitterAccount.class, id);
	}

	public TwitterAccount update(TwitterAccount entity) {
		return em.merge(entity);
	}

	public List<TwitterAccount> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<TwitterAccount> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT t FROM TwitterAccount t ORDER BY t.twitterAccountId",
						TwitterAccount.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
