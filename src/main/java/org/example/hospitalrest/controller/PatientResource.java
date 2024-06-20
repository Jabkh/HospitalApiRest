package org.example.hospitalrest.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.hospitalrest.model.entity.Patient;
import org.example.hospitalrest.service.PatientService;

import java.util.List;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {

    private PatientService patientService;

    @Inject
    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @GET
    @Path("/{id}")
    public Patient getOnePatient(@PathParam("id") int id) {
        return patientService.getPatient(id);
    }

    @GET
    public List<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @POST
    public Patient createPatient(Patient patient) {
        patientService.addPatient(patient);
        return patient;
    }

    @PUT
    @Path("/{id}")
    public Patient updatePatient(@PathParam("id") int id, Patient patient) {
        if (patient.getId() != id) {
            throw new BadRequestException("ID in URL does not match ID in Patient object");
        }
        return patientService.updatePatient(patient);
    }

    @DELETE
    @Path("/{id}")
    public void deletePatient(@PathParam("id") int id) {
        patientService.deletePatient(id);
    }
}