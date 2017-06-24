package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.BankAccount;

/**
 * DAO for BankAccount
 */
@Stateless
public class BankAccountDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(BankAccount entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		BankAccount entity = em.find(BankAccount.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public BankAccount findById(Long id) {
		return em.find(BankAccount.class, id);
	}

	public BankAccount update(BankAccount entity) {
		return em.merge(entity);
	}

	public List<BankAccount> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<BankAccount> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT b FROM BankAccount b ORDER BY b.bankAccountId",
						BankAccount.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
