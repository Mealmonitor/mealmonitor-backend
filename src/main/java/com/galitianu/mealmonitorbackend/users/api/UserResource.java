package com.galitianu.mealmonitorbackend.users.api;

import com.galitianu.mealmonitorbackend.common.api.BaseResource;
import com.galitianu.mealmonitorbackend.users.api.dto.NewUserDto;
import com.galitianu.mealmonitorbackend.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserResource extends BaseResource {
    private final UserService userService;
    @PostMapping()
    public ResponseEntity<Void> signUp(@RequestBody NewUserDto newUserDto){
        if(userService.existsUser(newUserDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.signUp(newUserDto.getFirstName(), newUserDto.getLastName(), newUserDto.getEmail(), newUserDto.getPassword(), newUserDto.getGender());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
