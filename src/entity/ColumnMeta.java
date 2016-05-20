package entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "ColumnMeta.finadAll", query = "SELECT c FROM ColumnMeta c")
@Table
public class ColumnMeta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long idColumnMeta;

	@Column
	String columnMetaName;

	@Column
	String colNames;

	@Column
	String separator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date lastUpdtTS;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "queryColumnMeta")
	List<Query> queryList;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "fileColumnMeta")
	Set<Files> files;

	@OneToOne
	@PrimaryKeyJoinColumn
	Project project;

	public Long getIdColumnMeta() {
		return idColumnMeta;
	}

	public void setIdColumnMeta(Long idColumnMeta) {
		this.idColumnMeta = idColumnMeta;
	}

	public String getColumnMetaName() {
		return columnMetaName;
	}

	public void setColumnMetaName(String columnMetaName) {
		this.columnMetaName = columnMetaName;
	}

	public String getColNames() {
		return colNames;
	}

	public void setColNames(String colNames) {
		this.colNames = colNames;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public Date getLastUpdtTS() {
		return lastUpdtTS;
	}

	public void setLastUpdtTS(Date lastUpdtTS) {
		this.lastUpdtTS = lastUpdtTS;
	}

	public List<Query> getQueryList() {
		return queryList;
	}

	public void setQueryList(List<Query> queryList) {
		this.queryList = queryList;
	}

	public Set<Files> getFiles() {
		return files;
	}

	public void setFiles(Set<Files> files) {
		this.files = files;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ColumnMeta(String columnMetaName, String colNames, String separator) {
		super();
		this.columnMetaName = columnMetaName;
		this.colNames = colNames;
		this.separator = separator;
		this.lastUpdtTS = new Date();
	}

	public ColumnMeta() {
		super();
	}

	@Override
	public String toString() {
		return "ColumnMeta [idColumnMeta=" + idColumnMeta + ", columnMetaName="
				+ columnMetaName + ", colNames=" + colNames + ", separator="
				+ separator + ", lastUpdtTS=" + lastUpdtTS + ", queryList="
				+ queryList + ", files=" + files + ", project=" + project + "]";
	}

}
