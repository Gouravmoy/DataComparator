package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Database implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	DataBase_CompositeID id;

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

	public DataBase_CompositeID getId() {
		return id;
	}

	public void setId(DataBase_CompositeID id) {
		this.id = id;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public DBTypes getDbType() {
		return dbType;
	}

	public void setDbType(DBTypes dbType) {
		this.dbType = dbType;
	}

	public Date getLastUpdtTS() {
		return lastUpdtTS;
	}

	public void setLastUpdtTS(Date lastUpdtTS) {
		this.lastUpdtTS = lastUpdtTS;
	}

	public Database(DataBase_CompositeID id, String serverName,
			String userName, String password, String portNo, DBTypes dbType) {
		super();
		this.id = id;
		this.serverName = serverName;
		this.userName = userName;
		this.password = password;
		this.portNo = portNo;
		this.dbType = dbType;
		this.lastUpdtTS = new Date();
	}

	public Database() {
		super();
	}

	@Override
	public String toString() {
		return "Database [id=" + id + ", serverName=" + serverName
				+ ", userName=" + userName + ", password=" + password
				+ ", portNo=" + portNo + ", dbType=" + dbType + ", lastUpdtTS="
				+ lastUpdtTS + "]";
	}

}
