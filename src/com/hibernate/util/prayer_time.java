package com.hibernate.util;

public class prayer_time {
	String fajar, zuhr, asar, maghrib, esha;
	String place_id;
	mosques mosq;
	public String getFajar() {
		return fajar;
	}
	public void setFajar(String fajar) {
		this.fajar = fajar;
	}
	public String getZuhr() {
		return zuhr;
	}
	public void setZuhr(String zuhr) {
		this.zuhr = zuhr;
	}
	public String getAsar() {
		return asar;
	}
	public void setAsar(String asar) {
		this.asar = asar;
	}
	public String getMaghrib() {
		return maghrib;
	}
	public void setMaghrib(String maghrib) {
		this.maghrib = maghrib;
	}
	public String getEsha() {
		return esha;
	}
	public void setEsha(String esha) {
		this.esha = esha;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public mosques getMosq() {
		return mosq;
	}
	public void setMosq(mosques mosq) {
		this.mosq = mosq;
	}
}
