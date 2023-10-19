package statements;

import dataclasses.Match;
import dataextraction.MatchesDataExtraction;

import java.util.*;

public class StatementOne {

    Set<Integer>yearSet=new HashSet<Integer>();
    Map<Integer,Integer>yearCount=new HashMap<Integer,Integer>();
    public void output() {
        ListIterator<Match>iterator = MatchesDataExtraction.matchData.listIterator();
        while(iterator.hasNext()){
            yearSet.add(iterator.next().getSeason());
        }
        Iterator<Integer>itYear=yearSet.iterator();

        while (itYear.hasNext()){
            int year=itYear.next();
            int i=0;
            int count=0;
            ListIterator<Match>it = MatchesDataExtraction.matchData.listIterator();
            while(it.hasNext()){
                if(MatchesDataExtraction.matchData.get(i).getSeason()==year)
                    count++;
                it.next();
                i++;
            }
            yearCount.put(year,count);
        }

        System.out.println("Problem Statement - 1:");
        System.out.println("Year\tNumber of Matches");
        ArrayList<Integer>sortedKeys=new ArrayList<Integer>(yearCount.keySet());
        Collections.sort(sortedKeys);
        for (Integer x : sortedKeys)
            System.out.println(x+"\t"+ yearCount.get(x));
    }
}
