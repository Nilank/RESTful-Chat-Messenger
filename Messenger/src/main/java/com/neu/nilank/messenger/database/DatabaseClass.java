/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.nilank.messenger.database;

import com.neu.nilank.messenger.model.Message;
import com.neu.nilank.messenger.model.Profile;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nilan
 */
public class DatabaseClass {
    
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
    
    
    
}
