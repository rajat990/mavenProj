package com.IceBreaker.Entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "TblLocation.findAll", query = "SELECT t FROM TblLocation t") })
public class TblLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	int id;
	
	@Column(name = "location_identifier")
	String locationIdentifier;
	
	@Column(name = "date_of_registration")
	Date dateOfRegistration;
	
	@Column(name = "date_of_end_of_registration")
	Date dateOfEndOfRegistration;
	
	@Column(name = "status")
	String status;
	
	@Column(name = "latitude")
	String latitude;
	
	@Column(name = "longitude")
	String longitude;
	
	@Column(name = "distance")
	String distance;
	
	@Column(name = "type")
	String type;
	
	@Column(name = "location_name")
	String locationName;
	
	@Column(name = "location_phone_number")
	String locationPhoneNumber;
	
	@Column(name = "location_email")
	String locationEmail;
	
	@Column(name = "location_address")
	String locationAddress;
	
	@Column(name = "mongo_location_id")
	String mongoLocationId;
	
	@Column(name = "notes")
	String notes;
	
	@Column(name = "qrCode")
	String qrCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationIdentifier() {
		return locationIdentifier;
	}

	public void setLocationIdentifier(String locationIdentifier) {
		this.locationIdentifier = locationIdentifier;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Date getDateOfEndOfRegistration() {
		return dateOfEndOfRegistration;
	}

	public void setDateOfEndOfRegistration(Date dateOfEndOfRegistration) {
		this.dateOfEndOfRegistration = dateOfEndOfRegistration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationPhoneNumber() {
		return locationPhoneNumber;
	}

	public void setLocationPhoneNumber(String locationPhoneNumber) {
		this.locationPhoneNumber = locationPhoneNumber;
	}

	public String getLocationEmail() {
		return locationEmail;
	}

	public void setLocationEmail(String locationEmail) {
		this.locationEmail = locationEmail;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getMongoLocationId() {
		return mongoLocationId;
	}

	public void setMongoLocationId(String mongoLocationId) {
		this.mongoLocationId = mongoLocationId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
	

}
