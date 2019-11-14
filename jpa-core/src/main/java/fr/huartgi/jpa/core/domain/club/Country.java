package fr.huartgi.jpa.core.domain.club;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name="COUNTRY")
@Cacheable
//@Cache(region = "countryCache", usage = CacheConcurrencyStrategy.READ_ONLY)
public class Country {
	
	// ========== ATTRIBUTES ==========
	
	@Id
	@Column(name="ID", unique=true, nullable=false)
	@GeneratedValue
	private Long id;
	
	@Column(name="CODE", length=3)
	private String code;
	
	@Column(name="NAME", length=50)
	private String name;
	
	// ========== CONSTRUCTORS ==========
	
	public Country() {
	}
	
	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	// ========== Object ==========
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE);
		builder.append("code", code);
		builder.append("name", name);
		return builder.toString();
	}	
	
	// ========== GETTERS & SETTERS ==========

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
