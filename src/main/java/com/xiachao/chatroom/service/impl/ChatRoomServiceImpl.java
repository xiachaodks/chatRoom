package com.xiachao.chatroom.service.impl;

import com.xiachao.chatroom.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final Map<String, Set<String>> chatRooms = new ConcurrentHashMap<>();


    @Override
    public void joinRoom(String roomId, String userId) {
        chatRooms.computeIfAbsent(roomId, k -> ConcurrentHashMap.newKeySet()).add(userId);
        printRoomMembers(roomId, userId);
    }

    @Override
    public void leaveRoom(String roomId, String userId) {
        Set<String> members = chatRooms.get(roomId);
        if (members != null) {
            members.remove(userId);
            printRoomMembers(roomId, userId);
        }
    }

    private void printRoomMembers(String roomId, String excludeUserId) {
        Set<String> members = chatRooms.getOrDefault(roomId, Collections.emptySet());
        members.stream()
                .filter(member -> !member.equals(excludeUserId))
                .forEach(System.out::println);
    }
}
