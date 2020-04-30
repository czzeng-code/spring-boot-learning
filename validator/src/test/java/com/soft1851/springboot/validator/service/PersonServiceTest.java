package com.soft1851.springboot.validator.service;

import com.soft1851.springboot.validator.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.validation.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Resource
    private PersonService personService;

    @Test
    @ExceptionHandler(ConstraintViolationException.class)
    void validatePerson() {
        Person person = new Person();
        person.setId("123456");
        person.setName("Soft1851");
        person.setAge(11);
        person.setPhone("13800001111");
        person.setEmail("Soft1851@qq.com");
        person.setSex("男");
        personService.validatePerson(person);
    }

    @Test
    void checkManually() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Person person = new Person();
        person.setId("123");
        person.setSex("Man22");
        person.setEmail("abc");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> constraintViolation: violations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}