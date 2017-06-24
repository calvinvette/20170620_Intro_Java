package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.FacebookAccount;

/**
 * DAO for FacebookAccount
 */
@Stateless
public class FacebookAccountDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(FacebookAccount entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		FacebookAccount entity = em.find(FacebookAccount.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public FacebookAccount findById(Long id) {
		return em.find(FacebookAccount.class, id);
	}

	public FacebookAccount update(FacebookAccount entity) {
		return em.merge(entity);
	}

	public List<FacebookAccount> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<FacebookAccount> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT f FROM FacebookAccount f ORDER BY f.facebookAccountId",
						FacebookAccount.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
