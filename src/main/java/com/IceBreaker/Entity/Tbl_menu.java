package com.IceBreaker.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tbl_menu")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tbl_menu.findAll", query = "SELECT t FROM Tbl_menu t ") })
public class Tbl_menu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Size(max = 1250)
    @Column(name = "icon_class")
	String icon_class;
	
	@Size(max = 1250)
    @Column(name = "menu_name")
	String menu_name;
	
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 1250)
    @Column(name = "url")
	String url;
    
    @Size(max = 1250)
    @Column(name = "parent_class")
	String parent_class;
    
    @Size(max = 310)
    @Column(name = "priority")
	String priority;
    
    @Size(max = 350)
    @Column(name = "status")
	String status;
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

	/*
	 * @Override public boolean equals(Object object) { // TODO: Warning - this
	 * method won't work in the case the id fields are not set if (!(object
	 * instanceof TblUsers)) { return false; } TblUsers other = (TblUsers) object;
	 * if ((this.id == null && other.id != null) || (this.id != null &&
	 * !this.id.equals(other.id))) { return false; } return true; }
	 */

   

	@Override
    public String toString() {
        return "com.WorkingHours.entity.Tbl_menu[ id=" + id + " ]";
    }

	public String getIcon_class() {
		return icon_class;
	}

	public void setIcon_class(String icon_class) {
		this.icon_class = icon_class;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParent_class() {
		return parent_class;
	}

	public void setParent_class(String parent_class) {
		this.parent_class = parent_class;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
