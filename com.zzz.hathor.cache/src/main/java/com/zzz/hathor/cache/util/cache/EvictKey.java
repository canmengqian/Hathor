package com.zzz.hathor.cache.util.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EvictKey<E> {
	private E key;
	
	
	private TimeUnit timeUnit;
	
	private Date pushTime ;
	
	private Date visitTime;
	
	private long maxAliveTime;

	
	
	
	
	public Date getPushTime() {
	
		return pushTime;
	}


	
	public void setPushTime(Date pushTime) {
	
		this.pushTime = pushTime;
	}


	
	public Date getVisitTime() {
	
		return visitTime;
	}


	
	public void setVisitTime(Date visitTime) {
	
		this.visitTime = visitTime;
	}


	

	public E getKey() {
	
		return key;
	}

	
	public void setKey(E key) {
	
		this.key = key;
	}

	
	
	
	public TimeUnit getTimeUnit() {
	
		return timeUnit;
	}

	
	public void setTimeUnit(TimeUnit timeUnit) {
	
		this.timeUnit = timeUnit;
	}


	public EvictKey(E key, long expireTime, TimeUnit timeUnit) {

		super();
		this.key = key;
		this.timeUnit = timeUnit;
	}


	public EvictKey() {

		super();
	}
	
	
}
