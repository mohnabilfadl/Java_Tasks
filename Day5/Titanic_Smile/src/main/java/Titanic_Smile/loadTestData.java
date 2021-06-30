
package Titanic_Smile;

import static Titanic_Smile.encodeColumn.encodeColumn;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.data.vector.IntVector;
import smile.data.vector.StringVector;
import smile.io.Read;


public class loadTestData {
    
     public static DataFrame loadTestData(String filePath) {
    	CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ().withDelimiter(',');
    	DataFrame df = null;
    	
    	try {
			df = Read.csv(filePath, format);
			df = df.select("Pclass", "Age", "Sex");
			System.out.println(df.structure());
			df = df.merge(IntVector.of("SexEncoded", encodeColumn(df, "Sex")));
			//Pclass is an int column, we'll change it to string column in order to perform the same encoding we did in the traing data
			df = df.merge(StringVector.of("pClassString", df.intVector("Pclass").toStringArray()));
			df = df.merge(IntVector.of("PClassEncoded", encodeColumn(df, "pClassString")));
	        df = df.drop ("Sex", "Pclass", "pClassString");
	        df = df.omitNullRows();
			System.out.println(df.structure());
			System.out.println(df.summary());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
    	
    	return df;
    }


}
