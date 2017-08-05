package server.REST;

import common.ConfigurationManager;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import server.MPDClient;
import server.database.DatabaseManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by icule on 25/03/17.
 */
@Singleton
public class RESTServer {
    private HttpServer server;

    @Inject
    public RESTServer(ConfigurationManager configurationManager, MPDClient mpdClient, DatabaseManager databaseManager){
        final ResourceConfig rc = new ResourceConfig().packages("server.REST");
        Map<String, Object> config = new HashMap<>();
        config.put("authToken", configurationManager.getAuthToken());
        config.put("mpdClient", mpdClient);
        config.put("database", databaseManager);
        rc.addProperties(config);
        this.server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://" + configurationManager.getCompleteUrl()), rc);
    }
}