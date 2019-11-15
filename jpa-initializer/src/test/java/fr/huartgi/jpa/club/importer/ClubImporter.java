package fr.huartgi.jpa.club.importer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.huartgi.jpa.club.run.DatabaseInitializer;
import fr.huartgi.jpa.core.domain.club.Club;
import fr.huartgi.jpa.core.domain.club.Country;
import fr.huartgi.jpa.core.domain.club.Stadium;
import fr.huartgi.jpa.core.service.club.ClubService;
import fr.huartgi.jpa.core.service.club.StadiumService;

@Named
public class ClubImporter {

	private static final Logger logger = LoggerFactory.getLogger(ClubImporter.class);
	
	private List<Club> frenchClubs = new ArrayList<Club>();
	private List<Club> europeanClubs = new ArrayList<Club>();
	
	@Inject
	private ClubService clubService;
	@Inject
	private StadiumService stadiumService;
	@Inject 
	private CountryImporter countryImporter;
	@Inject
	private PlayerCreater playerCreater;
	
	
	public void importClubs() {
		
		InputStream is = DatabaseInitializer.class.getResourceAsStream("/data/clubs.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(";");
				String clubName = columns[0];
				String countryCode = columns[1];
				String stadiumName = columns[2];
				Integer stadiumCapacity = new Integer(columns[3]);
				Boolean european = StringUtils.equals("Y", columns[4]);
				Club club = createClub(clubName, countryCode, stadiumName, stadiumCapacity); 
			    if (StringUtils.equals("FRA", countryCode))
			    	frenchClubs.add(club);			
			    if (european) 
			    	europeanClubs.add(club);
			}
		} 
        catch (IOException err) {
			logger.error("Impossible to read file data/clubs.txt", err);
		}
	}

	private Club createClub(String name, String countryCode, String stadiumName, Integer stadiumCapacity) {
		Country country = countryImporter.getCountries().get(countryCode);
		Stadium stadium = new Stadium(stadiumName, stadiumCapacity);
		stadiumService.create(stadium);
		Club club = new Club(name, country, stadium);
		clubService.create(club);
		playerCreater.addPlayers(club, 20);
		return club;
	}

	public List<Club> getFrenchClubs() {
		return frenchClubs;
	}

	public List<Club> getEuropeanClubs() {
		return europeanClubs;
	}
}
