package hico.group.assesment.demo.logs;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import hico.group.assesment.demo.utils.Utils;

public class Log {
    private final Utils utils = new Utils();
    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());
    private static FileHandler file;

    public void log(Level level, String message) {
        try {
            File logFile = new File(utils.dirname() + "/info.log");
            if (!logFile.exists())
                logFile.createNewFile();
            file = new FileHandler(utils.dirname() + "/info.log");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        LOGGER.addHandler(file);
        SimpleFormatter formatter = new SimpleFormatter();
        file.setFormatter(formatter);
        LOGGER.log(Level.INFO, message);
    }

    public void error(String message) {
        try {
            File logFile = new File(utils.dirname() + "/error.log");
            if (!logFile.exists())
                logFile.createNewFile();
            file = new FileHandler(utils.dirname() + "/error.log");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        LOGGER.addHandler(file);
        SimpleFormatter formatter = new SimpleFormatter();
        file.setFormatter(formatter);
        LOGGER.log(Level.SEVERE, message);
    }
}
