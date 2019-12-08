package fr.huartgi.jpa.dao6;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;

import fr.huartgi.jpa.core.dao.club.ClubDao;
import fr.huartgi.jpa.core.dao.fwk.GenericDao;
import fr.huartgi.jpa.core.domain.club.Club;

@Named
public class ClubDao6 extends GenericDao<Long, Club> implements ClubDao {
	
	public ClubDao6() {
		super(Club.class);
	}

	@Override
	public List<Club> findAll() {
		
		String jpql = "select club "
				+ "from Club club ";
		
		EntityGraph<Club> graph = entityManager.createEntityGraph(Club.class);
		graph.addAttributeNodes("stadium");

		TypedQuery<Club> query = entityManager.createQuery(jpql, Club.class);
		query.setHint("javax.persistence.fetchgraph", graph);
		List<Club> clubs = null;
		try {
			clubs = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clubs;
	}

}
