/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Priya
 */
@Entity
@Table(name = "faculty")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
		@NamedQuery(name = "Faculty.findByFacultyId", query = "SELECT f FROM Faculty f WHERE f.facultyId = :facultyId"),
		@NamedQuery(name = "Faculty.findByName", query = "SELECT f FROM Faculty f WHERE f.name = :name") })
public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "faculty_id")
	private String facultyId;
	@Basic(optional = false)
	@Column(name = "name")
	private String name;
	@ManyToMany(mappedBy = "facultyList", fetch = FetchType.EAGER)
	private List<ProjectDetails> ProjectDetailsList;

	public Faculty() {
	}

	public Faculty(String facultyId) {
		this.facultyId = facultyId;
	}

	public Faculty(String facultyId, String name) {
		this.facultyId = facultyId;
		this.name = name;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public List<ProjectDetails> getProjectDetailsList() {
		return ProjectDetailsList;
	}

	public void setProjectDetailsList(List<ProjectDetails> ProjectDetailsList) {
		this.ProjectDetailsList = ProjectDetailsList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (facultyId != null ? facultyId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Faculty)) {
			return false;
		}
		Faculty other = (Faculty) object;
		if ((this.facultyId == null && other.facultyId != null)
				|| (this.facultyId != null && !this.facultyId
						.equals(other.facultyId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Faculty[ facultyId=" + facultyId + " ]";
	}

	public int getNumberOfColumns() {
		return 3;
	}

	public Object getColumnData(int i) throws Exception {
		if (i == 0)
			return getFacultyId();
		else if (i == 1)
			return getName();
		else
			throw new Exception(
					"Error: invalid column index in courselist table");
	}

	public String getColumnName(int i) throws Exception {
		String colName = null;
		if (i == 0)
			colName = "faculty_id";
		else if (i == 1)
			colName = "name";
		else if (i == 2)
			colName = "project_id";
		else
			throw new Exception(
					"Access to invalid column number in courselist table");

		return colName;
	}

}

// /*
// * To change this license header, choose License Headers in Project
// Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
// package com.project.entity;
//
// import java.io.Serializable;
//
// import javax.persistence.Basic;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;
//
// /**
// *
// * @author ksusha
// */
// @Entity
// @Table(name = "faculty")
// //@XmlRootElement
// //@NamedQueries({
// // @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
// // @NamedQuery(name = "Faculty.findByFacultyId", query =
// "SELECT f FROM Faculty f WHERE f.facultyId = :facultyId"),
// // @NamedQuery(name = "Faculty.findByName", query =
// "SELECT f FROM Faculty f WHERE f.name = :name")})
// public class Faculty implements Serializable {
// private static final long serialVersionUID = 1L;
// @Id
// @Basic(optional = false)
// @Column(name = "faculty_id")
// private String facultyId;
// @Basic(optional = false)
// @Column(name = "name")
// private String name;
// @JoinColumn(name = "project_id", referencedColumnName = "project_id")
// @ManyToOne(optional = false, fetch = FetchType.LAZY)
// private ProjectDetails projectId;
//
// public Faculty() {
// }
//
// public Faculty(String facultyId) {
// this.facultyId = facultyId;
// }
//
// public Faculty(String facultyId, String name) {
// this.facultyId = facultyId;
// this.name = name;
// }
//
// public String getFacultyId() {
// return facultyId;
// }
//
// public void setFacultyId(String facultyId) {
// this.facultyId = facultyId;
// }
//
// public String getName() {
// return name;
// }
//
// public void setName(String name) {
// this.name = name;
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
// hash += (facultyId != null ? facultyId.hashCode() : 0);
// return hash;
// }
//
// @Override
// public boolean equals(Object object) {
// // TODO: Warning - this method won't work in the case the id fields are not
// set
// if (!(object instanceof Faculty)) {
// return false;
// }
// Faculty other = (Faculty) object;
// if ((this.facultyId == null && other.facultyId != null) || (this.facultyId !=
// null && !this.facultyId.equals(other.facultyId))) {
// return false;
// }
// return true;
// }
//
// @Override
// public String toString() {
// return "entites.Faculty[ facultyId=" + facultyId + " ]";
// }
//
// public int getNumberOfColumns() {
// return 3;
// }
//
// public Object getColumnData(int i) throws Exception {
// if (i == 0)
// return getFacultyId();
// else if (i == 1)
// return getName();
// else if (i == 2)
// return getProjectId();
// else
// throw new Exception("Error: invalid column index in courselist table");
// }
//
// public String getColumnName(int i) throws Exception {
// String colName = null;
// if (i == 0)
// colName = "faculty_id";
// else if (i == 1)
// colName = "name";
// else if (i == 2)
// colName = "project_id";
// else
// throw new Exception("Access to invalid column number in courselist table");
//
// return colName;
// }
//
// }
