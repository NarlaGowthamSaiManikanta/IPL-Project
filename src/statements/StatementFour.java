package statements;

import dataclasses.Delivery;
import dataclasses.Match;
import dataextraction.DeliveriesDataExtraction;
import dataextraction.MatchesDataExtraction;

import java.util.*;

public class StatementFour {
    Set<Integer> idSet=new HashSet<Integer>();
    Set<String> bowlerSet=new HashSet<String>();

    Map<String, Float> bowlersEconomyMap=new HashMap<String, Float>();
    public void output() {
        ListIterator<Match> itMatches = MatchesDataExtraction.matchData.listIterator();
        int i=0;
        while(itMatches.hasNext()){
            if(MatchesDataExtraction.matchData.get(i).getSeason()==2015) {
                idSet.add(MatchesDataExtraction.matchData.get(i).getId());
            }
            itMatches.next();
            i++;
        }
        ListIterator<Delivery> itDeliveries = DeliveriesDataExtraction.deliveryData.listIterator();
        i=0;
        while(itDeliveries.hasNext()) {
            if(idSet.contains(DeliveriesDataExtraction.deliveryData.get(i).getMatch_id())){
                bowlerSet.add(DeliveriesDataExtraction.deliveryData.get(i).getBowler());
            }
            itDeliveries.next();
            i++;
        }
        i=0;
        Iterator<String> itBowler=bowlerSet.iterator();
        while(itBowler.hasNext()){
            String bowler=itBowler.next();
            int runsCount=0;
            int ballsCount=0;
            Iterator<Integer>itId =idSet.iterator();
            while(itId.hasNext()){
                int id =itId.next();
                itDeliveries= DeliveriesDataExtraction.deliveryData.listIterator();
                i=0;
                while(itDeliveries.hasNext()) {
                    if (DeliveriesDataExtraction.deliveryData.get(i).getMatch_id()==id&&
                            DeliveriesDataExtraction.deliveryData.get(i).getBowler().equals(bowler)) {
                        runsCount += DeliveriesDataExtraction.deliveryData.get(i).getTotal_runs();
                        ballsCount++;
                    }
                    itDeliveries.next();
                    i++;
                }
            }
            bowlersEconomyMap.put(bowler,  ((float)runsCount*6/(float)ballsCount));
        }



        List<Map.Entry<String, Float> > list =
                new LinkedList<Map.Entry<String, Float> >(bowlersEconomyMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Float> >() {
            public int compare(Map.Entry<String, Float> o1,
                               Map.Entry<String, Float> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        System.out.println("\nProblem Statement - 4:");
        System.out.println("Bowler - Economy in 2015");
        int count=10;
        for (Map.Entry<String, Float> aa : list) {
            System.out.println(aa.getKey()+" - "+aa.getValue());
            if(--count==0)
                break;
        }
    }
}
