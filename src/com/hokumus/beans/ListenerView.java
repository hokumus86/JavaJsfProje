package com.hokumus.beans;

import javax.faces.bean.ManagedBean;

@SuppressWarnings("deprecation")
@ManagedBean(name = "listenerView")

public class ListenerView {
     
    private String text="";
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
     
    public void handleKeyEvent() {
        text = text.toUpperCase();
    }
}