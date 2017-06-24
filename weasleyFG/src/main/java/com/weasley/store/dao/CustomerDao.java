package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.Customer;

/**
 * DAO for Customer
 */
@Stateless
public class CustomerDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(Customer entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Customer entity = em.find(Customer.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Customer findById(Long id) {
		return em.find(Customer.class, id);
	}

	public Customer update(Customer entity) {
		return em.merge(entity);
	}

	public List<Customer> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Customer> findAllQuery = em.createQuery(
				"SELECT DISTINCT c FROM Customer c ORDER BY c.customerId",
				Customer.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
