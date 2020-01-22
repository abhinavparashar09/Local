package cucumberBase.driverFactory.managers;


import cucumberBase.helpers.ConfigReader.ConfigFileReader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getFileReaderManager() {

        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

}


