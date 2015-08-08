package com.liango.designpattern.create.danli;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author liango
 * @version 1.0
 * @since 2015-08-08 21:43
 */
public class OracleConfig {

    private static Properties properties;

    static {
        properties = new Properties();
        String path = null;
        try {
            path = OracleConfig.class.getResource("/").toURI().getPath();
            System.out.println("path = " + path);

            properties.load(new FileReader(path + "oracle.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDriverClassName() {
        return properties.getProperty("jdbc.driverClassName");
    }

    public String getUrl() {
        return properties.getProperty("jdbc.url");
    }

    public String getUsername() {
        return properties.getProperty("jdbc.username");
    }

    public String getPassword() {
        return properties.getProperty("jdbc.password");
    }

    public static void main(String[] args) {
        OracleConfig oracleConfig = new OracleConfig();
        String driverClassName = oracleConfig.getDriverClassName();
        String url = oracleConfig.getUrl();
        String username = oracleConfig.getUsername();
        String password = oracleConfig.getPassword();

        System.out.println("driverClassName = " + driverClassName);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        OracleConfig oracleConfig2 = new OracleConfig();
        driverClassName = oracleConfig2.getDriverClassName();
        url = oracleConfig2.getUrl();
        username = oracleConfig2.getUsername();
        password = oracleConfig2.getPassword();

        System.out.println("driverClassName = " + driverClassName);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}

