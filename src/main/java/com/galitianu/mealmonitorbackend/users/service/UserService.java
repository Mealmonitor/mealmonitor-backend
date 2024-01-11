package com.galitianu.mealmonitorbackend.users.service;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityService;
import com.galitianu.mealmonitorbackend.users.mapper.UserMapper;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserEntity;
import com.galitianu.mealmonitorbackend.users.persistence.repository.UserRepository;
import com.galitianu.mealmonitorbackend.users.service.model.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService extends BaseEntityService<User, UserEntity> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final Keycloak keycloak;

    public User signUp(String firstName, String lastName, String email, String password, Boolean gender){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);


        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmail(email);
        userRepresentation.setFirstName(firstName);
        userRepresentation.setLastName(lastName);
        userRepresentation.setEnabled(true);

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        credential.setTemporary(false);
        userRepresentation.setCredentials(Collections.singletonList(credential));

        // Create the new user in Keycloak
        RealmResource realmResource = keycloak.realm("mealmonitor");
        UsersResource usersResource = realmResource.users();
        usersResource.create(userRepresentation);

        return save(user);
    }

    public Boolean existsUser(String email){
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
