/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ksusha
 */
@Entity
@Table(name = "student")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
//    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
//    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "student_id")
    private String studentId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "studentList", fetch = FetchType.LAZY)
    private List<ProjectDetails> projectDetailsList;

    public Student() {
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<ProjectDetails> getProjectDetailsList() {
        return projectDetailsList;
    }

    public void setProjectDetailsList(List<ProjectDetails> projectDetailsList) {
        this.projectDetailsList = projectDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Student[ studentId=" + studentId + " ]";
    }

    public int getNumberOfColumns() {
		return 2;
	}

	public Object getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getStudentId();
		   else if (i == 1)
			   return getName();
		   else
			   throw new Exception("Error: invalid column index in courselist table");
	}

	public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "student_id";
		   else if (i == 1)
			   colName = "name";
		   else 
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	}
    
}
