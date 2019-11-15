package fr.huartgi.jpa.dao1.test;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.huartgi.jpa.core.domain.club.Club;
import fr.huartgi.jpa.core.domain.club.Player;
import fr.huartgi.jpa.core.domain.league.Match;
import fr.huartgi.jpa.core.service.club.ClubService;
import fr.huartgi.jpa.core.service.club.CountryService;
import fr.huartgi.jpa.core.service.club.PlayerService;
import fr.huartgi.jpa.core.service.league.MatchService;

/**
 * Test comment 
 * @author Gildas
 *
 */
@Named
public class Tester1 {

	private static final Logger logger = LoggerFactory.getLogger(Tester1.class);
	
	@Inject
	private ClubService clubService;
	@Inject
	private MatchService matchService;
	@Inject
	private PlayerService playerService;
	@Inject
	private CountryService countryService;
//	@Inject
//	private StadiumService stadiumService;
	
	
	public void testQueries() {
		countryService.findByCode("FRA");
		countryService.findByCode("FRA");
		countryService.findByCode("FRA");
		
		logger.debug("Loading clubs");
		List<Club> clubs = clubService.findAll();
		logger.debug(String.format("%d clubs found\n", clubs.size()));
		//displayClubs(clubs);
		
		logger.debug("Loading matchs");
		List<Match> matchs = matchService.findAll();
		logger.debug(String.format("%d matchs found\n", matchs.size()));
		//displayMatchs(matchs);
		
		logger.debug("Loading players");
		List<Player> players = playerService.findAll();
		logger.debug(String.format("%d players found\n", players.size()));
	}
	
	@SuppressWarnings("unused")
	private void displayClubs(List<Club> clubs) {
		for (Club club : clubs) {
			System.out.printf("%-25s %-7s %-100s\n", club.getName(), club.getCountry().getCode(), club.getStadium().getName());
		}
	}
	
	@SuppressWarnings("unused")
	private void displayMatchs(List<Match> matchs) {
		for (Match match : matchs) {
			System.out.printf("%25s %-1d - %-1d %-25s\n", match.getClubHome().getName(), match.getGoalHome(), match.getGoalAway(), match.getClubAway().getName());
		}
	}
	

}
