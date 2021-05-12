package com.IceBreaker.Entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "tbl_permission")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tbl_permission.findAll", query = "SELECT t FROM Tbl_permission t") })
public class Tbl_permission implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Size(max = 250)
    @Column(name = "roleId")
	String roleId;
	
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "parent")
	String parent;
    
    @Size(max = 250)
    @Column(name = "child")
	String child;
    
    
	/*
	 * @Override public boolean equals(Object object) { // TODO: Warning - this
	 * method won't work in the case the id fields are not set if (!(object
	 * instanceof TblUsers)) { return false; } TblUsers other = (TblUsers) object;
	 * if ((this.id == null && other.id != null) || (this.id != null &&
	 * !this.id.equals(other.id))) { return false; } return true; }
	 */

   

	@Override
    public String toString() {
        return "com.WorkingHours.entity.Tbl_permission[ id=" + id + " ]";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
