package com.tickets.tickets_backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tickets.tickets_backend.records.Ticket;

@Repository
public class TicketDAO {

    private List<Ticket> tickets;

    public TicketDAO(){
        tickets = new ArrayList<>();
    }

    public TicketDAO(Ticket ticket){
        tickets = new ArrayList<>();
        tickets.add(ticket);
    }

    public List<Ticket> getAllTickets(){
        return tickets;
    }

    public void createTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public boolean deleteTicket(Integer codigo){
        for (Ticket ticket : tickets) {
            if(ticket.getCodigo() == codigo){
                tickets.remove(ticket);
                return true;
            }
        }
        return false;
    }

    public Ticket readTicket(Integer codigo){
        for (Ticket ticket : tickets) {
            if(ticket.getCodigo() == codigo){
                return ticket;
            }
        }
        return null;
    }

    public boolean updateTicket(Integer codigo, String estado){
        for (Ticket t : tickets) {
            if(t.getCodigo() == codigo){
                int i = tickets.indexOf(t);
                t.setEstado(estado);
                tickets.set(i, t);
                return true;
            }
        }
        return false;
    }

}
