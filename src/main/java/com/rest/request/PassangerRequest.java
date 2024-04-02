package com.rest.request;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class PassangerRequest {

	private String name;
	private String email; 
	private long phoneNo;
	private String from;
	private String to;
	private String jDate;
	private String trainNum;
	
}
