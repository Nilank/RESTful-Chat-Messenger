/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.nilank.messenger.service;

import com.neu.nilank.messenger.model.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nilan
 */
public class MessageService {
    
    public List<Message> getAllMessages(){
        Message m1 = new Message(1L,"Hello World", "Nilank");
        Message m2 = new Message(2L, "Hello Jersey", "Nilank");
        List<Message> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        return list;
    }
    
}
