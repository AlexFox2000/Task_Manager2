package com.task.mc_notification.service;

import com.task.mc_notification.entity.Notification;
import com.task.mc_notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public Notification getNotificationByUserId(Long userId) {
        return notificationRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("This user with id " + userId + " not found."));
    }

    public Notification markNotificationAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new IllegalArgumentException("Notification with id " + notificationId + " not found."));
        notification.setRead(true);

        return notificationRepository.save(notification);
    }
}
