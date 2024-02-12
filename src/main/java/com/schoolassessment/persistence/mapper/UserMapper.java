package com.schoolassessment.persistence.mapper;

import java.util.List;
import com.schoolassessment.domain.dto.UserResponse;
import com.schoolassessment.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(source = "userName", target = "name"),
            @Mapping(source = "userEmail", target = "mail"),
            @Mapping(source = "userRole", target = "role"),
            @Mapping(source = "userEnabled", target = "enabled")
            }
    )
    UserResponse toUser(User user);

    List<UserResponse> toUsers(List<User> users);
@InheritInverseConfiguration
User userFromResponse (UserResponse user);

}
