package com.xiachao.chatroom.controller;

import com.xiachao.chatroom.service.impl.ChatRoomServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    @Resource
    private ChatRoomServiceImpl chatRoomService;

    @PostMapping("/join")
    public ResponseEntity<String> joinRoom(@RequestParam String roomId, @RequestParam String userId) {
        chatRoomService.joinRoom(roomId, userId);
        return ResponseEntity.ok("用户 " + userId + " 加入房间 " + roomId);
    }

    @PostMapping("/leave")
    public ResponseEntity<String> leaveRoom(@RequestParam String roomId, @RequestParam String userId) {
        chatRoomService.leaveRoom(roomId, userId);
        return ResponseEntity.ok("用户 " + userId + " 离开房间 " + roomId);
    }
}