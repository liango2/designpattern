package com.liango.designpattern.create.danli;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author liango
 * @version 1.0
 * @since 2015-08-08 22:23
 */
public class OracleSingleton {
    private static OracleSingleton oracleSingleton = new OracleSingleton();
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

    private OracleSingleton() {
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


    public static OracleSingleton getOracleSingleton(){
        return oracleSingleton;
    }
    public static void main(String[] args) {
        OracleSingleton oracleSingleton = OracleSingleton.getOracleSingleton();
        String driverClassName = oracleSingleton.getDriverClassName();
        String url = oracleSingleton.getUrl();
        String username = oracleSingleton.getUsername();
        String password = oracleSingleton.getPassword();

        System.out.println("driverClassName = " + driverClassName);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        OracleSingleton oracleSingleton2 = OracleSingleton.getOracleSingleton();
        driverClassName = oracleSingleton2.getDriverClassName();
        url = oracleSingleton2.getUrl();
        username = oracleSingleton2.getUsername();
        password = oracleSingleton2.getPassword();

        System.out.println("driverClassName = " + driverClassName);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

    }
}
