package org.example.hospitalrest.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.hospitalrest.model.entity.Consultation;
import org.example.hospitalrest.service.ConsultationService;

import java.util.List;

@Path("/consultations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultationResource {

    private ConsultationService consultationService;

    @Inject
    public ConsultationResource(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GET
    @Path("/{id}")
    public Consultation getOneConsultation(@PathParam("id") int id) {
        return consultationService.getConsultation(id);
    }

    @GET
    public List<Consultation> getAllConsultations() {
        return consultationService.getConsultations();
    }

    @POST
    public Consultation createConsultation(Consultation consultation) {
        consultationService.addConsultation(consultation);
        return consultation;
    }

    @PUT
    @Path("/{id}")
    public Consultation updateConsultation(@PathParam("id") int id, Consultation consultation) {
        if (consultation.getId() != id) {
            throw new BadRequestException("ID in URL does not match ID in Consultation object");
        }
        return consultationService.updateConsultation(consultation);
    }

    @DELETE
    @Path("/{id}")
    public void deleteConsultation(@PathParam("id") int id) {
        consultationService.deleteConsultation(id);
    }
}