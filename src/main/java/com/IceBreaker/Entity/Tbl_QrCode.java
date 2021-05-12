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
@Table(name = "tbl_qrcode")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tbl_QrCode.findAll", query = "SELECT t FROM Tbl_QrCode t ") })
public class Tbl_QrCode implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Size(max = 550)
    @Column(name = "club_name")
	String club_name;
	
	@Size(max = 550)
    @Column(name = "longitude")
	String longitude;
	
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 550)
    @Column(name = "latitude")
	String latitude;
    
    @Size(max = 550)
    @Column(name = "club_address")
	String club_address;
    
    @Size(max = 550)
    @Column(name = "club_tag")
	String club_tag;
    
    @Size(max = 50)
    @Column(name = "status")
	String status;

    @Size(max = 450)
    @Column(name = "qrCode_location")
	String qrCode_location;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQrCode_location() {
		return qrCode_location;
	}

	public void setQrCode_location(String qrCode_location) {
		this.qrCode_location = qrCode_location;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getClub_address() {
		return club_address;
	}

	public void setClub_address(String club_address) {
		this.club_address = club_address;
	}

	public String getClub_tag() {
		return club_tag;
	}

	public void setClub_tag(String club_tag) {
		this.club_tag = club_tag;
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
	