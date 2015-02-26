/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.entity;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Priya
 */
@Entity
@Table(name = "partner")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p"),
		@NamedQuery(name = "Partner.findByPartnerName", query = "SELECT p FROM Partner p WHERE p.partnerName = :partnerName") })
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "partnerName")
	private String partnerName;
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ProjectDetails projectId;

	public Partner() {
	}

	public Partner(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public ProjectDetails getProjectId() {
		return projectId;
	}

	public void setProjectId(ProjectDetails projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (partnerName != null ? partnerName.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Partner)) {
			return false;
		}
		Partner other = (Partner) object;
		if ((this.partnerName == null && other.partnerName != null)
				|| (this.partnerName != null && !this.partnerName
						.equals(other.partnerName))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Partner[ partnerName=" + partnerName + " ]";
	}

	public int getNumberOfColumns() {
		return 2;
	}

	public Object getColumnData(int i) throws Exception {
		if (i == 0)
			return getPartnerName();
		else if (i == 1)
			return getProjectId();
		else
			throw new Exception(
					"Error: invalid column index in courselist table");
	}

	public String getColumnName(int i) throws Exception {
		String colName = null;
		if (i == 0)
			colName = "partnerName";
		else if (i == 1)
			colName = "project_id";
		else
			throw new Exception(
					"Access to invalid column number in courselist table");

		return colName;
	}

	public void setColumnData(int i, Object value) throws Exception {
		if (i == 0)
			partnerName = (String) value;
		else
			throw new Exception(
					"Error: invalid column index in courselist table");

	}

}

// import java.io.Serializable;
//
// import javax.persistence.Basic;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.NamedQueries;
// import javax.persistence.NamedQuery;
// import javax.persistence.Table;
// import javax.xml.bind.annotation.XmlRootElement;
//
// /**
// *
// * @author ksusha
// */
// @Entity
// @Table(name = "partner")
// @XmlRootElement
// @NamedQueries({
// @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p"),
// @NamedQuery(name = "Partner.findByPartnerId", query =
// "SELECT p FROM Partner p WHERE p.partnerId = :partnerId"),
// @NamedQuery(name = "Partner.findByPartnerName", query =
// "SELECT p FROM Partner p WHERE p.partnerName = :partnerName")})
// public class Partner implements Serializable {
// private static final long serialVersionUID = 1L;
// @Id
// @Basic(optional = false)
// @Column(name = "partner_id")
// private String partnerId;
// @Basic(optional = false)
// @Column(name = "partnerName")
// private String partnerName;
// @JoinColumn(name = "project_id", referencedColumnName = "project_id")
// @ManyToOne(optional = false, fetch = FetchType.LAZY)
// private ProjectDetails projectId;
//
// public Partner() {
// }
//
// public Partner(String partnerId) {
// this.partnerId = partnerId;
// }
//
// public Partner(String partnerId, String partnerName) {
// this.partnerId = partnerId;
// this.partnerName = partnerName;
// }
//
// public String getPartnerId() {
// return partnerId;
// }
//
// public void setPartnerId(String partnerId) {
// this.partnerId = partnerId;
// }
//
// public String getPartnerName() {
// return partnerName;
// }
//
// public void setPartnerName(String partnerName) {
// this.partnerName = partnerName;
// }
//
// public ProjectDetails getProjectId() {
// return projectId;
// }
//
// public void setProjectId(ProjectDetails projectId) {
// this.projectId = projectId;
// }
//
// @Override
// public int hashCode() {
// int hash = 0;
// hash += (partnerId != null ? partnerId.hashCode() : 0);
// return hash;
// }
//
// @Override
// public boolean equals(Object object) {
// // TODO: Warning - this method won't work in the case the id fields are not
// set
// if (!(object instanceof Partner)) {
// return false;
// }
// Partner other = (Partner) object;
// if ((this.partnerId == null && other.partnerId != null) || (this.partnerId !=
// null && !this.partnerId.equals(other.partnerId))) {
// return false;
// }
// return true;
// }
//
// @Override
// public String toString() {
// return "entites.Partner[ partnerId=" + partnerId + " ]";
// }
//
// public int getNumberOfColumns() {
// return 3;
// }
//
// public Object getColumnData(int i) throws Exception {
// if (i == 0)
// return getPartnerId();
// else if (i == 1)
// return getPartnerName();
// else if (i == 2)
// return getProjectId();
// else
// throw new Exception("Error: invalid column index in courselist table");
// }
//
// public String getColumnName(int i) throws Exception {
// String colName = null;
// if (i == 0)
// colName = "partner_id";
// else if (i == 1)
// colName = "partnerName";
// else if (i == 2)
// colName = "project_id";
// else
// throw new Exception("Access to invalid column number in courselist table");
//
// return colName;
// }
//
//
// public void setColumnData(int i, Object value) throws Exception {
// if (i == 1)
// partnerName = (String) value;
// else
// throw new Exception("Error: invalid column index in courselist table");
//
// }
//
// }
