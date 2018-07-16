package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Manager {
    /**
     * @param request HttpServletRequest
     * @return boolean
     */
    private static boolean isUserValid(HttpServletRequest request) {
        String email = String.valueOf(request.getSession().getAttribute("email"));
        String password = String.valueOf(request.getSession().getAttribute("password"));

        return QueryBuilder.isUserValid(email, password);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException from HttpServletRequest::sendRedirect
     */
    public static boolean isUserValid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!Manager.isUserValid(request)) {
            request.getSession().setAttribute("flash_danger", "Vous devez être connectés");
            response.sendRedirect("/login");

            return false;
        }

        return true;
    }

    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_VIA");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getCurrentUrl(HttpServletRequest request) {
        try {
            URL url = new URL(request.getRequestURL().toString());

            return url.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getCurrentUri(HttpServletRequest request) {
        try {
            URL url = new URL(request.getRequestURL().toString());
            String host = url.getHost();
            String userInfo = url.getUserInfo();
            String scheme = url.getProtocol();
            int port = url.getPort();
            String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
            String query = (String) request.getAttribute("javax.servlet.forward.query_string");

            URI uri = new URI(scheme, userInfo, host, port, path, query, null);

            return uri.toString();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getCurrentBaseUrl(HttpServletRequest request) {
        try {
            URL url = new URL(request.getRequestURL().toString());
            String host = url.getHost();
            String userInfo = url.getUserInfo();
            String scheme = url.getProtocol();
            int port = url.getPort();
            URI uri = new URI(scheme, userInfo, host, port, null, null, null);

            return uri.toString();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCaptcha() {
        return "kamal";
    }
}
