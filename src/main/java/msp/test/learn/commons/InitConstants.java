package msp.test.learn.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@Configuration
public class InitConstants {

    // OS NAMES
    private static final String WINDOWS = "windows";
    private static final String LINUX = "linux";
    private static final String MAC = "mac";
    private static final String HP_UX = "hp-ux";
    private static final String CONFIG_NAME = "Learn_Service.conf";
    private static final String BIN_DIR = "bin";
    private static String OS_PATH;
    File file;


    public static String testDbUrl , testDbUsername , testDbPassword  , driverClassName;

    private void checkOS() {
        String osName = System.getProperty("os.name");
        String filePath;

        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(WINDOWS, "");
        hashMap.put(LINUX, System.getProperty("catalina.base") + "/" + BIN_DIR);
        hashMap.put(MAC, System.getProperty("catalina.base") + "/" + BIN_DIR);
        hashMap.put(HP_UX, System.getProperty("catalina.base") + "/" + BIN_DIR);

        if (osName.toLowerCase().contains(WINDOWS)) {
            filePath = Paths.get("").toAbsolutePath().toString();
            OS_PATH = filePath + "/";
        } else if (osName.toLowerCase().contains(HP_UX) || osName.toLowerCase().contains(LINUX) || osName.toLowerCase().contains(MAC)) {
            filePath = hashMap.getOrDefault(osName.split(" ")[0], "");
            OS_PATH = filePath + "/" + BIN_DIR;
        } else {
            System.out.println("Sorry , this file is not supported for " + osName + " operating system");
            return;
        }

        file = Paths.get(filePath, CONFIG_NAME).toFile();
        System.out.println("File Name : "+file.getAbsolutePath());
    }

    @Bean
    public void readConfigFile() {
        checkOS();
        try{
            InputStream stream = new FileInputStream(file);
            ResourceBundle bundle  = new PropertyResourceBundle(stream);

            testDbUrl = bundle.getString("testDbUrl");
            testDbUsername = bundle.getString("testDbUserName");
            testDbPassword = bundle.getString("testDbPassword");
            driverClassName = bundle.getString("driverClassName");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
