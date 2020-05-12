https://hackernoon.com/google-interview-questions-deconstructed-the-knights-dialer-f780d516f029


The Question
Imagine you place a knight chess piece on a phone dial pad. This chess piece moves in an uppercase “L” shape: two steps horizontally followed by one vertically, or one step horizontally then two vertically:


Pay no attention to the poorly-redacted star and pound keys
Suppose you dial keys on the keypad using only hops a knight can make. Every time the knight lands on a key, we dial that key and make another hop. The starting position counts as being dialed.

How many distinct numbers can you dial in N hops from a particular starting position?

With that being said, your first action after hearing the question should be stepping up to the whiteboard and solving small instances of the problem by hand. Never dive right into code! Solving small instances lets you spot patterns, observed and edge cases, and also helps crystallize a solution in your head. As an example, suppose you start on 6 and have two hops to make. Your sequences will be…

6–1–8
6–1–6
6–7–2
6–7–6
6–0–4
6–0–6
…for a total of six sequences.

Level 0: Getting the Next Hop
let’s assume there’s a function that gives me the neighbors” along with the following stub

	static int[][] neighbors = {{4,6},{6,8},{7,9},{4,8}, {3,9,0},{},{7,1},{6,2},{1,3},{2,4},{4,6}};


Level 1: Recursively Generating Numbers

You can use recursion to generate these values:


Level 2: Counting Without Counting

How can we count phone numbers without generating them? It can be done, but not without an additional insight. Notice how the count of numbers that can be generated from a given starting position in N hops is equal to the sum of the counts of hops that can be generated starting from each of its neighbors in N-1 hops. Stated mathematically as a recurrence relation, it looks like this:


This is intuitively obvious when you consider what happens with one hop: 6 has 3 neighbors (1, 7, and 0) and in zero hops you can reach one number for each, so you can only dial three numbers.






Deconstructing the knights dialer problem using Java

Basic recursive solution


public class KnightDialer {
	
	static int[][] neighbors = {{4,6},{6,8},{7,9},{4,8}, {3,9,0},{},{7,1},{6,2},{1,3},{2,4},{4,6}};
	
	static int count_sequences(int start_pos, int hops){
		if(hops == 0)
			return 1;
		
		int num_sequences=0;
		
		for(int position: neighbors[start_pos]){
			num_sequences += count_sequences(position, hops-1);
		}
		
		return num_sequences;
	}
	
	public static void main(String[] args){
		System.out.println(count_sequences(6,2));
	}
}



Big O:

For this implementation, every call to count_sequences() recursively calls count_sequences() at least twice, because each key has at least two neighbors. Since we recurse a number of times equal to the desired number of hops, and the number of calls to count_sequences() at least doubles with each call, we’re left with a runtime complexity of at least exponential time.

This is bad. Asking for an additional hop will double, if not triple, the runtime. For small numbers like 1 through maybe 20 this is acceptable, but as we ask for larger and larger numbers of hops, we hit a wall. For instance, 500 hops would require until well after the heat death of the universe to complete.


Level 3: Memoization


