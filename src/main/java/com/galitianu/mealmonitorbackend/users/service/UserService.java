package com.galitianu.mealmonitorbackend.users.service;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityService;
import com.galitianu.mealmonitorbackend.users.mapper.UserMapper;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserEntity;
import com.galitianu.mealmonitorbackend.users.persistence.repository.UserRepository;
import com.galitianu.mealmonitorbackend.users.service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseEntityService<User, UserEntity> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void signUp(String firstName, String lastName, String email, String firebaseId){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setFirebaseId(firebaseId);

        save(user);
    }

    public User updateGoal(User user, Double weight, Double targetCalories, Double targetProteins, Double targetFats, Double targetCarbs, Double targetFibres){
        if(weight != null)
            user.setWeight(weight);
        if(targetCalories != null)
            user.setTargetCalories(targetCalories);
        if(targetProteins != null)
            user.setTargetProteins(targetProteins);
        if(targetFats != null)
            user.setTargetFats(targetFats);
        if(targetCarbs != null)
            user.setTargetCarbs(targetCarbs);
        if(targetFibres != null)
            user.setTargetFibres(targetFibres);

        return save(user);
    }

    public Optional<User> getUserByFirebaseId(String firebaseId){
        return userMapper.mapToModel(userRepository.getUserEntityByFirebaseId(firebaseId));
    }

    public Boolean existsEmail(String email){
        return userRepository.getUserEntityByEmail(email).isPresent();
    }

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

    @Override
    protected UserMapper getMapper() {
        return userMapper;
    }
}
