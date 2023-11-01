package com.campusdual.fundme.service;

import com.campusdual.fundme.api.INotificationService;
import com.campusdual.fundme.model.Notification;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.NotificationDTO;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.model.dto.dtopmapper.NotificationMapper;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;
import com.campusdual.fundme.model.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
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

    public void createCommentNotification(User recipient, User commenter, Project project) {

        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setType("comment");
        notification.setMessage(commenter.getName() + " ha comentado en tu proyecto " + project.getTitle());
        notification.setCreatedDate(new Date());
        notification.setRead(false);
        notification.setRelatedUser(commenter);
        notification.setRelatedProject(project);

        notificationRepository.save(notification);

    }

    public void createDonationNotification(User recipient, User donor, Project project) {

        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setType("donation");
        notification.setMessage(donor.getName() + " ha donado a tu proyecto " + project.getTitle());
        notification.setCreatedDate(new Date());
        notification.setRead(false);
        notification.setRelatedUser(donor);
        notification.setRelatedProject(project);

        notificationRepository.save(notification);

    }

    @Override
    public List<NotificationDTO> getUnreadNotificationsByUserOrderByCreatedDateDesc(UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        List<Notification> unreadNotifications = notificationRepository.findByRecipientAndReadOrderByCreatedDateDesc(user, false);

        return NotificationMapper.INSTANCE.toDTOList(unreadNotifications);

    }

    @Override
    public List<NotificationDTO> getReadNotificationsByUserOrderByCreatedDateDesc(UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        List<Notification> readNotifications = notificationRepository.findByRecipientAndReadOrderByCreatedDateDesc(user, true);

        return NotificationMapper.INSTANCE.toDTOList(readNotifications);

    }

    public void markNotificationAsRead(int notificationId) {

        NotificationDTO notificationDTO = getNotificationById(notificationId);

        notificationDTO.setRead(true);

        updateNotification(notificationDTO);

    }

}