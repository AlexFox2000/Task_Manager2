package com.task.mc_notification.controller;

import com.task.mc_notification.entity.Notification;
import com.task.mc_notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping ("/notifications")
@Controller
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public Notification getNotificationByUserId (Long userId){
        return notificationService.getNotificationByUserId(userId);
    }

    @PutMapping
    public Notification markNotificationAsRead (Long notificationId){
        return notificationService.markNotificationAsRead(notificationId);
    }

}
