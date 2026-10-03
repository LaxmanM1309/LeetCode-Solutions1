class Solution {

    int val(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        int total = 0;
        int i = 0;

        while (i < s.length()) {
            int curr = val(s.charAt(i));

            if (i + 1 < s.length() && curr < val(s.charAt(i + 1))) {
                total += val(s.charAt(i + 1)) - curr;
                i += 2;
            } else {
                total += curr;
                i++;
            }
        }

        return total;
    }
}