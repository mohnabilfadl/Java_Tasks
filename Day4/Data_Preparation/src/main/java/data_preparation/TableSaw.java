
package data_preparation;

import java.io.IOException;
import java.util.List;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;




public class TableSaw {
    
    public static void main(String[] args) {
        Table df = null;
        
        try{
            df = Table.read().csv("files\\titanic.csv");
            //perform some data exploration activities:
            System.out.println("#Structure of Titanic data:\n"+df.structure());
            System.out.println("\n");
            System.out.println("#Summary of Titanic data:\n"+df.summary());
            System.out.println("\n");
            //Create a new column from the "home.dest" column and add it to the table:
            StringColumn col = StringColumn.create("from / to",(List<String>) df.column("home.dest").asList());
            df.insertColumn(3, col);
            System.out.println("#View of modified data :\n"+df.first(5));
                
        }catch(IOException e){
            e.printStackTrace();
        }
        }
        
    }
