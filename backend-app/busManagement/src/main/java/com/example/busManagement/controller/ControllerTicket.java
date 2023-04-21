package com.example.busManagement.controller;

import com.example.busManagement.domain.*;
import com.example.busManagement.domain.DTO.TicketDTO;
import com.example.busManagement.domain.DTO.TicketDTOWithId;
import com.example.busManagement.service.ServiceTicket;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class ControllerTicket {

    private final ServiceTicket ControllerTicket;

    ControllerTicket(ServiceTicket controllerTicket) {
        ControllerTicket = controllerTicket;
    }

    //GETALL without people & busRoutes, only with ID Person,Route[ 1: Person&Route]
    @GetMapping("/api/tickets")
    @CrossOrigin(origins = "*")
    List<TicketDTOWithId> all() {
        return ControllerTicket.getAllTickets();
    }

    //GET BY ID, with People && BusRoutes
    @GetMapping("/api/tickets/{id}")
    @CrossOrigin(origins = "*")
    TicketDTO one(@PathVariable Long id) {

        return ControllerTicket.getByIdTicket(id);
    }


    // Add to a new ticket existing PersonID & BusRouteID
    @PostMapping("/api/tickets/people/{personID}/busroutes/{busrouteID}")   // ADD
    Ticket newTicket(@RequestBody Ticket newTicket,@PathVariable Long personID,@PathVariable Long busrouteID)
    {
       return ControllerTicket.addTicket(newTicket,personID,busrouteID);
    }


    // A4 requirement; Add to an existing [list of tickets] an existing busRoute
    @PostMapping("/api/tickets/{busrouteID}")   // ADD
    List<Ticket> newTicketList(@RequestBody List<TicketDTOWithId> TicketList, @PathVariable Long busrouteID)
    {
        return ControllerTicket.addSingleTicket(TicketList,busrouteID);
    }


    @PutMapping("/api/tickets/{id}")     //UPDATE
    Ticket replaceTicket(@RequestBody Ticket newTicket, @PathVariable Long id) {

       return ControllerTicket.updateTicket(newTicket,id);
    }


    @DeleteMapping("/api/tickets/{id}")  //DELETE
    void deleteTicket(@PathVariable Long id) {

        ControllerTicket.deleteTicket(id);
    }


}
