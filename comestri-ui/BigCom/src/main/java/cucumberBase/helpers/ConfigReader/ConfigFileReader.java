package cucumberBase.helpers.ConfigReader;


import cucumberBase.driverFactory.enums.DriverType;
import cucumberBase.driverFactory.enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final String propertyFilePath = "src/main/resources/configurations/config.properties";
    private Properties properties;


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            //reader = new BufferedReader(new FileReader(propertyFilePath));
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    // This method will be used to get browser name from the config property file
    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public Long getImplicitWait() {
        String implicitWait = properties.getProperty("implicitWait");
        if (implicitWait != null) {
            return Long.parseLong(implicitWait);
        } else throw new RuntimeException("implicit wait is not specified in the configuration.properties file");
    }

    // This method will be used to get environement name from  config property file
    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local"))
            return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote"))
            return EnvironmentType.REMOTE;
        else
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    // This method will be used to get driver path if we do not use webdriver manager pom dependency
    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null)
            return driverPath;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }


    public Boolean getWindowSize() {
        String windowSize = System.getProperty("windowMaximize");
        if (windowSize != null)
            return Boolean.valueOf(windowSize);
        return true;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public String getHeartBeatUrl() {
        String url = properties.getProperty("UrlHB");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public String getComestriUrl() {
        String url = properties.getProperty("UrlCM");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public String getOMHB() {
        String url = properties.getProperty("UrlOMHB");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public String getProductManager() {
        String url = properties.getProperty("UrlPM");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public String getManageJob() {
        String url = properties.getProperty("UrlManageJob");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public String getNSP() {
        String url = properties.getProperty("UrlNSP");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }
}
