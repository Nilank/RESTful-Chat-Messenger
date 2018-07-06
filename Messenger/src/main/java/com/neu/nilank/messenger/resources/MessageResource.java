/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.nilank.messenger.resources;

import com.neu.nilank.messenger.model.Message;
import com.neu.nilank.messenger.resources.beans.MessageFilterBean;
import com.neu.nilank.messenger.service.MessageService;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nilan
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    
    MessageService messageService = new MessageService();
    
    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
        if(filterBean.getYear() > 0){
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }
        if(filterBean.getStar()>=0 && filterBean.getSize()>=0){
            return messageService.getAllMessagesPaginated(filterBean.getStar(), filterBean.getSize());
        }
        
        return messageService.getAllMessages();
    }
    
    @POST
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }
    
    @PUT
    @Path("/{messageId}")
    public Message updateMeesage(@PathParam("messageId") long id, Message message){
        message.setId(id);
        return messageService.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
    }
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id){
        return messageService.getMessage(id);
        
    }
    
}
