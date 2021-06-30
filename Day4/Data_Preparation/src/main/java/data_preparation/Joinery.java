
package data_preparation;

import java.io.IOException;
import java.util.List;
import joinery.DataFrame;



public class Joinery {
    
    public static void main(String[] args) {
        
        try{
            DataFrame<Object> df = DataFrame.readCsv("files\\titanic.csv");
            DataFrame<Object> df2 = DataFrame.readCsv("files\\titanic.csv");
            System.out.println("#Summary of Titanic data:\n"+df.describe());

            //merging and manipulating columns:
            df2 = df.retain("pclass", "survived", "name");
            System.out.println("#View of original data in df2:\n"+df2.head(3));
            System.out.println("\n");
            
            //Merging dataframes together:
            df2 = df.retain("ticket", "survived", "name");
            DataFrame<Object> dfMerged = df.merge(df2);
            System.out.println("#Merged data:\n"+dfMerged.head(10));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
