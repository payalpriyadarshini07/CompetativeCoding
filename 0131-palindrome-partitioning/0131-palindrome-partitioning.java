class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(s, 0, current, result);

        return result;
    }

    private void backtrack(String s, int start,
                            List<String> current,
                            List<List<String>> result) {

        // We have processed the complete string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            String substring = s.substring(start, end + 1);

            // Only choose palindrome substrings
            if (isPalindrome(substring)) {

                current.add(substring);

                backtrack(s, end + 1, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}