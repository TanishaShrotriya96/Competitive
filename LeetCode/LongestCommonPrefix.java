package LeetCode;

import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        String prefix = "";
        int length = strs.length;
        for(int i=0;i<strs[0].length();i++) {
            if(strs[length -1].charAt(i) == strs[0].charAt(i) ) {
                prefix = prefix+strs[length -1].charAt(i);
            }
            else break;
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        // Sort lexicographically
        Arrays.sort(strs);
        // Find first index that is different between first and last
        int firstMismatchIndex = Arrays.mismatch(strs[0].toCharArray(), strs[strs.length - 1].toCharArray());
        // Substring from start until:
        // the end if no mismatch was found (exact same string)
        // until mismatch index exclusively.
        return strs[0].substring(0, firstMismatchIndex < 0 ? strs[0].length() : firstMismatchIndex);
    }
}