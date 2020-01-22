package cucumberBase.helpers.resourceHelper;


public class ResourceHelper {
    private static ResourceHelper resourceHelper = new ResourceHelper();

    // method to create relative path of any resource / file / property

    public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        return basePath + path;

    }
}
