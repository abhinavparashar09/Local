package cucumberBase.helpers.dataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public String readString(String filePath) throws IOException {
        // Read data from CSV file.
        FileReader fr = new FileReader(new File(filePath));
        BufferedReader br = new BufferedReader(fr);
        String productCode = "";
        String lines;
        int lineNumber = 0;
        while ((lines = br.readLine()) != null) {
            lineNumber++;
            if (lineNumber == 2) {
                String[] line1 = lines.split(",", 2);
                //only need to extract product code
                productCode = line1[0];
                break;
            }
        }
        fr.close();
        br.close();
        return productCode;
    }
}


