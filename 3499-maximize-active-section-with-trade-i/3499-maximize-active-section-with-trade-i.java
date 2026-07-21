class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();

        // Count original number of 1s
        int originalOnes = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                originalOnes++;
            }
        }

        // Add virtual 1s
        String t = "1" + s + "1";

        int maxGain = 0;

        // Store lengths of consecutive runs
        int[] count = new int[t.length()];
        char[] type = new char[t.length()];

        int groups = 0;
        int i = 0;

        while (i < t.length()) {

            int j = i;

            while (j < t.length() && t.charAt(j) == t.charAt(i)) {
                j++;
            }

            type[groups] = t.charAt(i);
            count[groups] = j - i;

            groups++;
            i = j;
        }

        // Find pattern:
        // 0-block, 1-block, 0-block
        for (i = 1; i < groups - 1; i++) {

            if (type[i] == '1'
                    && type[i - 1] == '0'
                    && type[i + 1] == '0') {

                int leftZero = count[i - 1];
                int rightZero = count[i + 1];

                maxGain = Math.max(
                        maxGain,
                        leftZero + rightZero
                );
            }
        }

        return originalOnes + maxGain;
    }
}