package ua.univer.Task10.test;

import ua.univer.Task10.User;
import ua.univer.Task10.UserKMDAHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class testUserKMDAHelper {
    UserKMDAHelper helper;
    List<User> users;

    @BeforeEach
    void testSetUp(){
        helper = new UserKMDAHelper();
        users = new ArrayList<>();
        users = helper.getUserFromURL();
    }

    @Test
    void testMaxSalary(){
        Assertions.assertEquals(17760.0, helper.maxSalary(users));
    }

    @Test
    void testBiggestSalary(){
        Assertions.assertEquals("March - 13865.75", helper.biggestSalary());
    }
}
