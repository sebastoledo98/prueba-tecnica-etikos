package com.tickets.tickets_backend.records;

import java.util.ArrayList;
import java.util.List;

public class StorageTickets {

    private List<Ticket> tickets;

    public StorageTickets(){
        tickets = new ArrayList<>();
    }

    public StorageTickets(Ticket ticket){
        tickets = new ArrayList<>();
        tickets.add(ticket);
    }

    public List<Ticket> getAllTickets(){
        return tickets;
    }

    public void addTicket(){
    }

}
