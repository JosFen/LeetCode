// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         if (s.length() < words.length * words[0].length()) return new ArrayList<Integer>();

//         Map<String, Integer> wordsMap = new HashMap<>();
//         List<Integer> res = new ArrayList<>();
//         int sLen = s.length(), wNum = words.length, len = words[0].length();

//         for (String word : words) wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);

//         for (int i = 0; i < sLen - wNum*len + 1; i++) {
//             Map<String, Integer> checked = new HashMap<>();
//             int j = 0;

//             for (; j < wNum; j++) {
//                 String w = s.substring(i+len*j, i+len*(j+1)); 
//                 if (wordsMap.containsKey(w)){
//                     checked.put(w, checked.getOrDefault(w, 0) + 1);
//                     if(checked.get(w) > wordsMap.get(w)) break;
//                 } else break;
//             }

//             if (j == wNum) res.add(i);
//         }
//         return res;
//     }
// }

class Solution {
    /* Credit: Multiple submitted articles read in discussion tab

 * Approach: Because every word in the words list has the same length. We can maintain
 * multiple sliding windows and go through String s only once. The number of the
 * windows needed is the length of the word.
 * 
 * For example suppose s=123456789, word length =3, all substrings we need to
 * check are:
 * 
 * 123, 234, 345, 456, 567, 678, 789, If we group them by their first char index
 * % word length and we get:
 * 
 * 0: 123, 456, 789
 * 
 * 1: 234, 567
 * 
 * 2: 345, 678
 * 
 * Now we only need to check if we find a match in each window. For each window,
 * the match algorithm is same as single sliding window problem.
 */
public List<Integer> findSubstring(String s, String[] words) {
	List<Integer> res = new ArrayList<>();
	int wordsToMatchCount = words.length;

	if (wordsToMatchCount == 0) {
		return res;
	}

	Map<String, Integer> map = new HashMap<>();
	for (String word : words) {
		map.put(word, map.getOrDefault(word, 0) + 1);
	}

	int singleWordLength = words[0].length(), window = singleWordLength * wordsToMatchCount;

	for (int i = 0; i < singleWordLength; ++i) {
		int start = i;

		// start window
		while (start + window <= s.length()) {

			// string to be matched with all concatenated words
			String sub = s.substring(start, start + window);

			// temp map to store seen words
			Map<String, Integer> seen = new HashMap<>();

			int j = wordsToMatchCount;

			while (j > 0) {
				// get the last word from the substr of singleWordLength to check if it is one
				// of the word present
				// in the given words list
				String word = sub.substring(singleWordLength * (j - 1), singleWordLength * j);

				int count = seen.getOrDefault(word, 0) + 1;

				// if this word is not present in our current window we break and start or next
				// window
				if (count > map.getOrDefault(word, 0)) {
					break;
				}

				seen.put(word, count);
				--j;
			}

			// if we found all words add to result
			if (j == 0) {
				res.add(start);
			}

			/*
			 * this is very tricky and the most imp part to improve performance
			 * 
			 * if we match some words start from the matched word and remove the words we
			 * didn't match in the same window to find any other match in the next window
			 * starting at:
			 * 
			 * start + (wordsToMatchCount - numbr of words matched) * singleWordLength
			 * 
			 * if we dont match any word in this window we start a new window starting at:
			 * start + wordsToMatchCount*singleWordLength
			 */
			start += singleWordLength * Math.max(j, 1);
		}
	}
	return res;
}
}
