package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.NotificationDTO;
import com.campusdual.fundme.model.dto.UserDTO;

import java.util.List;

public interface INotificationService {

    NotificationDTO getNotification(NotificationDTO notificationDTO);
    NotificationDTO getNotificationById(int notificationId);
    List<NotificationDTO> getUnreadNotificationsByUser(UserDTO user);
    List<NotificationDTO> getReadNotificationsByUser(UserDTO authenticatedUser);

    void markNotificationAsRead(int notificationId);

    List<NotificationDTO> getAllNotifications();

    int insertNotification (NotificationDTO notificationDTO);
    int updateNotification (NotificationDTO notificationDTO);
    int deleteNotification (NotificationDTO notificationDTO);


}