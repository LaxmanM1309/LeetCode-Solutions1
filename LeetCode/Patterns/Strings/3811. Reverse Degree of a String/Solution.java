class Solution {
    public int reverseDegree(String s) {
        int [] arr = new int[27];
        int n = 26;
        int product = 0;
        for(int i = 0 ; i < 27 ; i++){
            arr[n--] = arr.length - i - 1;
        }
        for(int i = 0 ; i < s.length() ; i++){
            int c = s.charAt(i) - 'a';
            int reverse = arr[26-c];
            System.out.println( reverse);
            product += (i+1) * reverse;
        }
        int temp;
        return product;
    }
}