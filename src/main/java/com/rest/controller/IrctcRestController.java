package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.request.PassangerRequest;
import com.rest.response.TicketResponse;
import com.rest.service.IrctcService;

@RestController
public class IrctcRestController {

	@Autowired
	private IrctcService service;
	
	@PostMapping(value="/bookticket", consumes= {"application/xml", "application/json"})
	public ResponseEntity<String> bookTicket(@RequestBody PassangerRequest request){
		
		String pnr = service.bookTicket(request);
		String msg = "Ticket Booking Done : " + pnr;
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/ticket/{pnr}", produces= {"application/xml", "application/json"})
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String pnr){
		
		TicketResponse ticket = service.GetTicketByPnr(pnr);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
		
	}
	
	@PutMapping(value="/ticket/update", consumes = {"application/xml", "application/json"} )
	public ResponseEntity<String> updateTicket(@RequestBody TicketResponse ticket){
		
		String msg = service.UpdateTicket(ticket);
		return new ResponseEntity<>(msg,HttpStatus.OK );
	} 
	
	@DeleteMapping("/ticket/{pnr}")
	public ResponseEntity<String> deleteTicket(@PathVariable String pnr){
		
		String msg = service.DeleteTicket(pnr);
		return new ResponseEntity<>(msg, HttpStatus.OK);
				
	}
	
}
