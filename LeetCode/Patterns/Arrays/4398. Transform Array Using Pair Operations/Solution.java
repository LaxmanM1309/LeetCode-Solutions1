class Solution {
    public boolean canTransform(int[] source, int[] target) {
        if(source.length != target.length){
            return false;
        }
        if(source.length == 1) return source[0] == target[0];
        long ssum = 0;
        long tsum = 0;
        for(int i = 0 ; i < source.length ; i++){
            ssum += source[i];
            tsum += target[i];
        }
        return ssum == tsum;
    }
}