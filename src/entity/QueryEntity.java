package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class QueryEntity {
	@Id
	@GeneratedValue
	Long queryId;

	@ManyToOne(fetch = FetchType.LAZY)
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "query")
	Set<LookUpCols> lookUpCols;

	public QueryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueryEntity(ColumnMeta queryColumnMeta, QueryType queryType,
			String paramNames, String mainQuery, Set<LookUpCols> lookUpCols) {
		super();
		this.queryColumnMeta = queryColumnMeta;
		this.queryType = queryType;
		this.paramNames = paramNames;
		this.mainQuery = mainQuery;
		this.lastUpdtTS = new Date();
		this.lookUpCols = lookUpCols;
	}

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

	@Override
	public String toString() {
		return "QueryEntity [queryId=" + queryId + ", queryColumnMeta="
				+ queryColumnMeta + ", queryType=" + queryType
				+ ", paramNames=" + paramNames + ", mainQuery=" + mainQuery
				+ ", lastUpdtTS=" + lastUpdtTS + ", lookUpCols=" + lookUpCols
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastUpdtTS == null) ? 0 : lastUpdtTS.hashCode());
		result = prime * result
				+ ((lookUpCols == null) ? 0 : lookUpCols.hashCode());
		result = prime * result
				+ ((mainQuery == null) ? 0 : mainQuery.hashCode());
		result = prime * result
				+ ((paramNames == null) ? 0 : paramNames.hashCode());
		result = prime * result
				+ ((queryColumnMeta == null) ? 0 : queryColumnMeta.hashCode());
		result = prime * result + ((queryId == null) ? 0 : queryId.hashCode());
		result = prime * result
				+ ((queryType == null) ? 0 : queryType.hashCode());
		return result;
	}

}
