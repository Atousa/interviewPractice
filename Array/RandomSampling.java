import java.text.CollationElementIterator;
import java.util.*;

/**
 * need for a company to select random subset of its customers to roll out a new feature
 * tome complexity is o(k)
 */

public class RandomSampling {

    public static void randomSampling(int k , List<Integer> A) {
        Random gen = new Random();
        for(int i = 0; i < k; i++) {
            //generate a rand number between [i, A.size()-1]
            Collections.swap(A, i, i + gen.nextInt(A.size()-i );
        }
    }

/**
Sample online data , a packet sniffer
 space complexity is O(k) and time complexity is proportional to the number of element in stream
 */
    public static List<Integer> onlineRandomSample(Iterator<Integer> stream, int k) {
        List<Integer> sample = new ArrayList<>(k);
        //store the first k elements in the sample

        for (int i = 0; i < k; k++)
            sample.add(stream.next());

        int numSeenSoFar = k;
        Random randIdxGen = new Random();

        while (stream.hasNext()) {
            Integer x = stream.next();
            ++numSeenSoFar;
            int idxToReplace = randIdxGen.nextInt(numSeenSoFar);
            if (idxToReplace < k) {
                Collections.swap(sample, idxToReplace, x);
            }
        }
        return sample;
    }
}




