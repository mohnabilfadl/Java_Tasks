/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class PyramidCSVDAO {
    
    public List<Pyramid> readPyramidsFromCSV(String fileName){
        
        List<Pyramid> pyramids = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
       
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            // read the header line from the  file
            boolean firstLine = true;
            String line = null;
            // loop until all lines are read
            while (( line = br.readLine()) != null) {
                   if (firstLine) {
                         firstLine = false;
                         continue;
               }
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Pyramid pyramid = createPyramid(attributes);

                // adding book into ArrayList
                pyramids.add(pyramid);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
        }

        return pyramids;
    }

    public  Pyramid createPyramid(String[] metadata){
        String  pharaoh = metadata[0];
        String modern_name = metadata[2];
        String site = metadata[4];
        double height = Double.parseDouble(metadata[7]);
        
        // create and return pyramid of this metadata
        return new Pyramid(pharaoh, modern_name, site, height);
      
    }}
    
    


