package com.com.DBPartioning.testme;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the "Tenant_One_picklist_value" database table.
 * 
 */
@Entity
@Table(name = "values")
@NamedQuery(name = "values.findAll", query = "SELECT t FROM Values t")
public class Values implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ValuesPK id;
	@Column(name = "picklistid")
	private Integer picklistid;
	private String value;
	@Column(name = "displayorder")
	private Integer displayorder;
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "picklistid", insertable = false, updatable = false),
			@JoinColumn(name = "scopeid", insertable = false, updatable = false) })
	@JsonIgnore
	private Definition definition;

	public Values() {
	}

	public ValuesPK getId() {
		return this.id;
	}

	public void setId(ValuesPK id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getPicklistid() {
		return picklistid;
	}

	public void setPicklistid(Integer picklistid) {
		this.picklistid = picklistid;
	}

	public Integer getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}