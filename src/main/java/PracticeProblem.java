import java.util.*;

public class PracticeProblem {

	public static void main(String args[]) {
		int[] cost = {10, 15};
		System.out.println("Final: " + minCostClimbingStairs (cost));

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



	public static int minCostClimbingStairs(int[] cost)
	{
		System.out.println("Runs");

		HashMap<Integer, Integer> leastCostAtIndex = new HashMap<Integer, Integer>(); 
		if (cost.length < 1)
		{
			return 0;
		}
		else if(cost.length == 1)
		{
			return cost[0];
		}
		return minCostHelper(-1, cost, cost.length, leastCostAtIndex);


	}


	public static int minCostHelper (int currentIndex, int[] cost, int costLength, HashMap<Integer, Integer> leastCostAtIndex)
	{
		if (currentIndex >= costLength)
		{
			System.out.println("Got to 0");
			return 0; 
		}
		System.out.println(currentIndex);

		if (leastCostAtIndex.get(currentIndex)!= null)
		{
			return leastCostAtIndex.get(currentIndex);
		}
		else
		{
			int oneStep = minCostHelper(currentIndex + 1, cost, costLength, leastCostAtIndex);
			int twoStep = minCostHelper(currentIndex + 2, cost, costLength, leastCostAtIndex);
			if (currentIndex >= 0)
			{
				if (oneStep < twoStep)
				{
					leastCostAtIndex.put(currentIndex, oneStep + cost[currentIndex]);
					return oneStep + cost[currentIndex];
				}
				leastCostAtIndex.put(currentIndex, twoStep + cost[currentIndex]);
				return twoStep + cost[currentIndex];
			}
			
			if (oneStep < twoStep)
			{
				leastCostAtIndex.put(currentIndex, oneStep );
				return oneStep;
			}
			leastCostAtIndex.put(currentIndex, twoStep);
			return twoStep;
		}



	}

	
}
