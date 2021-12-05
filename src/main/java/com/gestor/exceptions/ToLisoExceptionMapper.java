package com.gestor.exceptions;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ToLisoExceptionMapper implements ExceptionMapper<NegocioException> {

    @Override
    public Response toResponse(NegocioException e) {
        return Response.status(Response.Status.OK).entity(new NegocioExceptionDTO(e.getMessage())).build();
    }
}
