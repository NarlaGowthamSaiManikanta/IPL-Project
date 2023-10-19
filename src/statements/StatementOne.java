package statements;

import dataclasses.Match;
import dataextraction.MatchesDataExtraction;

import java.util.*;

public class statementOne {

    Set<Integer>yearSet=new HashSet<Integer>();
    Map<Integer,Integer>yearcount=new HashMap<Integer,Integer>();
    public void output() {
        ListIterator<Match>iterator = MatchesDataExtraction.matchData.listIterator();
        while(iterator.hasNext()){
            yearSet.add(iterator.next().getSeason());
        }
        Iterator<Integer>itYear=yearSet.iterator();
        int i=0;
        int count=0;
        while (itYear.hasNext()){
            int year=itYear.next();
            ListIterator<Match>it = MatchesDataExtraction.matchData.listIterator();
            while(it.hasNext()){
                if(MatchesDataExtraction.matchData.get(i).getSeason()==year)
                    count++;
                
            }
        }
    }
}
