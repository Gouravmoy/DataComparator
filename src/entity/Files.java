package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Files {
	@Id
	@GeneratedValue
	Long fileId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idColumnMeta", nullable = false)
	ColumnMeta fileColumnMeta;

	@Enumerated(EnumType.STRING)
	FileTypes fileTypes;

	@Column
	String fileName;

}
