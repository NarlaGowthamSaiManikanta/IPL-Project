package statements;

import dataclasses.Match;
import dataextraction.MatchesDataExtraction;

import java.util.*;

public class StatementTwo {
    Set<String> teamSet=new HashSet<String>();
    Map<String,Integer> winCount=new HashMap<String,Integer>();
    public void output() {
        ListIterator<Match> iterator = MatchesDataExtraction.matchData.listIterator();
        while(iterator.hasNext()){
            teamSet.add(iterator.next().getWinner());
        }
        Iterator<String>itTeam=teamSet.iterator();

        while (itTeam.hasNext()){
            String team=itTeam.next();
            int i=0;
            int count=0;
            ListIterator<Match>it = MatchesDataExtraction.matchData.listIterator();
            while(it.hasNext()){
                if(MatchesDataExtraction.matchData.get(i).getWinner().equals(team))
                    count++;
                it.next();
                i++;
            }
            winCount.put(team,count);
        }

        System.out.println("\nProblem Statement - 2:");
        System.out.println("Team - Number of Matches");
        ArrayList<String>sortedKeys=new ArrayList<String>(winCount.keySet());
        Collections.sort(sortedKeys);
        for (String x : sortedKeys){
            if(x.equals(""))
                continue;
            System.out.println(x+" - "+ winCount.get(x));
        }

    }
}
