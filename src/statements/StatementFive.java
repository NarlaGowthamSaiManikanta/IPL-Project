package statements;

import dataclasses.Match;
import dataextraction.MatchesDataExtraction;

import java.util.*;

// Code to view season wise matches won by each team.
public class StatementFive {
    Set<Integer> yearSet=new HashSet<Integer>();
    Set<String> teamSet=new HashSet<String>();
    public void output() {
        ListIterator<Match> iterator = MatchesDataExtraction.matchData.listIterator();
        int i=0;
        while(iterator.hasNext()){
            yearSet.add(MatchesDataExtraction.matchData.get(i).getSeason());
            teamSet.add(MatchesDataExtraction.matchData.get(i).getTeam1());
            teamSet.add(MatchesDataExtraction.matchData.get(i).getTeam2());
            iterator.next();
            i++;
        }
        System.out.println("\nProblem Statement - 5:");
        Iterator<Integer>itYear=yearSet.iterator();
        while (itYear.hasNext()){
            int year=itYear.next();
            Map<String, Integer>winCountMap=new HashMap<String, Integer>();
            Iterator<String>itTeam=teamSet.iterator();
            while(itTeam.hasNext()) {
                String team =itTeam.next();
                i = 0;
                int count = 0;
                ListIterator<Match> it = MatchesDataExtraction.matchData.listIterator();
                while (it.hasNext()) {
                    if (MatchesDataExtraction.matchData.get(i).getSeason() == year&&
                            MatchesDataExtraction.matchData.get(i).getWinner().equals(team))
                        count++;
                    it.next();
                    i++;
                }
                winCountMap.put(team, count);
            }
            System.out.println("Season - "+year);
            System.out.println("Team - Number of Matches won");
            ArrayList<String>sortedKeys=new ArrayList<String>(winCountMap.keySet());
            Collections.sort(sortedKeys);
            for (String x : sortedKeys) {
                if(winCountMap.get(x)==0)
                    continue;
                System.out.println(x + "\t" + winCountMap.get(x));
            }
            System.out.println();
        }



    }

}
