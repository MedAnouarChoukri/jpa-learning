package fr.huartgi.jpa.league.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.huartgi.jpa.core.domain.league.Season;
import fr.huartgi.jpa.league.dao.SeasonDao;

@Named
@Transactional
public class SeasonService {

	@Inject
	private SeasonDao seasonDao;
	
	public void create(Season season) {
		seasonDao.create(season);
	}
	
}
