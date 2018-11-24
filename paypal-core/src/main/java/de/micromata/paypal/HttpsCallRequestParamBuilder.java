package de.micromata.paypal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpsCallRequestParamBuilder {
    private Logger log = LoggerFactory.getLogger(HttpsCall.class);

    private StringBuilder sb = new StringBuilder();
    private boolean first = true;

    HttpsCallRequestParamBuilder add(String param, Object value) {
        if (value == null) {
            return this;
        }
        return add(param, value.toString());
    }


    HttpsCallRequestParamBuilder add(String param, String value) {
        if (value == null || value.length() == 0) {
            return this;
        }
        try {
            String encodedParam = URLEncoder.encode(param, "UTF-8");
            String encodedValue = URLEncoder.encode(value, "UTF-8");
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            sb.append(encodedParam).append("=").append(encodedValue);
        } catch (UnsupportedEncodingException ex) {
            log.error("Internal error: " + ex.getMessage(), ex);
        }
        return this;
    }

    public String createUrl(String url) {
        if (sb.length() == 0) {
            return url;
        }
        char ch = url.indexOf('?') > 0 ? '&' : '?';
        return url + ch + sb.toString();
    }
}
