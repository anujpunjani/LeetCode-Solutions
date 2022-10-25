class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String one = String.join("", word1);
        String two = String.join("", word2);
        return one.equals(two);
    }
}