package com.campusdual.fundme.service;

import com.campusdual.fundme.api.INotificationService;
import com.campusdual.fundme.model.Notification;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.NotificationDTO;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.model.dto.dtopmapper.NotificationMapper;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;
import com.campusdual.fundme.model.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDTO getNotification(NotificationDTO notificationDTO) {

        Notification notification = NotificationMapper.INSTANCE.toEntity(notificationDTO);

        return NotificationMapper.INSTANCE.toDTO(this.notificationRepository.getReferenceById(notification.getNotificationId()));

    }

    @Override
    public NotificationDTO getNotificationById(int notificationId) {

        Notification notification = notificationRepository.getReferenceById(notificationId);

        return NotificationMapper.INSTANCE.toDTO(notification);

    }

    @Override
    public List<NotificationDTO> getAllNotifications() { return NotificationMapper.INSTANCE.toDTOList(notificationRepository.findAll()); }

    @Override
    public int insertNotification(NotificationDTO notificationDTO) {

        Notification notification = NotificationMapper.INSTANCE.toEntity(notificationDTO);
        this.notificationRepository.saveAndFlush(notification);

        return notification.getNotificationId();

    }

    @Override
    public int updateNotification(NotificationDTO notificationDTO) { return this.insertNotification(notificationDTO); }

    @Override
    public int deleteNotification(NotificationDTO notificationDTO) {

        int id = notificationDTO.getNotificationId();
        Notification notification = NotificationMapper.INSTANCE.toEntity(notificationDTO);
        this.notificationRepository.delete(notification);

        return id;

    }

    @Override
    public List<NotificationDTO> getUnreadNotificationsByUser(UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        List<Notification> unreadNotifications = notificationRepository.findByRelatedUserAndReadOrderByCreatedDateDesc(user, false);

        return NotificationMapper.INSTANCE.toDTOList(unreadNotifications);

    }

    @Override
    public List<NotificationDTO> getReadNotificationsByUser(UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        List<Notification> readNotifications = notificationRepository.findByRelatedUserAndReadOrderByCreatedDateDesc(user, true);

        return NotificationMapper.INSTANCE.toDTOList(readNotifications);

    }

    public void markNotificationAsRead(int notificationId) {

        NotificationDTO notificationDTO = getNotificationById(notificationId);

        notificationDTO.setRead(true);

        updateNotification(notificationDTO);

    }

}