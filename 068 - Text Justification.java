/*  068 - Text Justification - From @ LeetCode.com
    
    Given an array of words and a width maxWidth, 
    format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
    Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

    Extra spaces between words should be distributed as evenly as possible. 
    If the number of spaces on a line do not divide evenly between words, 
    the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left justified and no extra space is inserted between words.
    Note:
    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.

    Example 1:
    Input:
    words = ["This", "is", "an", "example", "of", "text", "justification."]
    maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]

    Example 2:
    Input:
    words = ["What","must","be","acknowledgment","shall","be"]
    maxWidth = 16
    Output:
    [
      "What   must   be",
      "acknowledgment  ",
      "shall be        "
    ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be",
                 because the last line must be left-justified instead of fully-justified.
                 Note that the second line is also left-justified becase it contains only one word.

    Example 3:
    Input:
    words = ["Science","is","what","we","understand","well","enough","to","explain",
             "to","a","computer.","Art","is","everything","else","we","do"]
    maxWidth = 20
    Output:
    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]
    
    Solution by @ Davis Ching, 2019
 */
 
 class Solution {
    
    List<String> ans = new ArrayList<>();
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            for (int len = 0; i+j < words.length; j++) {
                len += words[i+j].length();
                if (len+j > maxWidth) break;
            }
            addRow(words, maxWidth, i, i+j-1);
            i += j-1;
        }
        return ans;
    }
    
    private void addRow (String[] words, int maxWidth, int first, int last) {
        StringBuilder sb = new StringBuilder();
        if (first == last) {
            sb.append(words[first]);
            sb.append(space(maxWidth-words[first].length()));
        } else if (last == words.length-1) {
            for (int i = first; i <= last; i++) {
                sb.append(words[i]);
                if (i != last) sb.append(" ");
            }
            sb.append(space(maxWidth-sb.length()));
        } else {
            int spaceAmount = last - first;
            int spaceLen = maxWidth;
            for (int i = first; i <= last; i++)
                spaceLen -= words[i].length();
            
            int extraSpaceAmount = spaceLen % spaceAmount;
            spaceLen /= spaceAmount;
            for (int i = first; i <= last; i++) {
                sb.append(words[i]);
                if (i != last) {
                    sb.append(space(spaceLen));
                    if (extraSpaceAmount-- > 0)
                        sb.append(" ");
                }
            }
        }
        ans.add(sb.toString());
    }
    
    private String space (int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(" ");
        return sb.toString();
    }
}
