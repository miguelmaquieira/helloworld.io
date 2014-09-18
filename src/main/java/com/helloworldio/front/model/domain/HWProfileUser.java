package com.helloworldio.front.model.domain;

import java.util.Date;

public interface HWProfileUser {
	
	public String getUserId();
	public String getName();
	public Date getBirthdate();
	public String getGender();
	public String getPictureUrl();
	public String getFromLocation();
	public String getLivingLocation();
	public String getShortDescription();
	public String getLongDescription();
	public String getLooking();
	public String getTimezone();
	
	public void setUserId(String userId); 
	public void setName(String name);
	public void setBirthdate(Date birthdate);
	public void setGender(String gender);
	public void setPictureUrl(String pictureURL);
	public void setFromLocation(String fromLocation);
	public void setLivingLocation(String livingLocation);
	public void setShortDescription(String shortDescription);
	public void setLongDescription(String longDescription);
	public void setLooking(String looking);
	public void setTimezone(String timezone);

}
