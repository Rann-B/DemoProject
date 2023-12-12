package util;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.String.format;
import static util.readers.PropertiesReader.getProperty;

@UtilityClass
public final class ConfigurationProvider {

    private final String ENVIRONMENT_PATH = "src/test/resources/environment.properties";
    private static final String ALLURE_RESULTS_PATH = "allure-results/environment.properties";
    private final String DRIVER = "Driver: %s \n";
    private final String DRIVER_VERSION = "VersionRequested: %s \n";
    private final String OS_NAME = "OSName: %s \n";
    private final String OS_VERSION = "OSVersion: %s \n";
    private final String OS_ARCH = "OSArch: %s \n";
    private final String JAVA_VERSION = "JavaVersion: %s \n";
    private final String DRIVER_PROPERTY = "browser.type";
    private final String DRIVER_VERSION_PROPERTY = "browser.version";
    private final String OS_NAME_PROPERTY = "os.name";
    private final String OS_VERSION_PROPERTY = "os.version";
    private final String OS_ARCH_PROPERTY = "os.arch";
    private final String JAVA_VERSION_PROPERTY = "java.version";


    public static void setUiConfiguration() {

        try {
            FileWriter fileWriter = new FileWriter(ENVIRONMENT_PATH);
            fileWriter.write(format(DRIVER, getProperty(DRIVER_PROPERTY)));
            fileWriter.write(format(DRIVER_VERSION, getProperty(DRIVER_VERSION_PROPERTY)));
            fileWriter.write(format(OS_NAME, System.getProperty(OS_NAME_PROPERTY)));
            fileWriter.write(format(OS_VERSION, System.getProperty(OS_VERSION_PROPERTY)));
            fileWriter.write(format(OS_ARCH, System.getProperty(OS_ARCH_PROPERTY)));
            fileWriter.write(format(JAVA_VERSION, System.getProperty(JAVA_VERSION_PROPERTY)));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileToAllureResults() {
        try {
            File sourceFile = new File(ENVIRONMENT_PATH);
            File destinationFile = new File(ALLURE_RESULTS_PATH);
            destinationFile.getParentFile().mkdirs();
            java.nio.file.Files.copy(sourceFile.toPath(), destinationFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

