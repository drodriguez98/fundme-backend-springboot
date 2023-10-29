package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Notification;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.NotificationDTO;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.UserDTO;

import java.util.List;

public interface INotificationService {

    NotificationDTO getNotification(NotificationDTO notificationDTO);
    NotificationDTO getNotificationById(int notificationId);

    List<NotificationDTO> getAllNotifications();

    int insertNotification (NotificationDTO notificationDTO);
    int updateNotification (NotificationDTO notificationDTO);
    int deleteNotification (NotificationDTO notificationDTO);

    void createCommentNotification(User recipient, User commenter, Project project);
    void createDonationNotification(User recipient, User donor, Project project);

    List<NotificationDTO> getUnreadNotificationsByUser(UserDTO user);

    void markNotificationAsRead(int notificationId);
}