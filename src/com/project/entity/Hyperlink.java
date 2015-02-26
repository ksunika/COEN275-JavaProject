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
@Table(name = "hyperlink")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Hyperlink.findAll", query = "SELECT h FROM Hyperlink h"),
//    @NamedQuery(name = "Hyperlink.findByHyperlink", query = "SELECT h FROM Hyperlink h WHERE h.hyperlink = :hyperlink")})
public class Hyperlink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hyperlink")
    private String hyperlink;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Hyperlinktype id;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProjectDetails projectId;

    public Hyperlink() {
    }

    public Hyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public Hyperlinktype getId() {
        return id;
    }

    public void setId(Hyperlinktype id) {
        this.id = id;
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
        hash += (hyperlink != null ? hyperlink.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hyperlink)) {
            return false;
        }
        Hyperlink other = (Hyperlink) object;
        if ((this.hyperlink == null && other.hyperlink != null) || (this.hyperlink != null && !this.hyperlink.equals(other.hyperlink))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Hyperlink[ hyperlink=" + hyperlink + " ]";
    }

	public static int getNumberOfColumns() {
		// TODO Auto-generated method stub
		return 3;
	}

	public Object getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getHyperlink();
		   else if (i == 1)
			   return getProjectId();
		   else if (i == 2)
			   return getId();
		   else
			   throw new Exception("Error: invalid column index in courselist table");
	}

	public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "hyperlink";
		   else if (i == 1)
			   colName = "project_id";
		   else if (i == 2)
			   colName = "id";
		   else 
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	}
    
}
