import DataOperations.Pyramid;
import DataOperations.PyramidCSVDAO;
import java.util.List;



public class PyramidsMain {
    /**
     *
     * @param args
     */
    public static void main(String[] args)  {   
        
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("files\\pyramids.csv");
                
        // let's print all the person read from CSV file
        int i=0;
        for (Pyramid p : pyramids) {
            System.out.println("#" + (i++) + p);
        }
      
      
    
}}
