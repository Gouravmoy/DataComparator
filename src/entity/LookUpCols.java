package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
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

}
