package com.helloworldio.front.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserProfiles")
public class HWProfileUserImpl implements HWProfileUser {
	
	@Id
	private String userId;
	
	private String name;
	private String gender;
	private Date birthdate;
	private String pictureURL;
	private String fromLocation;
	private String livingLocation;
	private String shortDescription;
	private String longDescription;
	private String looking;
	private String timezone;

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getBirthdate() {
		return birthdate;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public String getPictureUrl() {
		return pictureURL;
	}

	@Override
	public String getFromLocation() {
		return fromLocation;
	}

	@Override
	public String getLivingLocation() {
		return livingLocation;
	}

	@Override
	public String getShortDescription() {
		return shortDescription;
	}

	@Override
	public String getLongDescription() {
		return longDescription;
	}

	@Override
	public String getLooking() {
		return looking;
	}
	
	@Override
	public String getTimezone() {
		return timezone;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void setPictureUrl(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	@Override
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	@Override
	public void setLivingLocation(String livingLocation) {
		this.livingLocation = livingLocation;
	}

	@Override
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public void setLooking(String looking) {
		this.looking = looking;
	}

	@Override
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
}
