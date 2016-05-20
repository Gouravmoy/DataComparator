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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class ColumnMeta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long idColumnMeta;

	@Column
	String colNames;

	@Column
	String separator;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date lastUpdtTS;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "queryColumnMeta")
	List<QueryEntity> queryList;

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

	public List<QueryEntity> getQueryList() {
		return queryList;
	}

	public void setQueryList(List<QueryEntity> queryList) {
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

	public ColumnMeta() {
		super();
		this.lastUpdtTS = new Date();
	}

	public ColumnMeta(String colNames, String separator,
			List<QueryEntity> queryList, Set<Files> files, Project project) {
		super();
		this.colNames = colNames;
		this.separator = separator;
		this.lastUpdtTS = new Date();
		this.queryList = queryList;
		this.files = files;
		this.project = project;
	}

	@Override
	public String toString() {
		return "ColumnMeta [idColumnMeta=" + idColumnMeta + "]";
	}

}
