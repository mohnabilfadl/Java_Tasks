package Titanic_Smile;

import static Titanic_Smile.encodeColumn.encodeColumn;
import static Titanic_Smile.loadTestData.loadTestData;
import static Titanic_Smile.readCSV.readCSV;
import java.io.IOException;
import java.net.URISyntaxException;
import smile.classification.RandomForest;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.vector.IntVector;
        


public class main {
    
    public static void main( String[] args ) throws IOException, URISyntaxException
    {
        DataFrame trainData = readCSV("files/titanic_train.csv");
        System.out.println("Training Data information: \n" + trainData.structure());
        System.out.println("Statistical Summary: \n"+ trainData.summary());
        
        
        System.out.println("Encoding Non Numeric Data");
        trainData = trainData.merge(IntVector.of("SexEncoded", encodeColumn(trainData, "Sex")));
        trainData = trainData.merge(IntVector.of("PClassEncoded", encodeColumn(trainData, "Pclass")));
        System.out.println("Training Data information (After encoding): \n" + trainData.structure());

        System.out.println("Dropping the non-encoded columns and the Name column");
        trainData = trainData.drop ("Pclass", "Sex");
        System.out.println (trainData.structure ());

        System.out.println("Omitting null Rows");
        trainData = trainData.omitNullRows();
        System.out.println("Statistical Summary: \n"+ trainData.summary ());
        
        System.out.println("Training Random Forest model");
        RandomForest model = RandomForest.fit(Formula.lhs("Survived"), trainData);
        System.out.println("Model Metrics: \n" + model.metrics ());
        
        System.out.println("Preparing the testing data");
        DataFrame testData = loadTestData("files/titanic_test.csv");
        int[] result = model.predict(testData);
        for (int i:result) {
        	System.out.print(i);
        }
    }
}
