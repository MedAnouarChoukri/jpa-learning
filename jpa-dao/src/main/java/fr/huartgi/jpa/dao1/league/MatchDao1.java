package fr.huartgi.jpa.dao1.league;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import fr.huartgi.jpa.core.dao.fwk.GenericDao;
import fr.huartgi.jpa.core.dao.league.MatchDao;
import fr.huartgi.jpa.core.domain.league.Match;

@Named
public class MatchDao1 extends GenericDao<Long, Match> implements MatchDao {
	
	public MatchDao1() {
		super(Match.class);
	}

	public List<Match> findAll() {
		String jpql = "select match from Match match ";
		
		TypedQuery<Match> query = entityManager.createQuery(jpql, Match.class);
		return query.getResultList();
		
	}

}
