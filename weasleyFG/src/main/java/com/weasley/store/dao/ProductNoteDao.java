package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.ProductNote;

/**
 * DAO for ProductNote
 */
@Stateless
public class ProductNoteDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(ProductNote entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		ProductNote entity = em.find(ProductNote.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ProductNote findById(Long id) {
		return em.find(ProductNote.class, id);
	}

	public ProductNote update(ProductNote entity) {
		return em.merge(entity);
	}

	public List<ProductNote> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<ProductNote> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM ProductNote p ORDER BY p.productNoteId",
						ProductNote.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
