package a;

import java.util.ArrayList;
import java.util.HashSet;

public class Run {

	static int[] coins = {1, 5, 10, 25};
	static ArrayList<Integer>possibilities = new ArrayList<>();

	public static void main(String[] args) {
		HashSet<ArrayList<Integer>>result = makeChange(21);

		for(ArrayList<Integer> element : result) {
			System.out.println(element.toString());
		}
	}

	static HashSet<ArrayList<Integer>> makeChange(int numberToTest, int coin, int sum, HashSet<ArrayList<Integer>>result, ArrayList<Integer> currentChange) {
		if(coin > coins.length -1) {
			return null;
		}

		for(int i=0; i<=possibilities.get(coin); i++) {
			if(sum == numberToTest) {
				ArrayList<Integer> seq2 = (ArrayList<Integer>) currentChange.clone();

				//replace empty spaces with zero
				for(int b=4-seq2.size(); b>0; b--) {
					seq2.add(0);
				}
				result.add(seq2);

				return null;
			}

			sum += coins[coin] * i;
			currentChange.add(i);
			makeChange(numberToTest, coin + 1, sum, result, currentChange);
			sum -= coins[coin] * i;
			currentChange.remove(currentChange.size() -1);
		}

		return result;
	}

	static HashSet<ArrayList<Integer>> makeChange(int n){
		for(int i : coins) {
			int r = n / i;

			if(r < 0) {
				possibilities.add(0);
			}else {
				possibilities.add(r);
			}
		}

		ArrayList<Integer> seq = new ArrayList<>();
		HashSet<ArrayList<Integer>>result = new HashSet<>();
		makeChange(n,0, 0, result, seq);

		return result;		
	}
}
