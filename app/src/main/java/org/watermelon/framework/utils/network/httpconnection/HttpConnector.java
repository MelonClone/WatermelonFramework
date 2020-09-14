package org.watermelon.framework.utils.network.httpconnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class HttpConnector {
    private static final String TAG = "HttpConnector";

    public static void setForceHttp(URL url) throws GeneralSecurityException {

        /* 프로토콜이 HTTPS일 경우 서버쪽 인증서를 신뢰할 수 있도록 처리 */
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] arg0,
                    String arg1) throws CertificateException {
                // TODO Auto-generated method stub
            }
            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] arg0,
                    String arg1) throws CertificateException {
                // TODO Auto-generated method stub
            }
        } };

        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            throw (GeneralSecurityException) e;
        } catch (KeyManagementException e) {
            throw (GeneralSecurityException) e;
        }

        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        final HostnameVerifier defaultVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                if (hostname.equals(url.getHost()))
                    return true;
                else {
                    return defaultVerifier.verify(hostname, session);
                }
            }
        });
    }

    enum HttpMethod { GET, POST, DELETE, PUT }

    public static HttpURLConnection post(HttpMethod method, String serverUrl) {
        try {
            URL url = new URL(serverUrl);

            if (url.getProtocol().toLowerCase().equals("https")) {
                // TODO set force url
                // setForceHttp(url);
            }

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod(method.name());
            conn.setConnectTimeout(1000 * 20);
            conn.setReadTimeout(1000 * 20);
            //conn.setConnectTimeout(1000 * 60 * 60);
            //conn.setReadTimeout(1000 * 60 * 60);
            conn.setRequestProperty("Cache-Control", "no-cache");

            return conn;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean disconnect(HttpURLConnection conn) {
        if (conn != null) {
            conn.disconnect();
        }

        return true;
    }
}

