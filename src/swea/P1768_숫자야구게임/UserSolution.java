package swea.P1768_숫자야구게임;

import java.util.Map;

class UserSolution {
	public final static int N = 4;

	public void doUserImplementation(int guess[]) {
		// Implement a user's implementation function
		//
		// The array of guess[] is a return array that
		// is your guess for what digits[] would be.

		int[][] numbers = new int[9999][4];
		int ndx = 0;

		for (int i = 123; i <= 9876; i++) {
			int one = i % 10;
			int ten = (i % 100) / 10;
			int hundred = (i % 1000) / 100;
			int thousand = (i / 1000);

			if (one == ten || one == hundred || one == thousand || ten == hundred || ten == thousand || hundred == thousand) {
				continue;
			}

			numbers[ndx++] = new int[]{thousand, hundred, ten, one};
		}

		while (numbers.length > 0) {
			int[] sample = numbers[0];

			Solution.Result result = Solution.query(sample);

			if (result.strike == 4) {
				for (int i = 0; i < N; i++) {
					guess[i] = sample[i];
				}
				break;
			}

			boolean[] deleteCheck = new boolean[numbers.length];
			int count = 0;
			deleteCheck[0] = true;

			for (int i = 1; i < numbers.length; i++) {
				if (!selfQuery(sample, numbers[i], result)) {
					deleteCheck[i] = true;
					count++;
				}
			}

			int[][] newNumbers = new int[numbers.length - count][4];
			int nndx = 0;
			for (int i = 0; i< numbers.length; i++) {
				if (!deleteCheck[i]) {
					newNumbers[nndx++] = numbers[i];
				}
			}
			numbers = newNumbers;
		}
	}

	public boolean selfQuery(int[] guess, int[] compare, Solution.Result result) {
		Solution.Result compareResult = new Solution.Result();

		int[] compareBall = new int[10];
		for (int c = 0; c < compare.length; c++) {
			compareBall[compare[c]]++;
		}

		for (int idx = 0; idx < N; ++idx) {
			if (guess[idx] == compare[idx])
				compareResult.strike++;
			else if (compareBall[guess[idx]] > 0)
				compareResult.ball++;
		}

		return result.strike == compareResult.strike && result.ball == compareResult.ball;
	}
}
