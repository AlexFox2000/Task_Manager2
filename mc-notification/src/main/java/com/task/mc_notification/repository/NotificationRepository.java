package com.task.mc_notification.repository;

import com.task.mc_notification.entity.Notification;
import org.jfree.ui.Layer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository <Notification, Long> {
    List<Notification> findByUserId(Long userId);
}
