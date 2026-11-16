
package reports;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.io.IOException;

public class MyLogger {
     private static final Logger logger = Logger.getLogger(MyLogger.class.getName());

    static {
        try {
            
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            ConsoleHandler consoleHandler = new ConsoleHandler();

            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);

            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred in Logger setup", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
