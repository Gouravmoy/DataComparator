package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Database implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	Long idDatabase;

	@Id
	@Column
	String dbName;

	@Column
	String serverName;

	@Column
	String userName;

	@Column
	String password;

	@Column
	String portNo;

	@Enumerated(EnumType.STRING)
	DBTypes dbType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Date lastUpdtTS;

}
