
package Titanic_Smile;

import smile.data.DataFrame;
import smile.data.measure.NominalScale;


public class encodeColumn {
    
    public static int[] encodeColumn(DataFrame df, String columnName) {
    	String[] categories = df.stringVector(columnName).distinct().toArray(new String[0]);
    	int[] encoded = df.stringVector(columnName).factorize(new NominalScale(categories)).toIntArray();
    	return encoded;
    }
}
