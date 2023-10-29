package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Notification;
import com.campusdual.fundme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    List<Notification> findByRecipientAndReadOrderByCreatedDateDesc(User user, boolean read);

}