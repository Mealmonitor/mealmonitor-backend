package com.galitianu.mealmonitorbackend.users.mapper;

import com.galitianu.mealmonitorbackend.common.mapper.BaseModelEntityMapper;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserEntity;
import com.galitianu.mealmonitorbackend.users.service.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseModelEntityMapper<User, UserEntity> {

}
