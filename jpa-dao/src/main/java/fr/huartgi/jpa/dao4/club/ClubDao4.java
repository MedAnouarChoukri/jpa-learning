package fr.huartgi.jpa.dao4.club;

import fr.huartgi.jpa.core.dao.club.ClubDao;
import fr.huartgi.jpa.core.dao.fwk.GenericDao;
import fr.huartgi.jpa.core.domain.club.Club;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
public class ClubDao4 extends GenericDao<Long, Club> implements ClubDao {
	
	public ClubDao4() {
		super(Club.class);
	}

	public List<Club> findAll() {
		
		String jpql = "select club "
				+ "from Club club "
				+ "join fetch club.stadium ";
		
		TypedQuery<Club> query = entityManager.createQuery(jpql, Club.class);
		return query.getResultList();
		
	}

}
