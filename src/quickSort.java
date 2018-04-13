import java.util.ArrayList;

public class quickSort {
	
	ArrayList<String[]> array;
	private int length;
	private int featureIndex;
	
	public ArrayList<String[]> sort(ArrayList<String[]> inputArr,int featureIndex){
		if(inputArr == null || inputArr.size() == 0){
			return array;
		}
		this.array = inputArr;
		length = inputArr.size();
		this.featureIndex =featureIndex;
		quickSorting(0,length-1);
		
		return array;
	}
	
	private void quickSorting(int lowerIndex,int higherIndex){
		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		String[] pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2);
		double pivotNumber = Double.parseDouble(pivot[featureIndex]);
		
		while (i <= j ){
			while(Double.parseDouble((array.get(i))[featureIndex]) < pivotNumber){
				i++;
			}
			while(Double.parseDouble((array.get(j))[featureIndex])> pivotNumber){
				j--;
			}
			if(i<=j){
				swapNumbers(i,j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if(lowerIndex < j)
			quickSorting(lowerIndex,j);
		if(i<higherIndex)
			quickSorting(i,higherIndex);
	}
	
	private void swapNumbers(int i,int j){
		String[] temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
	
	
}
