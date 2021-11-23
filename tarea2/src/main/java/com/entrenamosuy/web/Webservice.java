package com.entrenamosuy.web;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.PublicadorService;

public class Webservice {

    private static PublicadorService service;

    private static Publicador servicePort;

    public static Publicador getPort() {
        if (service == null) {
            String path = System.getProperty("user.home") + File.separator + ".serverrc";
            File config = new File(path);

            String host = null;
            String port = null;
            String webservicePath = null;

            try {
                FileInputStream is = new FileInputStream(config);
                Properties configProps = new Properties();
                configProps.load(is);

                host = configProps.getProperty("host", "localhost");
                port = configProps.getProperty("port", "9128");
                webservicePath = configProps.getProperty("path", "webservice");
            } catch (Exception e) {
                host = "localhost";
                port = "9128";
                webservicePath = "webservice";
            }

            String endpoint;

            if (webservicePath.startsWith("/"))
                endpoint = "http://" + host + ":" + port + webservicePath;
            else
                endpoint = "http://" + host + ":" + port + "/" + webservicePath;

            try {
                service = new PublicadorService(new URL(endpoint));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }

            servicePort = service.getPublicadorPort();
        }

        return servicePort;
    }
}
