package org.example.hospitalrest.controller;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.hospitalrest.model.entity.User;
import org.example.hospitalrest.service.UserService;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    private UserService userService;

    @Inject
    public AuthResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Path("/register")
    public Response register(User user) {
        userService.addUser(user);
        return Response.ok("Registration successful").build();
    }

    @POST
    @Path("/login")
    public Response login(@Context HttpSession session, User user) {
        User existingUser = userService.getByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", existingUser);
            return Response.ok("Login successful").build();
        } else {
            throw new NotAuthorizedException("Invalid username or password");
        }
    }

    @POST
    @Path("/logout")
    public Response logout(@Context HttpSession session) {
        session.invalidate();
        return Response.ok("Logout successful").build();
    }
    
}