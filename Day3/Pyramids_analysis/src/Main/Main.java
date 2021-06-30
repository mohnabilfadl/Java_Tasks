package Main;

import java.util.List;
import java.util.stream.Collectors;

import DataOperations.Pyramid;
import DataOperations.PyramidCSVDAO;

public class Main {

	public static void main(String[] args) {
		PyramidCSVDAO pDAO = new PyramidCSVDAO();
		List<Pyramid> pyramids =  pDAO.readPyramidsFromCSV("files\\pyramids.csv");
		
		//Get a sorted list of pyramid heights, and remove any missing heights(missing heights have a value of (-1))
		List<Double> heights = pyramids.stream().map(p -> p.getHeight()).filter(height-> height !=-1).sorted().collect(Collectors.toList());
		
		double median,lowerQuartile,upperQuartile;
		
		int i = heights.size()/2;
		if (heights.size()%2 ==0) {
			 median = (heights.get(i)+heights.get(i+1))/2;
		}else {
			median = heights.get(i);
		}
		lowerQuartile = (heights.get(i/2)+heights.get((i+1)/2))/2;
		upperQuartile = (heights.get(3*i/2)+heights.get(3*(i+1)/2))/2;
		
		System.out.println("Median Height="+median+
                                                            "\nLower Quartile Height="+lowerQuartile+
                                                            "\nUpper Quartile Height="+upperQuartile);
	}

}

