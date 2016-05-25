package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "LookUpCols.finadAll", query = "SELECT l FROM LookUpCols l")
@Table
public class LookUpCols {

	@Id
	@GeneratedValue
	Long lookUpId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "queryId", nullable = false)
	QueryEntity query;

	@Column
	String lookUpColName;

	@Column
	String lookUpQuery;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date lastUpdtTS;

	public LookUpCols() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LookUpCols(QueryEntity query, String lookUpColName,
			String lookUpQuery) {
		super();
		this.query = query;
		this.lookUpColName = lookUpColName;
		this.lookUpQuery = lookUpQuery;
		this.lastUpdtTS = new Date();
	}

	public Long getLookUpId() {
		return lookUpId;
	}

	public void setLookUpId(Long lookUpId) {
		this.lookUpId = lookUpId;
	}

	public QueryEntity getQuery() {
		return query;
	}

	public void setQuery(QueryEntity query) {
		this.query = query;
	}

	public String getLookUpColName() {
		return lookUpColName;
	}

	public void setLookUpColName(String lookUpColName) {
		this.lookUpColName = lookUpColName;
	}

	public String getLookUpQuery() {
		return lookUpQuery;
	}

	public void setLookUpQuery(String lookUpQuery) {
		this.lookUpQuery = lookUpQuery;
	}

	public Date getLastUpdtTS() {
		return lastUpdtTS;
	}

	public void setLastUpdtTS(Date lastUpdtTS) {
		this.lastUpdtTS = lastUpdtTS;
	}

}
