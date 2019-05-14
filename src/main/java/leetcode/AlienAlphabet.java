package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AlienAlphabet {



    void populate(List<String> words){

    }

    public static void main(String[] args){

        Map<String,List<String>> graph = new HashMap<>();
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        Set<String> a = Arrays.asList(words)
                .stream()
                .map(t -> t.substring(0, 1))
                .collect(Collectors.toSet());


        a.stream().forEach( t -> graph.put( t, new ArrayList<String>()));
        System.out.println(a);

    }
}
