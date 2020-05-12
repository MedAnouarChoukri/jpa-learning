package fr.huartgi.jpa.dao1.club;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import fr.huartgi.jpa.core.dao.club.ClubDao;
import fr.huartgi.jpa.core.dao.fwk.GenericDao;
import fr.huartgi.jpa.core.domain.club.Club;

@Named
public class ClubDao1 extends GenericDao<Long, Club> implements ClubDao {
	
	public ClubDao1() {
		super(Club.class);
	}

	public List<Club> findAll() {
		
		String jpql = "select club from Club club ";
		
		TypedQuery<Club> query = entityManager.createQuery(jpql, Club.class);
		return query.getResultList();
		
	}

}
