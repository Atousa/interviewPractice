import java.util.*;
//127 leetcode


class MinStringTransformation {

    public static String[] minStringTransformation(String[] words, String start, String stop) {
        if (words.length == 0 && start.equals(stop)) return (new String[]{"-1"});
        //ONE CASE
        Set<String> visited = new HashSet<>();
        Set<String> dictionary = new HashSet<>();
        for (String s : words) {
            dictionary.add(s);
        }

        //if stop and start words are the same
        dictionary.remove(stop);
        dictionary.remove(start);

        Map<String, String> parent = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        parent.put(start,null);

        int step = 0;

        while (!q.isEmpty()) {
            String cur = q.poll();
            Set<String> neighbors;
            if (26 * cur.length() < dictionary.size())
                neighbors = getNeighbours(cur, stop, dictionary);
            else
                neighbors = getNeighboursInDict(cur, stop, dictionary);
            for (String neighbor : neighbors) {
                if(neighbor.equals(stop)) {
                    List<String> l = new ArrayList<>();
                    l.add(stop);
                    while(cur!= null) { // if the start word is equal the stop word we dont want that it gets overwritten , so we dont
                        // ad it to teh hashMap.
                        l.add(cur);
                        cur = parent.get(cur);
                    }
                    Collections.reverse(l);

                    String[] s = new String[l.size()];
                    s = l.toArray(s);
                    return s;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                    parent.put(neighbor, cur);
                }
            }
        }
        return (new String[]{"-1"});
    }

    private static Set<String> getNeighbours(final String current, final String stop,final Set<String> dict) {

        Set<String> neighbours = new HashSet<>();
        for (int i = 0; i <current.length(); i++) {
            char[] candidate = current.toCharArray();
            char orig = candidate[i];
            for (char ch = 'a'; ch<='z'; ch++) {
                if(ch != orig) {
                    candidate[i] = ch;
                    String candStr = new String(candidate);
                    if(dict.contains(candStr) || candStr.equals(stop)) {
                        neighbours.add(candStr);
                    }
                }
            }
        }
        return neighbours;
    }

    private static boolean doWordsDifferByOneChar(String word1, String word2) {
        int diffCount = 0;
        int i = 0;
        while (i < word1.length() && i< word2.length()) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if(diffCount > 1) {
                return false;
            }
            i++;
        }
        return diffCount==1;
    }

    private static Set<String> getNeighboursInDict(String word, String stop, Set<String> dict) {
        Set<String> neg = new HashSet<>();
        if (doWordsDifferByOneChar(word, stop)) {
            neg.add(stop);
        }
        for (String w : dict) {
            if(doWordsDifferByOneChar(word, w)) {
                neg.add(w);
            }
        }
        return neg;
    }


    public static void main(String[] args) {
        String[] strings = new String[]{"cccw", "accc", "accw"};
        String[] s =  minStringTransformation(strings,"cccc","cccc");
        for (String c: s){
            System.out.println(c);
        }
    }
}



