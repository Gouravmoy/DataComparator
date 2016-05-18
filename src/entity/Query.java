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
public class Query {
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

}
