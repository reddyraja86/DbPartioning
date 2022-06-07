package com.com.DBPartioning.testme;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the "Tenant_One" database table.
 * 
 */
@Embeddable
public class DefinitionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Column(name="scopeid")
	private String scopeid;

	public DefinitionPK() {
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getScopeid() {
		return scopeid;
	}
	public void setScopeid(String scopeid) {
		this.scopeid = scopeid;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DefinitionPK)) {
			return false;
		}
		DefinitionPK castOther = (DefinitionPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.scopeid.equals(castOther.scopeid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.scopeid.hashCode();
		
		return hash;
	}
}