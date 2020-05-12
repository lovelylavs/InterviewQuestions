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

You may notice something peculiar: the C(6, 2) call is performed three times, and each time it performs the same computation, and returns the same value. The crucial insight here is that these function calls repeat, each time returning the same value. After you compute their result once there’s no need to recompute them.

We can use memoization (not memorization), which basically means we record results of function calls we’ve seen before and use those instead of redoing the work. This way, when we encounter a place in the call graph where we would unnecessarily recompute an entire subtree, we instead immediately return the result we already computed. Here’s an implementation:


```
public class KnightDialer {
	
	static int[][] neighbors = {{4,6},{6,8},{7,9},{4,8}, {3,9,0},{},{7,1},{6,2},{1,3},{2,4},{4,6}};
	
	static Integer[][] cache;  // for making sure the place has null which helps to see if value inserted at this location
	static int count_sequences(int start_pos, int hops){
		if(hops == 0)
			return 1;
		
		if(cache[start_pos][hops] != null)
			return cache[start_pos][hops];
		cache[start_pos][hops]=0;
		
		for(int position: neighbors[start_pos]){
			cache[start_pos][hops] += count_sequences(position, hops-1);
		}
		
		return cache[start_pos][hops];
	}
	
	public static void main(String[] args){
		cache = new Integer[10][2+1];
		System.out.println(count_sequences(6,2));
	}
}
```


Alright, what’s the runtime complexity (Big-O) now? That’s tougher to answer. For the previous implementation, computing the runtime was as simple as counting the number of times the recursive function was called, which was always two or three times per call. This time counting is more complicated because the recursive call is guarded by a conditional. On the face of it there’s no obvious way to count function calls.

We can solve this mystery by instead looking at the cache. Each function call’s result is stored in the cache, and it’s inserted there exactly once. This allows us to reframe the question as “how does the size of the cache grow with the size of the input?” Given that the cache is keyed by position and number of hops, and there are exactly ten positions, we can conclude that the cache grows in direct proportion to the number of requested hops. This follows from the pigeonhole principle: once we have an entry in the cache for every combination of position and jump count, all calls will hit the cache rather than result in a new function call.

Linear time! That’s not bad. In fact, it’s remarkable: the addition of a simple cache changed the algorithm’s runtime from exponential to linear.

Level 4: Dynamic Programming
The minor limitation of the recursive memoizing solution is clear when you look at the recurrence relation from above:


Notice that the results for N hops depend only on the results for calls with N-1 hops. Meanwhile, the cache contains entries for every (nonzero) number of hops. I call this a minor issue because it doesn’t actually cause any real problems, given that the cache grows only linearly with the number of hops. Requiring linear space isn’t the end of the world, but still, it’s inefficient.

What gives? Again, the result is clear when you look at a written-out solution and the code. Notice that the code starts with the largest number of hops and recurses directly down to the smallest:

If you imagine the entire function call graph as a sort of virtual tree, you’ll quickly see we’re performing a depth-first traversal. This is fine, it gives a proper solution, but it doesn’t take advantage of the shallow dependency property I pointed out above.

Can you perform a breadth-first traversal instead, where you start at the top and “visit” function calls for N-1 hops only after you’ve visited those for N hops? Sadly, no. The values of function calls with nonzero hops absolutely require the values from smaller hop counts, so you won’t get any results until you reach the zero-hop layer and start returning numbers rather than additional function calls (note the zero-hop layer isn’t depicted here).

You can however, reverse the order: visit layers with N hops only after you’ve visited layers with N-1 hops. Those of you who studied or are studying discrete mathematics will recognize all the necessary ingredients for an induction: we know that the values of zero-hop function calls are always one (the base case). We also know how to combine N-1 hop values to get N hop values, using the recurrence relation (the inductive step). We can start with a base case of zero hops and induce all values greater than zero. Here’s an implementation

https://leetcode.com/problems/knight-dialer/discuss/189252/O(logN)

