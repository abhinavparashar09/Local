package cucumberBase.picoHelper;

public class MySharedData {
    private static MySharedData mySharedData;
    public String[] QUERYIDs;
    public String[] PRODUCTIDs;
    public String[] PRODUCTCODENAME;
    public String PRODUCTCODE;

    public String[] UPDATERESULT1 = new String[2];
    public String[] UPDATERESULT2 = new String[2];

    public MySharedData() {

    }

    public static MySharedData getInstance() {
        if (mySharedData == null) {
            mySharedData = new MySharedData();
        }
        return mySharedData;
    }
}
