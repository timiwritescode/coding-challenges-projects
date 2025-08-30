package com.codingchallenges.curl;


import com.codingchallenges.curl.exceptions.BaseException;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger("curl");
    public static void main(String[] args)  {
        try {
            Url url = UrlParser.parse("http//localhost:2334/api/ad");

            System.out.println(url.toString());
        } catch (BaseException e) {
            logger.setLevel(Level.SEVERE);
            logger.severe(e.getMessage());
            System.exit(1);
        }


    }
}
