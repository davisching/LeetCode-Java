/*  093 - Restore IP Addresses - From @ LeetCode.com
    
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    Example:
    Input: "25525511135"
    Output: ["255.255.11.135", "255.255.111.35"]

    Solution by @ Davis Ching, 2019
 */
 
class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtracking (String s, int startsAt, List<String> list, List<String> ans) {
        if (list.size() > 4) return;
        if (startsAt == s.length() && list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(list.get(i));
                if (i != 3) sb.append(".");
            }
            ans.add(sb.toString());
        } else {
            for (int i = startsAt; i < Math.min(s.length(), startsAt+3); i++) {
                String cur = s.substring(startsAt, i+1);
                int val = Integer.parseInt(cur);
                if (val > 255 || i > startsAt && val < Math.pow(10, (i-startsAt))) return;
                list.add(cur);
                backtracking(s, i+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
}
