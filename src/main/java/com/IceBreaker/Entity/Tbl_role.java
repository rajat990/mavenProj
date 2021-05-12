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
@Table(name = "tbl_role")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tbl_role.findAll", query = "SELECT t FROM Tbl_role t") })
public class Tbl_role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Size(max = 250)
    @Column(name = "roleName")
	String roleName;
	
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "status")
	String status;
    

    
    
	/*
	 * @Override public boolean equals(Object object) { // TODO: Warning - this
	 * method won't work in the case the id fields are not set if (!(object
	 * instanceof TblUsers)) { return false; } TblUsers other = (TblUsers) object;
	 * if ((this.id == null && other.id != null) || (this.id != null &&
	 * !this.id.equals(other.id))) { return false; } return true; }
	 */

   

	@Override
    public String toString() {
        return "com.WorkingHours.entity.Tbl_role[ id=" + id + " ]";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
