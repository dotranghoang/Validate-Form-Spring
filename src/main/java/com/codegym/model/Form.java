package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Form implements Validator {
    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5,max = 45)
    private String lastName;

    @Min(18)
    private int age;

    @Email
    private String email;

    private String number;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Form.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Form form = (Form) target;
        String number = form.getNumber();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");

        if(number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number","number.length");
        }
        if(!number.startsWith("0")){
            errors.rejectValue("number","number.startsWith");
        }
        if(!number.matches("(^$[0-9]*$)")){
            errors.rejectValue("number","number.matches");
        }
    }
}
