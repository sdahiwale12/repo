package com.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketResponse {

	private Integer ticketID;
	private String status;
	private Double cost;
	private String from;
	private String to;
	private String pnr;
	private String jDate;
	private String name;
	
}
