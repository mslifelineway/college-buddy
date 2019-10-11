package com.codinghub.collegebuddy.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity(name = "user_connections")
//@Table(name = "user_connections")
public class UserConnection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "connection_id")
	private Long id;

	@Column(name = "role")
	private Integer role; /// following or followed_by

	@Column(name = "status")
	private Integer status; /// Accepted, Rejected Pending , if rejected then deleted this connection from
							/// database

	@Column(name = "is_blocked")
	private boolean isBlocked; //// 0 ==> unblocked, 1=> blocked

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "connected_on")
	private Date connectedOn;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@Column(name = "current_user_id")
//	private Collection<User> currentUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Date getConnectedOn() {
		return connectedOn;
	}

	public void setConnectedOn(Date connectedOn) {
		this.connectedOn = connectedOn;
	}

//	public Collection<User> getCurrentUser() {
//		return currentUser;
//	}
//
//	public void setCurrentUser(Collection<User> currentUser) {
//		this.currentUser = currentUser;
//	}

	@Override
	public String toString() {
		return "UserConnection [id=" + id + ", role=" + role + ", status=" + status + ", isBlocked=" + isBlocked
				+ ", connectedOn=" + connectedOn + "]";
	}

}
