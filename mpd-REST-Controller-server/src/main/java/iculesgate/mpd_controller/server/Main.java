package iculesgate.mpd_controller.server;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import iculesgate.mpd_controller.configuration.ConfigurationManager;
import org.slf4j.LoggerFactory;
import iculesgate.mpd_controller.REST.RESTServer;
import iculesgate.mpd_controller.database.DatabaseManager;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Main class.
 *
 */
public class Main {
    private static class ServerModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(ConfigurationManager.class);
            bind(RESTServer.class);
            bind(DatabaseManager.class).in(Singleton.class);
        }
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
        org.slf4j.Logger logger = LoggerFactory.getLogger(Class.forName("org.bff.javampd.Player"));
        if (logger != null && logger instanceof ch.qos.logback.classic.Logger) {
            //the slf4j Logger interface doesn't expose any configuration API's, but
            //we can cast to a class that does; so cast it and disable the logger
            ((ch.qos.logback.classic.Logger)logger).setLevel(
                    ch.qos.logback.classic.Level.OFF);
        }
        Injector injector = Guice.createInjector(new ServerModule());
        injector.getInstance(ConfigurationManager.class).loadConfiguration("config.properties");

        DatabaseManager manager = injector.getInstance(DatabaseManager.class);
        manager.init();
        injector.getInstance(RESTServer.class);
    }
}
