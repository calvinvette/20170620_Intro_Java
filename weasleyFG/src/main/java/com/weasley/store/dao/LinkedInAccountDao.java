package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.LinkedInAccount;

/**
 * DAO for LinkedInAccount
 */
@Stateless
public class LinkedInAccountDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(LinkedInAccount entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		LinkedInAccount entity = em.find(LinkedInAccount.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public LinkedInAccount findById(Long id) {
		return em.find(LinkedInAccount.class, id);
	}

	public LinkedInAccount update(LinkedInAccount entity) {
		return em.merge(entity);
	}

	public List<LinkedInAccount> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<LinkedInAccount> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT l FROM LinkedInAccount l ORDER BY l.linkedInAccountId",
						LinkedInAccount.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
