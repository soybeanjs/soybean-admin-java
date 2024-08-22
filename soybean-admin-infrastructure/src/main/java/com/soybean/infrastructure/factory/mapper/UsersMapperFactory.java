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
            @Mapping(source = "id", target = "userId")
    })
    UsersDTO map(UsersDO usersDO);
}
