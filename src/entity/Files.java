package entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Files.finadAll", query = "SELECT f FROM Files f")
@Table
public class Files {
	@Id
	@GeneratedValue
	Long fileId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idColumnMeta", nullable = false)
	ColumnMeta fileColumnMeta;

	@Enumerated(EnumType.STRING)
	FileTypes fileTypes;

	@Column
	String fileName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date lastUpdtTS;

	public Files() {
		super();
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public ColumnMeta getFileColumnMeta() {
		return fileColumnMeta;
	}

	public void setFileColumnMeta(ColumnMeta fileColumnMeta) {
		this.fileColumnMeta = fileColumnMeta;
	}

	public FileTypes getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(FileTypes fileTypes) {
		this.fileTypes = fileTypes;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getLastUpdtTS() {
		return lastUpdtTS;
	}

	public void setLastUpdtTS(Date lastUpdtTS) {
		this.lastUpdtTS = lastUpdtTS;
	}

	public Files(FileTypes fileTypes, String fileName) {
		super();
		this.fileTypes = fileTypes;
		this.fileName = fileName;
		this.lastUpdtTS = new Date();
	}

	@Override
	public String toString() {
		return "Files [fileId=" + fileId + ", fileColumnMeta=" + fileColumnMeta
				+ ", fileTypes=" + fileTypes + ", fileName=" + fileName
				+ ", lastUpdtTS=" + lastUpdtTS + "]";
	}

}
