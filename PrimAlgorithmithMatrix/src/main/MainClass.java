package main;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {
	
	public static void main(String[] args) {
		List<Integer> vals = new ArrayList<>();
		Integer result = 0;
		Integer min = 0;
		Integer[][] matrix = new Integer[][] {{0, 17, 0, 26, 0, 0, 0}, {17, 0, 5, 10, 0, 0, 0}, {0, 5, 0, 3, 2, 20, 0}, 
												{26, 10, 3, 0, 8, 0, 0}, {0, 0, 2, 8, 0, 8, 0}, {0, 0, 20, 0, 8, 0, 9}, {0, 0, 0, 0, 0, 9, 0}};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int row = 0; row < 1; row++) {
			for(int col = 0; col < matrix.length; col++) {
				if(matrix[row][col] != 0) {
					vals.add(matrix[row][col]);
					map.put(matrix[row][col], col);
				}
			}
		}
		
		min = min(vals);
		result += min;
		vals.remove(min);
		
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix.length; col++) {
				if(matrix[map.get(min)][col] == min) {
					matrix[map.get(min)][col] = 0;
					matrix[col][map.get(min)] = 0;
					for(int coll = 0; coll < matrix.length; coll++) {
						if(matrix[coll][map.get(min)] != 0) {
							vals.remove(matrix[coll][map.get(min)]);
							matrix[coll][map.get(min)] = 0;
						}
					}
				}
				if(matrix[map.get(min)][col] != 0) {
					vals.add(matrix[map.get(min)][col]);
					map.put(matrix[map.get(min)][col], col);
				}
			}
			
			min = min(vals);
			result += min;
			vals.remove(min);
			
			if(min == 9) {
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static Integer min(List<Integer> vals) {
		Integer min = vals.get(0);
		for(Integer val : vals) {
			if(val < min) {
				min = val;
			}
		}
		return min;
	}
}