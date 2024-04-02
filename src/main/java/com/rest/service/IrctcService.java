package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.IrctcDao;
import com.rest.request.PassangerRequest;
import com.rest.response.TicketResponse;

@Service
public class IrctcService {
	
	@Autowired
	private IrctcDao dao;

	public String bookTicket(PassangerRequest request) {
		
		TicketResponse response = new TicketResponse();
		response.setTicketID(123);
		response.setName(request.getName());
		response.setStatus("CONFIRMED");
		response.setCost(453.45);
		response.setFrom(request.getFrom());
		response.setTo(request.getTo());
		response.setJDate(request.getJDate());
		response.setPnr("PNR28735722");
		
		dao.saveTicket(response);
		return "PNR28735722";
		}
	
	public TicketResponse GetTicketByPnr(String pnr) {
		
		return dao.getTicketByPnr(pnr);
	}
	
	public String UpdateTicket(TicketResponse ticket) {
		
		 return dao.UpdateTicket(ticket);
		
	}
	
	public String DeleteTicket(String pnr) {
		
		return dao.DeleteTicket(pnr);
	}
	
}
