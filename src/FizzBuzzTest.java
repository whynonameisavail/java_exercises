import java.util.*;

public class FizzBuzzTest {
    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        HashMap<Integer, String> fizzdic = new HashMap<Integer, String>();
        fizzdic.put(3, "Fizz");
        fizzdic.put(5, "Buzz");

        /*For every number, iterate over the fizzBuzzHash keys and check for divisibility.
        If the number is divisible by the key,
        concatenate the corresponding hash value to the answer string for current number.
        We do this for every entry in the hash table.
         */
        for (int i = 1; i <= n; i++) {
            // create a string to hold the concatenated string
            String concat = "";
            for (Integer key : fizzdic.keySet()) {
                if (i % key == 0) {
                    concat += fizzdic.get(key);
                }
            }
            // if string empty - not divisible by each of the key
            if (concat.equals("")) {
                concat += Integer.toString(i);
            }
            // append curr string to ans
            ans.add(concat);

        }
        return ans;
    }

    public static void main(String[] args) {
        // test for general cases
        List<String> expected15 = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        List<String> result15 = fizzBuzz(15);
        System.out.println(expected15.equals(result15) ? "Test Case for 15 Passed" : "Test Case for 15 Failed");

        List<String> expected20 = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz");
        List<String> result20 = fizzBuzz(20);
        System.out.println(expected20.equals(result20) ? "Test Case for 20 Passed" : "Test Case for 20 Failed");

        // test for empty pass in
        List<String> expected0 = new ArrayList<>();
        List<String> result0 = fizzBuzz(0);
        System.out.println(expected0.equals(result0) ? "Test Case for 0 Passed" : "Test Case for 0 Failed");

        // test for only one value pass in
        List<String> expected1 = Arrays.asList("1");
        List<String> result1 = fizzBuzz(1);
        System.out.println(expected1.equals(result1) ? "Test Case for 1 Passed" : "Test Case for 1 Failed");

        // test for negative value
        List<String> expectedNeg = new ArrayList<>();
        List<String> resultNeg = fizzBuzz(-10);
        System.out.println(expectedNeg.equals(resultNeg) ? "Test Case for Negative Value Passed" : "Test Case for Negative Value Failed");


    }

}


// O(N), O(1)


