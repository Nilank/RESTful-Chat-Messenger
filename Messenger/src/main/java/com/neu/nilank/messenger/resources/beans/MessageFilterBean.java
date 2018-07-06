/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.nilank.messenger.resources.beans;

import javax.ws.rs.QueryParam;

/**
 *
 * @author nilan
 */
public class MessageFilterBean {

    private @QueryParam("year")
    int year;
    private @QueryParam("start")
    int star;
    private @QueryParam("size")
    int size;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
