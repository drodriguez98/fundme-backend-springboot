package com.campusdual.fundme.model.dto.dtopmapper;

import com.campusdual.fundme.model.Notification;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.NotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);
    NotificationDTO toDTO(Notification notification);
    List<NotificationDTO> toDTOList(List<Notification> notifications);
    Notification toEntity(NotificationDTO notificationDTO);

}
