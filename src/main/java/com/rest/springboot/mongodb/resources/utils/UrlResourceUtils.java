package com.rest.springboot.mongodb.resources.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UrlResourceUtils {

    /**
     * Metodo resposanvel por realizar a codificação de um parametro
     *
     * @param url
     * @return URLEncoder.encode
     */
    public static String encodificarParametro(String url) {
        return URLEncoder.encode(url, StandardCharsets.UTF_8);
    }

    /**
     * Metodo responsavel por realizar a decodificação do parametro
     * para UTF-8
     *
     * @param url
     * @return URLDecoder.decode
     */
    public static String decondificarParametro(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }

    /**
     * Metodo responsavel por converter data passada no parametro
     *
     * @param data
     * @param dataPadrao
     * @return
     */
    public static Date converteData(String data, Date dataPadrao) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return simpleDateFormat.parse(data);
        } catch (ParseException e) {
            return dataPadrao;
        }
    }
}
