import java.util.ArrayList;

public class selectionSort {
	int featureIndex;
	ArrayList<String[]> sorting = new ArrayList<String[]>();
	
	public selectionSort(int index){
		this.featureIndex = index;
	}
	
	public ArrayList<String[]> doSelectionSort(ArrayList<String[]> arr,boolean save){
	         
	        for (int i = 0; i < arr.size() - 1; i++)
	        {	
	        	String[] temp = arr.get(i);
	        	double tempD = Double.parseDouble(temp[featureIndex]);
	        	int index = i;
	        	//System.out.println(arr.size());
	            for (int j = i+1 ; j < arr.size(); j++){
	            	String[] temp2 = arr.get(j);
	            	double temp2d = Double.parseDouble(temp2[featureIndex]);
	            	if ( temp2d < tempD){
	                    index = j;
	                    }
	            	}
	            String[] smallerList = arr.get(index);
	            arr.set(index, arr.get(i));
	            arr.set(i, smallerList);
	        }
	        return arr;
	}
}