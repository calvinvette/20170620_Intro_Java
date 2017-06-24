package com.weasley.store.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.weasley.store.model.Note;

/**
 * DAO for Note
 */
@Stateless
public class NoteDao {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	public void create(Note entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Note entity = em.find(Note.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Note findById(Long id) {
		return em.find(Note.class, id);
	}

	public Note update(Note entity) {
		return em.merge(entity);
	}

	public List<Note> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Note> findAllQuery = em.createQuery(
				"SELECT DISTINCT n FROM Note n ORDER BY n.noteId", Note.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
