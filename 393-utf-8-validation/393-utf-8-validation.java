class Solution {
    public boolean validUtf8(int[] data) {
        int noOfBytes = 0;
        for(int val : data) {
            if(noOfBytes == 0) {
                if(val >> 7 == 0b0) noOfBytes = 0; // 1 Byte
                else if(val >> 5 == 0b110) noOfBytes = 1; // 2 Byte
                else if(val >> 4 == 0b1110) noOfBytes = 2; // 3 Byte
                else if(val >> 3 == 0b11110) noOfBytes = 3; // 4 Byte
                else return false;
            } else {
                if(val >> 6 == 0b10) noOfBytes--;
                else return false;
            }
        }
        
        return noOfBytes == 0;
    }
}