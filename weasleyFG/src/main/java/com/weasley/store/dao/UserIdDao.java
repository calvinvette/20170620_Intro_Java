package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.UserId;

/**
 * DAO for UserId
 */
@Stateless
public class UserIdDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(UserId entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		UserId entity = em.find(UserId.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public UserId findById(Long id) {
		return em.find(UserId.class, id);
	}

	public UserId update(UserId entity) {
		return em.merge(entity);
	}

	public List<UserId> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<UserId> findAllQuery = em.createQuery(
				"SELECT DISTINCT u FROM UserId u ORDER BY u.userId",
				UserId.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
