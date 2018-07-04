/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.nilank.messenger.service;

import com.neu.nilank.messenger.database.DatabaseClass;
import com.neu.nilank.messenger.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nilan
 */
public class MessageService {
    
    
    private static Map<Long, Message> messages = DatabaseClass.getMessages();
    
    public MessageService(){
        messages.put(1L, new Message(1, "Hello World", "Nilank"));
        messages.put(2L, new Message(2, "Hello Jersey", "Nilank"));
    }
    
    public List<Message> getAllMessages(){
        return new ArrayList<Message>(messages.values());
    }
    
    public List<Message> getAllMessagesForYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message message : messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR)== year){
                messagesForYear.add(message);    
            }
        }
        return messagesForYear;  
    }
    
    public List<Message> getAllMessagesPaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<Message>(messages.values());
        if(start + size > list.size()){
            return new ArrayList<Message>();
        }
        return list.subList(start, start+size);
    }
    
    public Message getMessage(long id){
        return messages.get(id);
    }
    
    public Message addMessage(Message message){
        message.setId(messages.size()+1);
        messages.put(message.getId(), message);
        return message;   
    }
    
    public Message updateMessage(Message message){
        if(message.getId()<=0){
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }
    
    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
