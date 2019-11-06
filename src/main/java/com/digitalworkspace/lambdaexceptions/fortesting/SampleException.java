package com.digitalworkspace.lambdaexceptions.fortesting;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleException {

    // The exception
    public static URL createURL(String url) throws MalformedURLException {
        return new URL(url);
    }
}
