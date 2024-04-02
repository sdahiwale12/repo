package com.rest.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.rest.response.TicketResponse;

@Repository
public class IrctcDao {

	private Map<String, TicketResponse> ticketsMap = new HashMap<>();
	
	public String saveTicket(TicketResponse response) {
		//logic will be there to save ticket in DB
		
		ticketsMap.put(response.getPnr(), response);
		return response.getPnr();
	}
	
	public TicketResponse getTicketByPnr(String pnr) {
		//logic will be there to get ticket from DB
		if(ticketsMap.containsKey(pnr)) {
			return ticketsMap.get(pnr);
			}
		return null;
		}
	
	public String UpdateTicket(TicketResponse response) {
		
		String pnr = response.getPnr();
		ticketsMap.put(pnr, response);
		return "Ticket Updated";
	}
	
	public String DeleteTicket(String pnr) {
		
		ticketsMap.remove(pnr);
		return "Ticket Deleted";
	}
	
}
