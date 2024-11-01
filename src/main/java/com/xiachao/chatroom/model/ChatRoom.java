package com.xiachao.chatroom.model;

import lombok.Data;

import java.util.Set;


@Data
public class ChatRoom {
    private String roomId;
    private Set<String> users;
}
