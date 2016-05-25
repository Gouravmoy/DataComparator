package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "QueryEntity.finadAll", query = "SELECT q FROM QueryEntity q")
@Table
public class QueryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long queryId;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "idColumnMeta", nullable = false)
	ColumnMeta queryColumnMeta;

	@Enumerated(EnumType.STRING)
	QueryType queryType;

	@Column
	String paramNames;

	@Column
	String mainQuery;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date lastUpdtTS;

	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER, mappedBy = "query")
	Set<LookUpCols> lookUpCols;

	@Column
	String queryName;

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public ColumnMeta getQueryColumnMeta() {
		return queryColumnMeta;
	}

	public void setQueryColumnMeta(ColumnMeta queryColumnMeta) {
		this.queryColumnMeta = queryColumnMeta;
	}

	public QueryType getQueryType() {
		return queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	public String getParamNames() {
		return paramNames;
	}

	public void setParamNames(String paramNames) {
		this.paramNames = paramNames;
	}

	public String getMainQuery() {
		return mainQuery;
	}

	public void setMainQuery(String mainQuery) {
		this.mainQuery = mainQuery;
	}

	public Date getLastUpdtTS() {
		return lastUpdtTS;
	}

	public void setLastUpdtTS(Date lastUpdtTS) {
		this.lastUpdtTS = lastUpdtTS;
	}

	public Set<LookUpCols> getLookUpCols() {
		return lookUpCols;
	}

	public void setLookUpCols(Set<LookUpCols> lookUpCols) {
		this.lookUpCols = lookUpCols;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public QueryEntity(ColumnMeta queryColumnMeta, QueryType queryType,
			String paramNames, String mainQuery, Set<LookUpCols> lookUpCols,
			String queryName) {
		super();
		this.queryColumnMeta = queryColumnMeta;
		this.queryType = queryType;
		this.paramNames = paramNames;
		this.mainQuery = mainQuery;
		this.lastUpdtTS = new Date();
		this.lookUpCols = lookUpCols;
		this.queryName = queryName;
	}

	public QueryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QueryEntity [queryId=" + queryId + ", queryColumnMeta="
				+ queryColumnMeta + ", queryType=" + queryType
				+ ", paramNames=" + paramNames + ", mainQuery=" + mainQuery
				+ ", lastUpdtTS=" + lastUpdtTS + ", lookUpCols=" + lookUpCols
				+ ", queryName=" + queryName + "]";
	}

}
