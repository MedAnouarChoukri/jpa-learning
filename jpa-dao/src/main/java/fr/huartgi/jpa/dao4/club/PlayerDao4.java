package fr.huartgi.jpa.dao4.club;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import fr.huartgi.jpa.core.dao.club.PlayerDao;
import fr.huartgi.jpa.core.dao.fwk.GenericDao;
import fr.huartgi.jpa.core.domain.club.Club;
import fr.huartgi.jpa.core.domain.club.Player;

@Named
public class PlayerDao4 extends GenericDao<Long, Player> implements PlayerDao {
	
	public PlayerDao4() {
		super(Player.class);
	}

	@Override
	public List<Player> findAll() {
		
		String jpql = "select player "
				+ "from Player player "
				+ "join fetch player.club club "
				+ "join fetch club.stadium ";
		
		TypedQuery<Player> query = entityManager.createQuery(jpql, Player.class);
		return query.getResultList();
		
	}

	@Override
	public List<Player> findByClub(Club club) {
		
		String jpql = "select player from Player player where player.club = :club ";
		
		TypedQuery<Player> query = entityManager.createQuery(jpql, Player.class);
		query.setParameter("club", club);
		return query.getResultList();
		
	}

	@Override
	public List<Player> findByClub(Long id) {
		
		String jpql = "select player from Player player where player.club.id = :id ";
		
		TypedQuery<Player> query = entityManager.createQuery(jpql, Player.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
