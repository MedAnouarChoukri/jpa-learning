package fr.huartgi.jpalearning.test9;

import fr.huartgi.jpalearning.core.common.TechnicalDao;
import fr.huartgi.jpalearning.core.domain.Club;
import fr.huartgi.jpalearning.core.domain.Country;
import fr.huartgi.jpalearning.core.domain.Match;
import fr.huartgi.jpalearning.core.domain.Player;
import fr.huartgi.jpalearning.core.service.ClubService;
import fr.huartgi.jpalearning.core.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Test comment 
 * @author Gildas
 *
 */
@Component
public class Tester9 {

	private static final Logger logger = LoggerFactory.getLogger(Tester9.class);
	
	@Autowired
	private ClubService clubService;
	@Autowired
	private CountryService countryService;

	@Autowired
	private TechnicalDao technicalDao;
	
	/**
	 * Loading the clubs and their sublists in one query will fail.
	 * 
	 */
	public void testQueries() {

		technicalDao.triggerSchemaGeneration();

		logger.debug("\n\n\n");

		logger.debug("1. Loading countries");
		List<Country> countries = countryService.findAll();
		logger.debug(String.format("%d countries found\n", countries.size()));

		logger.debug("\n\n\n");
		
		logger.debug("2. Loading clubs");
		List<Club> clubs = clubService.findAll();
		logger.debug(String.format("%d clubs found\n", clubs.size()));

		logger.debug("\n\n\n");

		displayPlayers(clubs.get(0));

		logger.debug("\n\n\n");

		displayMatchs(clubs.get(0).getMatchesHome());
	}

	public static void displayPlayers(Club club) {
		for (Player player : club.getPlayers()) {
			System.out.printf("%25s (%s) - %-25s\n", player.getName(), player.getCountry().getCode(), player.getClub().getName());
		}
	}

	public static void displayMatchs(List<Match> matchs) {
		for (Match match : matchs) {
			System.out.printf("%25s %-1d - %-1d %-25s\n", match.getClubHome().getName(), match.getGoalHome(), match.getGoalAway(), match.getClubAway().getName());
		}
	}

}
