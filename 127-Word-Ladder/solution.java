public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null|| endWord.length() == 0 || beginWord.length() != endWord.length(){
            return -1;
        }
        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        int result = 0;
        int currLevNum = 0;
        int nextLevNum = 0;
        queue.offer(beginWord);
        set.add(beginWord);
        while (!queue.isEmpty()){
            currLevNum --;
            String curr = queue.poll();
            char[] currArr = curr.toCharArray();
            for (int i = 0; i < curr.length(); i ++){
                for (char ch = 'a'; ch < 'z'; ch ++){
                    currArr[i] = ch;
                    String temp = new String(currArr);
                    if (temp.equals(endWord)){
                        return result + 1;
                    }
                    if (!set.contains(temp) && wordList.contains(temp)){
                        nextLevNum ++;
                        set.add(temp);
                        queue.offer(temp);
                    }
                }
                currArr[i] = curr.charAt(i);
            }
            if (currLevNum == 0){
                currLevNum = nextLevNum;
                nextLevNum = 0;
                result ++;
            }
        }
        return result;
    }
}