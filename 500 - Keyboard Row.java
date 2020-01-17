/*  500 - Keyboard Row - From @ LeetCode.com
    
    Given a List of words, 
    return the words that can be typed using letters of alphabet on only one row's 
    of American keyboard like the image below.
    
    Example:

    Input: ["Hello", "Alaska", "Dad", "Peace"]
    Output: ["Alaska", "Dad"]

    Note:

        You may use one character in the keyboard more than once.
        You may assume the input string will only contain letters of alphabet.
 
    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    
    private Set<Character>[] sets = new HashSet[3];
    
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        initSets();
        for (String word : words) {
            int i = 0;
            for (; i <= 2; i++)
                if (sets[i].contains(Character.toLowerCase(word.charAt(0))))
                    break;
                        
            boolean qualified = true;
            for (int j = 1; j < word.length(); j++)
                if (!sets[i].contains(Character.toLowerCase(word.charAt(j)))) {
                    qualified = false;
                    break;
                }
            if (qualified) 
                list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }
    
    private void initSets() {
        sets[0] = new HashSet<>();
        sets[0].add('q');
        sets[0].add('w');
        sets[0].add('e');
        sets[0].add('r');
        sets[0].add('t');
        sets[0].add('y');
        sets[0].add('u');
        sets[0].add('i');
        sets[0].add('o');
        sets[0].add('p');
        sets[1] = new HashSet<>();
        sets[1].add('a');
        sets[1].add('s');
        sets[1].add('d');
        sets[1].add('f');
        sets[1].add('g');
        sets[1].add('h');
        sets[1].add('j');
        sets[1].add('k');
        sets[1].add('l');
        sets[2] = new HashSet<>();
        sets[2].add('z');
        sets[2].add('x');
        sets[2].add('c');
        sets[2].add('v');
        sets[2].add('b');
        sets[2].add('n');
        sets[2].add('m');
    }
}
