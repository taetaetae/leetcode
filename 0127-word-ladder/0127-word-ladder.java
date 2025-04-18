class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.add(beginWord);

        int distance = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();

            for (int i = 0; i < size; i++) {
                String currWord = wordQueue.poll();

                if (currWord.equals(endWord)) {
                    return distance;
                }

                for(int j=0 ; j<currWord.length(); j++){
                    char[] temp = currWord.toCharArray();

                    for(char c = 'a'; c<= 'z'; c++){
                        temp[j] = c;
                        String newWord = new String(temp);
                        if(wordSet.contains(newWord)){
                            wordQueue.add(newWord);
                            wordSet.remove(newWord);
                        }

                    }
                }
            }
            distance++;
        }

        return 0;
    }
}