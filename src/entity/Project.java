package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
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
}
