import java.util.ArrayList;

public class insertionSort {
	ArrayList<String[]> sort(ArrayList<String[]> list,int featureIndex){
		int n = list.size();
		for(int i= 0; i<n;++i){
			String[] keyList = list.get(i);
			double keyValue = Double.parseDouble(keyList[featureIndex]);
			int j = i-1;
			
			//move elements of list greater than key to ahead position
			
			while(j>=0 && Double.parseDouble(((list.get(j))[featureIndex]))>keyValue){
				list.set(j+1, list.get(j));
				j = j - 1;
			}
			list.set(j+1, keyList);
		}
		return list;
		
	}
}
