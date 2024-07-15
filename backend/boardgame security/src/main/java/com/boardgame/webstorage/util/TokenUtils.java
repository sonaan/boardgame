package com.boardgame.webstorage.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * This class retrieves user id by token string
 *
 * @author ybogdano
 */
public class TokenUtils {
    private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);
    private static final String ENCODED_VALUE = "some_string_for_encoding";

    public static int getUserIdFromToken(Map<String, String> header) {
        final String authHeader = header.get("authorization");
        final String token = authHeader.substring(7);

        try {
            final Claims claims = Jwts.parser().setSigningKey(TokenUtils.getEncodedValue()).parseClaimsJws(token).getBody();
            int id = Integer.parseInt((String) claims.get("sub"));
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getEncodedValue() {
        return ENCODED_VALUE;
    }

}
