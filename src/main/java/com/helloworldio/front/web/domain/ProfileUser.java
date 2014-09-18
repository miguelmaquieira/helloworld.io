package com.helloworldio.front.web.domain;

import org.springframework.stereotype.Component;

import com.helloworldio.common.CommonBeanUtils;

@Component("userData")
public class ProfileUser extends SignupUser {

	private static final long serialVersionUID = -6251769749897349506L;
	
	private String token;
	private int status;
	
	private String pictureURL;
	private String myPicture;
	private String birthdate;
	private String timezone;
	private String fromLocation;
	private String livingLocation;
	private String gender;
	private String shortDescription;
	private String longDescription;
	private String looking;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	
	public String getMyPicture() {
		return myPicture;
	}
	public void setMyPicture(String myPicture) {
		this.myPicture = myPicture;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	public String getLooking() {
		return looking;
	}
	public void setLooking(String looking) {
		this.looking = looking;
	}
	
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	
	public String getLivingLocation() {
		return livingLocation;
	}
	public void setLivingLocation(String livingLocation) {
		this.livingLocation = livingLocation;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPictureUrl() {
		return pictureURL;
	}
	public void setPictureUrl(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	
	@Override
	public String toString() {
		return CommonBeanUtils.toString(this);
	}	
}
