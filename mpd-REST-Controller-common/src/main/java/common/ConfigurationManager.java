package common;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.*;
import java.util.Properties;

/**
 * Created by icule on 26/02/17.
 */
@Singleton
public class ConfigurationManager {
    private String authToken;
    private String url;
    private String port;

    @Inject
    public ConfigurationManager() throws IOException {
    }

    public void loadConfiguration(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));

        authToken = properties.getProperty("authToken");
        url = properties.getProperty("url");
        port = properties.getProperty("port");
    }

    public String getAuthToken(){
        return authToken;
    }

    public String getCompleteUrl(){
        return url + ":" + port;
    }
}