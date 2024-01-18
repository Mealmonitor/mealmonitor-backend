package com.galitianu.mealmonitorbackend.users.api;

import com.galitianu.mealmonitorbackend.common.api.BaseResource;
import com.galitianu.mealmonitorbackend.users.api.dto.GoalDto;
import com.galitianu.mealmonitorbackend.users.api.dto.NewUserDto;
import com.galitianu.mealmonitorbackend.users.api.dto.UserDto;
import com.galitianu.mealmonitorbackend.users.mapper.UserMapper;
import com.galitianu.mealmonitorbackend.users.service.UserService;
import com.galitianu.mealmonitorbackend.users.service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserResource extends BaseResource {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> signUp(@RequestBody NewUserDto newUserDto){
        if(userService.existsEmail(newUserDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.signUp(newUserDto.getFirstName(), newUserDto.getLastName(), newUserDto.getEmail(), newUserDto.getFirebaseId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/name")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> getFirstName(@PathVariable String userId) {
        Optional<User> optionalUser = userService.getUserByFirebaseId(userId);
        if(optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalUser.get().getFirstName(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/goal")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserDto> setGoal(@RequestBody GoalDto goalDto, @PathVariable String userId){
        Optional<User> optionalUser = userService.getUserByFirebaseId(userId);
        if(optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userMapper.mapToDto(userService.updateGoal(optionalUser.get(), goalDto.getWeight(), goalDto.getTargetCalories(), goalDto.getTargetProteins(), goalDto.getTargetFats(), goalDto.getTargetCarbs(), goalDto.getTargetFibres())), HttpStatus.OK);
    }

    @GetMapping("/{userId}/goal")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<GoalDto> getGoal(@PathVariable String userId){
        Optional<User> optionalUser = userService.getUserByFirebaseId(userId);
        if(optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userMapper.mapToGoal(optionalUser.get()), HttpStatus.OK);
    }
}
