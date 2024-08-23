package com.soybean.infrastructure.factory.mapper;

import com.soybean.domain.model.UsersDTO;
import com.soybean.infrastructure.resources.entity.UsersDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsersMapperFactory {

    UsersMapperFactory MAPPER = Mappers.getMapper(UsersMapperFactory.class);

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "usersBasic.username"),
            @Mapping(source = "password", target = "usersBasic.password"),
            @Mapping(source = "nickName", target = "usersBasic.nickName"),
            @Mapping(target = "usersBasic.usersType", expression = "java(mapToUserType(usersDO))"),
            @Mapping(source = "email", target = "usersBasic.email"),
            @Mapping(source = "phoneNumber", target = "usersBasic.phoneNumber"),
            @Mapping(target = "usersBasic.sex", expression = "java(mapToSex(usersDO))"),
            @Mapping(source = "avatar", target = "usersBasic.avatar"),
            @Mapping(target = "usersBasic.usersState", expression = "java(mapToUsersState(usersDO))"),
            @Mapping(source = "delFlag", target = "usersBasic.delFlag")
    })
    UsersDTO map(UsersDO usersDO);

    default UsersDTO.UsersState mapToUsersState(UsersDO usersDO) {
        return UsersDTO.UsersState.of(usersDO.getStatus());
    }

    default UsersDTO.Gender mapToSex(UsersDO usersDO) {
        return UsersDTO.Gender.of(usersDO.getSex());
    }

    default UsersDTO.UsersType mapToUserType(UsersDO usersDO) {
        return UsersDTO.UsersType.of(usersDO.getUserType());
    }

}
