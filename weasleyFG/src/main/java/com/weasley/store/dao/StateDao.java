package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.State;

/**
 * DAO for State
 */
@Stateless
public class StateDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(State entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		State entity = em.find(State.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public State findById(Integer id) {
		return em.find(State.class, id);
	}

	public State update(State entity) {
		return em.merge(entity);
	}

	public List<State> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<State> findAllQuery = em.createQuery(
				"SELECT DISTINCT s FROM State s ORDER BY s.stateId",
				State.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
