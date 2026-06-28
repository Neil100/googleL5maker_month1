package arrays_and_hashing.day.one;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> vectorToIndices = new HashMap();

        /*
            vectorToIndices.getOrDefault();
            vectorToIndices.get();
            vectorToIndices.put();


        for(Map.Entry<String, List<Integer>> entry: vectorToIndices.entrySet()) {
            String key = entry.getKey();
            List<Integer> list = (List<Integer>) entry.getValue();
        }

        Iterator iterator = vectorToIndices.entrySet().iterator();

        while(iterator.hasNext()) {

            Map.Entry<String, List<Integer>> map = (Map.Entry<String, List<Integer>>) iterator.next();

        }

         */

        for(int i=0; i<strs.length; i++) {
            String currentStr = strs[i];

            int[] intVector = new int[27];
            for(int j=0; j<currentStr.length(); j++) {
                intVector[currentStr.charAt(j)-'a']++;
            }

            String vectorString = createVectorStringFromIntegerVector(intVector);

            if(vectorToIndices.containsKey(vectorString)) {
                vectorToIndices.get(vectorString).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                vectorToIndices.put(vectorString, indices);
            }
        }

        // HashMap Iterator
        Iterator hmIterator = vectorToIndices.entrySet().iterator();
        List<List<String>> answerList = new ArrayList<>();

        // Iterating through Hashmap and
        // adding some bonus marks for every student
        while (hmIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry)hmIterator.next();

            List<String> list = new ArrayList<>();
            List<Integer> value = (List<Integer>) mapElement.getValue();
            for(int i : value) {
                list.add(strs[i]);
            }

            answerList.add(list);
        }

        return answerList;
    }

    String createVectorStringFromIntegerVector(int[] intVector) {
        String vector = "";
        for(int i=0; i<intVector.length; i++) {
            vector = vector + ((intVector[i]) - '0');
        }

        return vector;
    }
}
