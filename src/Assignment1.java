import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 
 */

/**
 * @author Suleyman Gursoy
 *
 */
public class Assignment1 {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		String csvFile = args[0];
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] header = null;
        int featureIndex = Integer.parseInt(args[1]);
        ArrayList<String[]>allData = new ArrayList<String[]>();
        boolean saveOrNot;
        
        if(args[2].equals("T")) saveOrNot = true;
        else{saveOrNot = false;}
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            header = (br.readLine()).split(cvsSplitBy);
            
            while ((line = br.readLine()) != null) {
            	// use comma as separator
                String[] data = line.split(cvsSplitBy);
                allData.add(data);
             }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        featureIndex = featureIndex--;
        
        quickSort sorter = new quickSort();
        long startTimeQuick = System.currentTimeMillis();
        ArrayList<String[]>  sortedList2 = sorter.sort(allData, featureIndex);
        long stopTimeQuick = System.currentTimeMillis();
        //System.out.println(stopTimeQuick-startTimeQuick);
        /*
        insertionSort notSorted = new insertionSort();
        long startTimeInsertion = System.currentTimeMillis();
        ArrayList<String[]> sorted = notSorted.sort(allData, featureIndex);
        long stopTimeInsertion = System.currentTimeMillis();
        //System.out.println(stopTimeInsertion-startTimeInsertion);
    
        selectionSort notSortedList = new selectionSort(featureIndex);
        long startTimeSelection = System.currentTimeMillis();
        ArrayList<String[]>  sortedList = notSortedList.doSelectionSort(allData,false);
        long stopTimeSelection = System.currentTimeMillis();
        //System.out.println(stopTimeSelection-startTimeSelection);
        */
        if(saveOrNot){
        	try {
				FileWriter fileWriter = new FileWriter(args[0]);
				for(int i =0; i<header.length;i++){
					fileWriter.write(header[i]);;
					fileWriter.write(",");
				}
				fileWriter.write("\n");
				for(int i =0;i< sortedList2.size();i++){
					String[] list = sortedList2.get(i);
					for(int a = 0;a<84;a++){
						String str = list[a]; 
						fileWriter.write(str);
						fileWriter.write(",");
					}
					fileWriter.write("\n");
				}
				
        	} catch (IOException e) {
				e.printStackTrace();
			}

        }
    }

}
