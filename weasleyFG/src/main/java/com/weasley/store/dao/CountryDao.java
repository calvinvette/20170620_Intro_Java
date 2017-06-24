package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.Country;

/**
 * DAO for Country
 */
@Stateless
public class CountryDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(Country entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Country entity = em.find(Country.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Country findById(Long id) {
		return em.find(Country.class, id);
	}

	public Country update(Country entity) {
		return em.merge(entity);
	}

	public List<Country> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Country> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Country c ORDER BY c.countryId",
				Country.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
