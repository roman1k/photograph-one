package com.example.photographone.components;

import com.example.photographone.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> auterUser) {
        return User.class.equals(auterUser);
    }

    @Override
    public void validate(Object user, Errors errors) {
            User u = (User) user;
            if (u.getUsername().isEmpty()){
                errors.rejectValue("username", "name.empty", "enter your name");
            }
    }

}
