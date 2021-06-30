
package Titanic_Smile;

import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.io.Read;


public class readCSV {
    
    public static DataFrame readCSV(String filePath) throws URISyntaxException {
    	CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ().withDelimiter(',');
    	DataFrame df = null;
    	
    	try {
			df = Read.csv(filePath, format);
			df = df.select("Pclass", "Age", "Sex", "Survived");
			System.out.println(df.summary());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
  
    	return df;
    }
}
