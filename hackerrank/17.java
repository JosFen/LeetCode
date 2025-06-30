
/** 
Convert numbers to spoken word
Description
// Your task is to write a function that will
convert numbers into the spoken word equivalent
fn(7) => seven
fn(77) => seventy-seven
fn(777) => seven hundred and seventy-seven fn(7777) => seven thousand seven hundred and seventy-seven
fn(54321) => fifty-four thousand three hundred and twenty-one
*/

// a technical question that I did not finish the coding during interview 
// My thoughts of the solution at that time: 
// 1. HashMap (to create number->word library, and possible Memoization/cache) + 2. Recursion + 3. StringBuilder (runtime memory efficiency):

public class NumberToWordsConverter {

     // private static final HashMap<Integer, String> cache = new HashMap<>(); // possbile cache
  
    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen" // used HashMap during interview
    };
    
    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    }; // used HashMap during interview
    
    public static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }
        return convert(number).trim();
    }
    
    private static String convert(int number) {
        // // Check cache first
        // if (cache.containsKey(number)) {
        //     return cache.get(number);
        // }

        String result;
      
        if (number < 0) {
            result = "minus " + convert(-number);
        }
        else if (number < 20) {
            result = units[number];
        }
        else if (number < 100) {
            StringBuilder sb = new StringBuilder();
            sb.append(tens[number / 10]);
            if (number % 10 != 0) {
                sb.append("-").append(units[number % 10]);
            }
            result = sb.toString();
        }
        else if (number < 1000) {
            StringBuilder sb = new StringBuilder();
            sb.append(units[number / 100]).append(" hundred");
            if (number % 100 != 0) {
                sb.append(" and ").append(convert(number % 100));
            }
            result = sb.toString();
        }
        else if (number < 1000000) {
            StringBuilder sb = new StringBuilder();
            sb.append(convert(number / 1000)).append(" thousand");
            if (number % 1000 != 0) {
                if (number % 1000 < 100) {
                    sb.append(" and ");
                } else {
                    sb.append(" ");
                }
                sb.append(convert(number % 1000));
            }
            result = sb.toString();
        }
        else if (number < 1000000000) {
            StringBuilder sb = new StringBuilder();
            sb.append(convert(number / 1000000)).append(" million");
            if (number % 1000000 != 0) {
                sb.append(" ").append(convert(number % 1000000));
            }
            result = sb.toString();
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(convert(number / 1000000000)).append(" billion");
            if (number % 1000000000 != 0) {
                sb.append(" ").append(convert(number % 1000000000));
            }
            result = sb.toString();
        }
        
        // // Store result in cache before returning
        // cache.put(number, result);
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(convertNumberToWords(7));        // seven
        System.out.println(convertNumberToWords(77));       // seventy-seven
        System.out.println(convertNumberToWords(777));       // seven hundred and seventy-seven
        System.out.println(convertNumberToWords(7777));      // seven thousand seven hundred and seventy-seven
        System.out.println(convertNumberToWords(54321));     // fifty-four thousand three hundred and twenty-one
        System.out.println(convertNumberToWords(123456789)); // one hundred and twenty-three million four hundred and fifty-six thousand seven hundred and eighty-nine

      // // Test caching
      //   System.out.println("\nTesting cache:");
      //   long start = System.nanoTime();
      //   convertNumberToWords(123456789);
      //   long end = System.nanoTime();
      //   System.out.println("First call: " + (end - start) + " ns");
        
      //   start = System.nanoTime();
      //   convertNumberToWords(123456789);
      //   end = System.nanoTime();
      //   System.out.println("Second call (from cache): " + (end - start) + " ns");
    }
}
