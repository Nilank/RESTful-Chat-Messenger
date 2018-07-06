/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.nilank.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    
    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("customHeaderValue") String header,
                                            @CookieParam("name") String cookie){
        return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie param: " + cookie;
    }
    
    @GET
    @Path("context")
    public String getParmsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders header ){
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = header.getCookies().toString();
        return "Path: " + path + " Cookies: " + cookies;
        
    }
    
}
