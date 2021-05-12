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
@Table(name = "tbl_login")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tbl_login.findAll", query = "SELECT t FROM Tbl_login t") })
public class Tbl_login implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Size(max = 250)
    @Column(name = "name")
	String name;
	
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "email")
	String email;
    
    @Size(max = 250)
    @Column(name = "username")
	String username;
    
    @Size(max = 10)
    @Column(name = "phone_no")
	String phone_no;
    
    @Size(max = 50)
    @Column(name = "age")
	String age;
    
    @Size(max = 50)
    @Column(name = "gender")
	String gender;
	
    @Size(max = 50)
    @Column(name = "role_id")
	String role_id;
    
	@Lob
    @Size(max = 65535)
    @Column(name = "device_token")
	String device_token;
	
	@JsonIgnore
	@Lob
	@Size(max = 65535)
	@Column(name="device_type")
	String device_type;
	
	/*
	 * @JsonIgnore
	 */
	
	@Lob
    @Size(max = 65535)
    @Column(name = "password")
	String password;
	
	@Size(max = 50)
    @Column(name = "status")
	String status;
	
	@Column(name = "join_data")
    @Temporal(TemporalType.TIMESTAMP)
	Date join_data;
	
	@Size(max = 350)
    @Column(name = "profilePic")
	String ProfilePic;
	
//	@Size(max = 20)
//    @Column(name = "updatedBy")
//	String updatedBy;
//	
//	@Column(name = "updatedDate")
//    @Temporal(TemporalType.TIMESTAMP)
//	Date updatedDate;
	
	/*@Size(max = 2)
    @Column(name = "deleted")
	String deleted;
	
	@Size(max = 2)
    @Column(name = "isFollowed")
	String isFollowed;*/
	
	
	/*@Size(max = 50)
    @Column(name = "designation")
	String designation;*/
	
	/*@Size(max = 550)
    @Column(name = "profileImage")
	String profileImage;
	
	@Size(max = 50)
    @Column(name = "signUpType")
	String signUpType;*/
	
	/*@Size(max = 50)
    @Column(name = "socialKey")
	String socialKey;*/
	
	
	
	/*@Size(max = 50)
    @Column(name = "about")
	String about;*/

	/*@Size(max = 50)
    @Column(name = "appType")
	String appType;
	
	@Size(max = 2)
    @Column(name = "isMailVerify")
	String isMailVerify;
	
	@Size(max = 250)
    @Column(name = "fbEmail")
	String fbEmail;
	
	@Size(max = 250)
    @Column(name = "gmailEmail")
	String gmailEmail;
	
	@Size(max = 250)
    @Column(name = "fbId")
	String fbId;
	
	@Size(max = 250)
    @Column(name = "gmailId")
	String gmailId;
	
	@Size(max = 250)
    @Column(name = "fbName")
	String fbName;
	
	@Size(max = 250)
    @Column(name = "gmailName")
	String gmailName;
	
	@Size(max = 250)
    @Column(name = "fbProfilePic")
	String fbProfilePic;
	
	@Size(max = 250)
    @Column(name = "gmailProfilePic")
	String gmailProfilePic;*/
	
	
	

	
	
	public String getProfilePic() {
		return ProfilePic;
	}

	public void setProfilePic(String profilePic) {
		ProfilePic = profilePic;
	}

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

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoin_data() {
		return join_data;
	}

	public void setJoin_data(Date join_data) {
		this.join_data = join_data;
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


	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	@Override
    public String toString() {
        return "com.WorkingHours.entity.Tbl_login[ id=" + id + " ]";
    }
	
}
