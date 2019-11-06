package com.digitalworkspace.lambdaexceptions;

import com.digitalworkspace.lambdaexceptions.exceptions.ServiceException;
import org.junit.Test;

import java.net.MalformedURLException;

public class ChallengeAndSolutionsTest {

    @Test(expected = ServiceException.class)
    public void test1ThrowServiceException() {
        ChallengeAndSolutions.test1();
    }

    @Test(expected = ServiceException.class)
    public void test2ThrowServiceException() {
        ChallengeAndSolutions.test2();
    }

    @Test(expected = MalformedURLException.class)
    public void test3ThrowServiceException() {
        ChallengeAndSolutions.test3();
    }

    @Test(expected = ServiceException.class)
    public void test4ThrowServiceException() {
        ChallengeAndSolutions.test4();
    }

    @Test(expected = MalformedURLException.class)
    public void test5ThrowServiceException() {
        ChallengeAndSolutions.test5();
    }

    @Test(expected = MalformedURLException.class)
    public void test6ThrowServiceException() {
        ChallengeAndSolutions.test6();
    }

    @Test(expected = MalformedURLException.class)
    public void test7ThrowServiceException() {
        ChallengeAndSolutions.test7();
    }
}
