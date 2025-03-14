package com.tickets.tickets_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tickets.tickets_backend.records.Ticket;
import com.tickets.tickets_backend.dao.TicketDAO;

import java.util.List;

import java.net.URI;

@RestController
@RequestMapping("/tickets")

public class TicketsController {

    @Autowired
    private TicketDAO ticketDAO;

    @GetMapping("/listar")
    public ResponseEntity<?> getAllTickets(){
        return ResponseEntity.ok(ticketDAO.getAllTickets());
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearTicket(@RequestBody Ticket ticket){

        System.out.println(ticket);

        Integer codigo = ticketDAO.getAllTickets().size() + 1;
        ticket.setCodigo(codigo);

        ticketDAO.createTicket(ticket);

        return ResponseEntity.ok("{ \"status\": 200, \"message\": \"Ticket Creado\", \"data\":{} }");
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrarTicket(@RequestParam Integer codigo) {

        if(ticketDAO.deleteTicket(codigo)){
            return ResponseEntity.ok("{ \"status\": 200, \"message\": \"Se elimino el ticket\", \"data\":{} }");
        } else {
            return ResponseEntity.ok("{ \"status\": 500, \"message\": \"No existe el ticket\", \"data\":{} }");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarTicket(@RequestParam Integer codigo, String estado){

        if(ticketDAO.updateTicket(codigo, estado)){
            return ResponseEntity.ok("{ \"status\": 200, \"message\": \"Se actualizo el ticket\", \"data\":{} }");
        } else {
            return ResponseEntity.ok("{ \"status\": 500, \"message\": \"No existe el ticket\", \"data\":{} }");
        }
    }
}
