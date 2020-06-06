package com.bookit.units;

import com.bookit.utilities.APIUtilities;
import com.bookit.utilities.Environment;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import org.junit.Test;

public class APIUtilitiesUnitTests {
    @Test
    public void getTokenTest(){
        String token = APIUtilities.getToken();
        String token2 =APIUtilities.getToken("student");
        String token3 = APIUtilities.getToken("teacher");

        Assert.assertNotNull(token);
        Assert.assertNotNull(token3);
        Assert.assertNotNull(token2);
    }
//    @Test
//    public void testIfUserExists(){
//        int id =APIUtilities.getUserID("fdssdfsf@email.com","1221232");
//        Assert.assertEquals(-1,id);
//    }
    @Test
    public void testIfUserExists(){
        int actual = APIUtilities.getUserID("thereisnoemaillikethis@email.com", "123123");
        Assert.assertEquals(-1, actual);//negative test

        int actual2 = APIUtilities.getUserID(Environment.MEMBER_USERNAME, Environment.MEMBER_PASSWORD);
        //positive test
        Assert.assertTrue(actual2 > 0);//if ID is positive - user exists indeed, otherwise it return -1
    }
}
