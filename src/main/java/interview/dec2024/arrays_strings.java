package interview.dec2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class arrays_strings {

    public static void main(String[] args) {
        // Q1 - How do you find the missing number in an array of size n containing numbers from 1 to n+1?
        System.out.println("\nQuestion 1");
        System.out.println("Missing numbers is Method 1: " + find_missing_method1(new int[]{1, 2, 4, 5, 6}));
        System.out.println("Missing numbers is Method 2: " + find_missing_method2(new int[]{1, 2, 4, 5, 6}));

        // Q2 - Find the index of roated target array
        System.out.println("\nQuestion 2");
        roated_array_search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6);

        // Q3 - Explain and implement two-pointer techniques to find:
        //	• Two numbers in an array that add up to a given sum.
        //	• The longest substring without repeating characters.
        System.out.println("\nQuestion 3.1");
        int[] result = two_sum_two_number(new int[]{10, 15, 3, 7}, 17);
        if (result.length == 2) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }

        System.out.println("\nQuestion 3.2");
        String input = "abcabcbb";
        String longest_sub_string = find_longest_substring(input);
        System.out.println("Longest substring: " + longest_sub_string);
        System.out.println("Length of longest substring: " + longest_sub_string.length());


        // Q4 - How do you check if one string is a permutation of another string in Java?
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("\nQuestion 4");
        System.out.println("Are the strings permutations? method 1: " + is_permuntation_method1(str1, str2));
        System.out.println("Are the strings permutations? method 2: " + is_permuntation_method2(str1, str2));

        // Q5 - Write a program to find the longest palindromic substring in a given string?
        System.out.println("\nQuestion 5");
        String i = "babad";
        String longestPalindrome = find_longest_palindrome(i);
        System.out.println("Longest palindromic substring: " + longestPalindrome);

    }

    static int find_missing_method1(int[] arr) {
        int n = arr.length;
        int exectedSum = (n+1) * (n+2) / 2;
        int actualSum = 0;

        for (int a : arr) {
            actualSum += a;
        }

        return exectedSum - actualSum;
    }

    static int find_missing_method2(int[] arr) {
        int n = arr.length;
        int xor = 0;

        for (int i = 1; i <= n + 1; i++) {
            xor ^= i;
        }

        for (int a : arr) {
            xor ^= a;
        }

        return xor;
    }

    static void roated_array_search(int[] arr, int target) {
        System.out.println("Index of target " + target + ": " + search(arr, target));
    }

    private static int search(int[] arr, int target) {
        int left = 0; int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    static int[] two_sum_two_number(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0; int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right --;
            }
        }
        return new int[]{};
    }

    static String find_longest_substring(String s) {
        int maxLength = 0;
        int start = 0; int end = 0;
        int maxStart = 0;
        HashSet<Character> set = new HashSet<>();

        while (end < s.length()) {
            char currentChar = s.charAt(end);

            // If character is already in the set, shrink the window
            while (set.contains(currentChar)) {
                set.remove(s.charAt(start));
                start++;
            }

            // Add the current character to the set and expand the window
            set.add(currentChar);

            // Update the maximum length and substring start index
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }

            end++;
        }
        // Return the longest substring
        return s.substring(maxStart, maxStart + maxLength);
    }

    static boolean is_permuntation_method1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // convert to char array, sort them and compare
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    static boolean is_permuntation_method2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // HashMap
        HashMap<Character, Integer> char_count = new HashMap<>();
        for (char c: s1.toCharArray()) {
            char_count.put(c, char_count.getOrDefault(c, 0) + 1);
        }

        for (char c: s2.toCharArray()) {
            if (!char_count.containsKey(c)) {
                return false;
            }
            char_count.put(c, char_count.get(c) - 1);
            if (char_count.get(c) == 0) {
                char_count.remove(c);
            }
        }

        return char_count.isEmpty();
    }

    static String find_longest_palindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (single character center)
            int len1 = expand_aroun_center(s, i, i);
            // Check for even-length palindromes (two-character center)
            int len2 = expand_aroun_center(s, i, i + 1);

            // Find the maximum length
            int len = Math.max(len1, len2);

            // Update the start and end indices if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    private static int expand_aroun_center(String s, int left, int right) {
        // Expand outward as long as the characters match and are within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
