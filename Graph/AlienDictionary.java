import java.util.*;
//Given a sorted dictionary of an alien language, find the order of characters in the alphabet.
//        Example One
//        Input: ["baa", "abcd", "abca", "cab", "cad"]
//        Output: "bdac"
//        Example Two
//        Input: words = ["caa", "aaa", "aab"]
//        Output: "cab"
// graph and topological sort
public class AlienDictionary {

    static String find_order(String[] words) {

        Map<Character, Set<Character>> adjacencyList = new HashMap<>();
        int[] inMap = new int[26];

        buildAdjacencyList(words, inMap, adjacencyList);
        String order = topologicalSort(adjacencyList,inMap);
        return order.length() == adjacencyList.size() ? order : "";

    }

    private static void buildAdjacencyList(String[] words, int[] inMap, Map<Character, Set<Character>> adjacencyList) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjacencyList.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            while (j < words[i].length() && j < words[i + 1].length() && words[i].charAt(j) == words[i + 1].charAt(j)) {
                j++;
            }
            if (j < words[i].length() && j < words[i + 1].length()) {
                adjacencyList.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                inMap[words[i + 1].charAt(j) - 'a']++;
            }
        }
    }

    private static String topologicalSort(Map<Character, Set<Character>> adjacencyList,int[] inMap) {

        Queue<Character> q = new LinkedList<>();

        for (char c : adjacencyList.keySet()) {
            if (inMap[c - 'a'] == 0) {
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Character e = q.poll();
            sb.append(e);
            for (char neighbor : adjacencyList.get(e)) {
                inMap[neighbor - 'a']--;
                if (inMap[neighbor - 'a'] == 0)
                    q.offer(neighbor);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] s1 = new String[]{"caa","aaa", "aab"};
        String[] s2 = new String[]{"baa","abcd", "abca", "cab", "cad"};
        String res1 = find_order(s1);
        System.out.println(res1);
        String res2 = find_order(s2);
        System.out.println(res2);
    }

}



