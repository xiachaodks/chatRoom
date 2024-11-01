package com.xiachao.chatroom.service;

public interface ChatRoomService {
     void joinRoom(String roomId, String userId);

     void leaveRoom(String roomId, String userId);
}
