/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ksusha
 */
@Entity
@Table(name = "Media")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
//    @NamedQuery(name = "Media.findByName", query = "SELECT m FROM Media m WHERE m.name = :name"),
//    @NamedQuery(name = "Media.findByPath", query = "SELECT m FROM Media m WHERE m.path = :path")})
public class Media implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "path")
    private String path;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProjectDetails projectId;

    public Media() {
    }

    public Media(String path) {
        this.path = path;
    }

    public Media(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        hash += (path != null ? path.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.path == null && other.path != null) || (this.path != null && !this.path.equals(other.path))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Media[ path=" + path + " ]";
    }

	public static int getNumberOfColumns() {
		// TODO Auto-generated method stub
		return 3;
	}

	public Object getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getName();
		   else if (i == 1)
			   return getPath();
		   else if (i == 2)
			   return getProjectId();
		   else
			   throw new Exception("Error: invalid column index in courselist table");
	}

	public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "name";
		   else if (i == 1)
			   colName = "path";
		   else if (i == 2)
			   colName = "project_id";
		   else 
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	}
    
}
