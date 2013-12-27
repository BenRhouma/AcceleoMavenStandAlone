package com.sofrecom.codegen.launcher;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author z.benrhouma
 */
public class Configuration {

    private static final Properties properties = new Properties();
    public static final String ConfigurationPathFile = "./conf.properties";
    public static final String XMLTemplate = "./generatorConfig.xml";
    public static final String TargetProjectPathField = "TARGET_PROJECT";
    public static final String JavaModelTargetPathField = "JAVA_MODEL_TARGET_PACKAGE";
    public static final String JavaClientTargetPathField = "JAVA_CLIENT_TARGET_PACKAGE";
    public static final String JDBCDriverPathField = "JDBC_DRIVER_JAR_PATH";
    public static final String DataBaseCnxUrl = "JDBC_URL";
    public static final String JdbcDriver = "JDBC_DRIVER";
    public static final String DBUser = "DB_USER";
    public static final String DBPassword = "DB_PASSWORD";
    // UI Properties
    public static final String LastUsedOutputpath = "LAST_USED_OUTPUT_PATH";
    public static final String LastUsedTableName = "LAST_USED_TABLE_NAME";
    public static final String LastUsedClassPath = "LAST_USED_CLASS_PATH";


    static Component LogComponent;

    public Configuration(Component pareComponent) {

    }

    /**
     * Get the parent caller Class (it should be a swing component) the
     * component
     *
     * @return
     */
    public static Component getLogCompoenent() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        try {
            final String ClassNameName = stackTrace[2].getClassName();
            final Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(ClassNameName);
            final Method method = loadClass.getMethod("getTopComponent");
            return (Component) method.invoke(null);

        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void loadConfiguration() {

        try {
            try (FileInputStream fis = new FileInputStream(new File(ConfigurationPathFile))) {
                properties.load(fis);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(getLogCompoenent(), ex.getMessage(), ConfigurationPathFile, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(getLogCompoenent(), ex.getMessage(), ConfigurationPathFile, JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void saveConfiguration() {
        try {
            try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    new FileOutputStream(new File(ConfigurationPathFile)),
                    Charset.forName("UTF-8").newEncoder())) {
                properties.store(outputStreamWriter, null);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(LogComponent, ex.getMessage(), ConfigurationPathFile, JOptionPane.ERROR_MESSAGE);
        }

    }

    public static String getProperty(String property) {
        if (properties == null) {
            loadConfiguration();
        }
        final Object object = properties.get(property);
        if (object != null) {
            return object.toString();
        }
        return "";
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

}
