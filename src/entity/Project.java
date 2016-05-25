package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Project.finadAll", query = "SELECT p FROM Project p")
@Table
public class Project {
	@Id
	@GeneratedValue
	Long projectId;

	@Column
	String projectName;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
	ColumnMeta columnMeta;

	@Column
	Long source;

	@Column
	Long target;

	@Column
	Long sourceLookup;

	@Column
	Long targetLookup;

	@Enumerated(EnumType.STRING)
	ProjectType projectType;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ColumnMeta getColumnMeta() {
		return columnMeta;
	}

	public void setColumnMeta(ColumnMeta columnMeta) {
		this.columnMeta = columnMeta;
	}

	public Long getSource() {
		return source;
	}

	public void setSource(Long source) {
		this.source = source;
	}

	public Long getTarget() {
		return target;
	}

	public void setTarget(Long target) {
		this.target = target;
	}

	public Long getSourceLookup() {
		return sourceLookup;
	}

	public void setSourceLookup(Long sourceLookup) {
		this.sourceLookup = sourceLookup;
	}

	public Long getTargetLookup() {
		return targetLookup;
	}

	public void setTargetLookup(Long targetLookup) {
		this.targetLookup = targetLookup;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectName, ColumnMeta columnMeta, Long source,
			Long target, Long sourceLookup, Long targetLookup,
			ProjectType projectType) {
		super();
		this.projectName = projectName;
		this.columnMeta = columnMeta;
		this.source = source;
		this.target = target;
		this.sourceLookup = sourceLookup;
		this.targetLookup = targetLookup;
		this.projectType = projectType;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", columnMeta=" + columnMeta + ", source="
				+ source + ", target=" + target + ", sourceLookup="
				+ sourceLookup + ", targetLookup=" + targetLookup
				+ ", projectType=" + projectType + "]";
	}

}
