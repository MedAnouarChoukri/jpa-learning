package fr.huartgi.jpalearning.test9.dao9;

import fr.huartgi.jpalearning.core.common.GenericDao;
import fr.huartgi.jpalearning.core.dao.CountryDao;
import fr.huartgi.jpalearning.core.domain.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountryDao9 extends GenericDao<Long, Country> implements CountryDao {
	
	public CountryDao9() {
		super(Country.class);
	}

	@Override
	public List<Country> findAll() {
		
		String jpql = "select country from Country country ";
		
		TypedQuery<Country> query = entityManager.createQuery(jpql, Country.class);
		return query.getResultList();
		
	}

	@Override
	public Country findByCode(String code) {
		
		String jpql = "select country from Country country where country.code = :code ";
		
		TypedQuery<Country> query = entityManager.createQuery(jpql, Country.class);
		query.setParameter("code", code);
		
		Country result = query.getSingleResult();

		return result;
	}

}
