package entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class ColumnMeta {

	@Id
	@GeneratedValue
	Long idColumnMeta;

	@Column
	String colNames;

	@Column
	String separator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date lastUpdtTS;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "queryColumnMeta")
	List<Query> queryList;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "fileColumnMeta")
	List<Files> files;
}
