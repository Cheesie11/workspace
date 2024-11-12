package com.example.auth;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import io.smallrye.jwt.build.Jwt;

@Path("/auth")
public class AuthController {
    @POST
    @Path("/token")
    public Response generateToken() {
        try {
            String token = Jwt.upn("jdoe@quarkus.io").groups(new HashSet<>(Arrays.asList("User", "Admin"))).sign();
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}