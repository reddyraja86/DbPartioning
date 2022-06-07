package com.com.DBPartioning.testme;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.com.DBPartioning.hibernate.StringArrayUserType;

@Entity
@Table(name = "definition")
public class Definition implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DefinitionPK id;
	private String name;

	@Type(type = StringArrayUserType.NAME)
	@Column(name = "applicableattributes", columnDefinition = "text[]")
	private String[] applicableattributes;

	private String scope;
	private Boolean active;

	@Type(type = StringArrayUserType.NAME)
	@Column(name = "applications", columnDefinition = "text[]")
	private String[] applications;

	@Column(name = "defaultsort")
	private Integer defaultsort;

	@OneToMany(targetEntity = Values.class, mappedBy = "definition")
	private Set<Values> picklistValues;

	

	public Set<Values> getPicklistValues() {
		return picklistValues;
	}

	public void setPicklistValues(Set<Values> picklistValues) {
		this.picklistValues = picklistValues;
	}

	public Definition() {
	}

	public DefinitionPK getId() {
		return this.id;
	}

	public void setId(DefinitionPK id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String[] getApplications() {
		return applications;
	}

	public void setApplications(String[] applications) {
		this.applications = applications;
	}

	public String[] getApplicableattributes() {
		return applicableattributes;
	}

	public void setApplicableattributes(String[] applicableattributes) {
		this.applicableattributes = applicableattributes;
	}

	public Integer getDefaultsort() {
		return defaultsort;
	}

	public void setDefaultsort(Integer defaultsort) {
		this.defaultsort = defaultsort;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}