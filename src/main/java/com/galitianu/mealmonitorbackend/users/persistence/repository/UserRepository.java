package com.galitianu.mealmonitorbackend.users.persistence.repository;

import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
    Optional<UserEntity> getUserEntityByEmail(String email);
    Optional<UserEntity> getUserEntityByFirebaseId(String firebaseId);
}
