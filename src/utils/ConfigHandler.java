package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Crunchify.com
 */

public class ConfigHandler {

    private static MySQL database = null;

    /**
     * @return Properties
     * @throws IOException file not found
     */
    public Properties getConfig() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File configFile = new File(Objects.requireNonNull(classLoader.getResource("config.properties")).getFile());
        FileReader reader = new FileReader(configFile);
        Properties props = new Properties();
        props.load(reader);
        reader.close();

        return props;
    }

    public static MySQL getDatabase() {
        if (null == ConfigHandler.database) {
            try {
                ConfigHandler.database = new MySQL();
                ConfigHandler.database.connect();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        return ConfigHandler.database;
    }

    public static void setDatabase(MySQL database) {
        ConfigHandler.database = database;
    }

    public static Properties getStaticConfig() throws IOException {
        return init().getConfig();
    }

    public static ConfigHandler init() {
        return new ConfigHandler();
    }
}
