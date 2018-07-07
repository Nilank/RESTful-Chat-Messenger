/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.nilank.messenger.service;

import com.neu.nilank.messenger.database.DatabaseClass;
import com.neu.nilank.messenger.model.Comment;
import com.neu.nilank.messenger.model.ErrorMessage;
import com.neu.nilank.messenger.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author nilan
 */
public class CommentService {
    
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    
    public List<Comment> getAllComments(long messageId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }
    
    public Comment getComment(long messageId, long commentId){
        ErrorMessage errorMessage = new ErrorMessage("Not Found", 404, "http://google.com");
        Response response =  Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
        Message message = messages.get(messageId);
        if(message == null){
            throw new WebApplicationException(response);
        }
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        Comment comment = comments.get(commentId);
        if(comment == null){
            throw new NotFoundException(response);
        }
        return comments.get(commentId);   
    }
    
    public Comment addComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(), comment);
        return comment;     
    }
    
    public Comment updateComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if(comment.getId()<=0){
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }
    
    public Comment removeComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
    
    
}
