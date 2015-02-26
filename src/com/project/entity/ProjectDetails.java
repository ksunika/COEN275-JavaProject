/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ksusha
 */
@Entity
@Table(name = "ProjectDetails")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ProjectDetails.findAll", query = "SELECT p FROM ProjectDetails p"),
//    @NamedQuery(name = "ProjectDetails.findByProjectId", query = "SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId"),
//    @NamedQuery(name = "ProjectDetails.findByProjectName", query = "SELECT p FROM ProjectDetails p WHERE p.projectName = :projectName"),
//    @NamedQuery(name = "ProjectDetails.findByStatus", query = "SELECT p FROM ProjectDetails p WHERE p.status = :status"),
//    @NamedQuery(name = "ProjectDetails.findByTheme", query = "SELECT p FROM ProjectDetails p WHERE p.theme = :theme"),
//    @NamedQuery(name = "ProjectDetails.findByScope", query = "SELECT p FROM ProjectDetails p WHERE p.scope = :scope"),
//    @NamedQuery(name = "ProjectDetails.findByStartDate", query = "SELECT p FROM ProjectDetails p WHERE p.startDate = :startDate"),
//    @NamedQuery(name = "ProjectDetails.findByEndDate", query = "SELECT p FROM ProjectDetails p WHERE p.endDate = :endDate"),
//    @NamedQuery(name = "ProjectDetails.findByLocation", query = "SELECT p FROM ProjectDetails p WHERE p.location = :location")})
public class ProjectDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "project_id")
    private String projectId;
    @Basic(optional = false)
    @Column(name = "project_name")
    private String projectName;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "theme")
    private String theme;
    @Column(name = "scope")
    private String scope;
    @Basic(optional = false)
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "location")
    private String location;
    @JoinTable(name = "proj_faculty", joinColumns = {
        @JoinColumn(name = "project_id", referencedColumnName = "project_id")}, inverseJoinColumns = {
        @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Faculty> facultyList;
    @JoinTable(name = "proj_student", joinColumns = {
        @JoinColumn(name = "project_id", referencedColumnName = "project_id")}, inverseJoinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "student_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> studentList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.EAGER)
    private List<Hyperlink> hyperlinkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.EAGER)
    private List<Partner> partnerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.EAGER)
    private List<Media> mediaList;

    public ProjectDetails() {
    }

    public ProjectDetails(String projectId) {
        this.projectId = projectId;
    }

    public ProjectDetails(String projectId, String projectName, String status, String startDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.status = status;
        this.startDate = startDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }



    @XmlTransient
    public List<Hyperlink> getHyperlinkList() {
        return hyperlinkList;
    }

    public void setHyperlinkList(List<Hyperlink> hyperlinkList) {
        this.hyperlinkList = hyperlinkList;
    }

    @XmlTransient
    public List<Partner> getPartnerList() {
        return partnerList;
    }

    public void setPartnerList(List<Partner> partnerList) {
        this.partnerList = partnerList;
    }

    @XmlTransient
    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetails)) {
            return false;
        }
        ProjectDetails other = (ProjectDetails) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "ProjectDetails[ projectId=" + projectId + " ]";
    }

	public int getNumberOfColumns() {
		// TODO Auto-generated method stub
		return 8;
	}

	public Object getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getProjectId();
		   else if (i == 1)
			   return getProjectName();
		   else if (i == 2) 
			   return getStatus();
		   else if (i == 3) 
			   return getTheme();
		   else if (i == 4) 
			   return getScope();
		   else if (i == 5) 
			   return getStartDate();
		   else if (i == 6) 
			   return getEndDate();
		   else if (i == 7) 
			   return getLocation();
		   else
			   throw new Exception("Error: invalid column index in courselist table");
	}

	public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "project_id";
		   else if (i == 1)
			   colName = "project_name";
		   else if (i == 2)
			   colName = "status";
		   else if (i == 3)
			   colName = "theme";
		   else if (i == 4)
			   colName = "scope";
		   else if (i == 5)
			   colName = "start_date";
		   else if (i == 6)
			   colName = "end_date";
		   else if (i == 7)
			   colName = "location";
		   else 
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	}

	public void setColumnData(int i, Object value) throws Exception {
		   if (i == 1) 
			   projectName = (String) value;
		   else if (i == 2) 
			   status = (String) value;
		   else if (i == 3) 
			   theme =  (String) value;
		   else if (i == 4)
			   scope = (String) value;
		   else if (i == 5)
			  startDate = (String) value;
		   else if (i == 6)
			   endDate= (String) value;
		   else if (i == 7)
				location = (String) value;
		   else
			   throw new Exception("Error: invalid column index in courselist table");  
		
	}


    
}
