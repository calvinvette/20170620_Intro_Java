package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.EmailAddress;

/**
 * DAO for EmailAddress
 */
@Stateless
public class EmailAddressDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(EmailAddress entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		EmailAddress entity = em.find(EmailAddress.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public EmailAddress findById(Long id) {
		return em.find(EmailAddress.class, id);
	}

	public EmailAddress update(EmailAddress entity) {
		return em.merge(entity);
	}

	public List<EmailAddress> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<EmailAddress> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM EmailAddress e ORDER BY e.emailAddressId",
						EmailAddress.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
