import java.util.*;

public class PracticeProblem {

	public static void main(String args[]) {

	}
	


	public static int fib(int num){
		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
		return fibHelper(num, values);
		
	}


	public static int fibHelper(int num, HashMap<Integer, Integer> values){
		if (num <= 0){
			return 0;
		}
		else if (num == 1){
			return 1;
		}
		if (values.get(num) != null){
			return values.get(num);
		}
		values.put(num, fibHelper (num - 1, values) + fibHelper (num - 2, values));
		return values.get(num);

	}

	
}
