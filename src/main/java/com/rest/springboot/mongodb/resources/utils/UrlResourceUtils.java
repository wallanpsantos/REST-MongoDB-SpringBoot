package com.rest.springboot.mongodb.resources.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlResourceUtils {

    /**
     * Metodo resposanvel por realizar a codificação de um parametro
     *
     * @param url
     * @return
     */
    public static String encodificarParametro(String url) {
        return URLEncoder.encode(url, StandardCharsets.UTF_8);
    }

    public static String decondificarParametro(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }
}
