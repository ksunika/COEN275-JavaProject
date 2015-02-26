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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ksusha
 */
@Entity
@Table(name = "hyperlinktype")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Hyperlinktype.findAll", query = "SELECT h FROM Hyperlinktype h"),
//    @NamedQuery(name = "Hyperlinktype.findById", query = "SELECT h FROM Hyperlinktype h WHERE h.id = :id"),
//    @NamedQuery(name = "Hyperlinktype.findByType", query = "SELECT h FROM Hyperlinktype h WHERE h.type = :type")})
public class Hyperlinktype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private List<Hyperlink> hyperlinkList;

    public Hyperlinktype() {
    }

    public Hyperlinktype(Integer id) {
        this.id = id;
    }

    public Hyperlinktype(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    @XmlTransient
    public List<Hyperlink> getHyperlinkList() {
        return hyperlinkList;
    }

    public void setHyperlinkList(List<Hyperlink> hyperlinkList) {
        this.hyperlinkList = hyperlinkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hyperlinktype)) {
            return false;
        }
        Hyperlinktype other = (Hyperlinktype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Hyperlinktype[ id=" + id + " ]";
    }
    
}
