package com.weasley.store.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import com.weasley.store.model.LinkedInAccount;

/**
 * 
 */
@Stateless
@Path("/linkedinaccounts")
public class LinkedInAccountEndpoint {
	@PersistenceContext(unitName = "weasleyFG-persistence-unit")
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(LinkedInAccount entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(LinkedInAccountEndpoint.class)
						.path(String.valueOf(entity.getLinkedInAccountId()))
						.build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		LinkedInAccount entity = em.find(LinkedInAccount.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Long id) {
		TypedQuery<LinkedInAccount> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT l FROM LinkedInAccount l WHERE l.linkedInAccountId = :entityId ORDER BY l.linkedInAccountId",
						LinkedInAccount.class);
		findByIdQuery.setParameter("entityId", id);
		LinkedInAccount entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/json")
	public List<LinkedInAccount> listAll(
			@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
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
		final List<LinkedInAccount> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, LinkedInAccount entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getLinkedInAccountId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(LinkedInAccount.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
