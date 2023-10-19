package statements;

import dataclasses.Delivery;
import dataclasses.Match;
import dataextraction.DeliveriesDataExtraction;
import dataextraction.MatchesDataExtraction;

import java.util.*;

public class StatementThree {
    Set<Integer> idSet=new HashSet<Integer>();
    Set<String> teamSet=new HashSet<String>();

    Map<String, Integer> extraRunsMap=new HashMap<String, Integer>();
    public void output() {
        ListIterator<Match> itMatches = MatchesDataExtraction.matchData.listIterator();
        int i=0;
        while(itMatches.hasNext()){
            if(MatchesDataExtraction.matchData.get(i).getSeason()==2016) {
                idSet.add(MatchesDataExtraction.matchData.get(i).getId());
                teamSet.add(MatchesDataExtraction.matchData.get(i).getTeam1());
                teamSet.add(MatchesDataExtraction.matchData.get(i).getTeam2());
            }
            itMatches.next();
            i++;
        }
        Iterator<String> itTeam=teamSet.iterator();
        while(itTeam.hasNext()){
            String team=itTeam.next();
            int count=0;
            Iterator<Integer>itId =idSet.iterator();
            while(itId.hasNext()){
                int id =itId.next();
                Iterator<Delivery>itDeliveries=DeliveriesDataExtraction.deliveryData.listIterator();
                i=0;
                while(itDeliveries.hasNext()) {
                    if (DeliveriesDataExtraction.deliveryData.get(i).getMatch_id()==id&&
                            DeliveriesDataExtraction.deliveryData.get(i).getBowling_team().equals(team)) {
                        count += DeliveriesDataExtraction.deliveryData.get(i).getExtra_runs();
                    }
                    itDeliveries.next();
                    i++;
                }
            }
            extraRunsMap.put(team,count);
        }


        System.out.println("\nProblem Statement - 3:");
        System.out.println("Team - Extra Runs Conceded in 2016");
        ArrayList<String>sortedKeys=new ArrayList<String>(extraRunsMap.keySet());
        Collections.sort(sortedKeys);
        for (String x : sortedKeys){
            System.out.println(x+" - "+ extraRunsMap.get(x));
        }

    }
}
