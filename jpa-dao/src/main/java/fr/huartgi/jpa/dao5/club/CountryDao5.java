package fr.huartgi.jpa.dao5.club;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import fr.huartgi.jpa.core.dao.club.CountryDao;
import fr.huartgi.jpa.core.dao.fwk.GenericDao;
import fr.huartgi.jpa.core.domain.club.Country;

@Named
public class CountryDao5 extends GenericDao<Long, Country> implements CountryDao {
	
	public CountryDao5() {
		super(Country.class);
	}

	public List<Country> findAll() {
		
		String jpql = "select country from Country country ";
		
		TypedQuery<Country> query = entityManager.createQuery(jpql, Country.class);
		return query.getResultList();
		
	}

	public Country findByCode(String code) {
		
		String jpql = "select country from Country country where country.code = :code ";
		
		TypedQuery<Country> query = entityManager.createQuery(jpql, Country.class);
		query.setParameter("code", code);
		
		Country result = query.getSingleResult();

		return result;
	}

}
