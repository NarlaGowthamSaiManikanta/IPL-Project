package dataextraction;

import dataclasses.Match;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchesDataExtraction {
    public static List<Match> matchData =new ArrayList<Match>();
    public void readingData(){
        String line="";
        String splitby=",";
        try{
            BufferedReader br =new BufferedReader(new FileReader("src/csvfiles/matches.csv"));
            boolean firstLine=true;
            while ((line = br.readLine()) != null){
                if(firstLine){
                    firstLine=false;
                }
                else{
                    String[] data=line.split(splitby);
                    storingData(data);
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void storingData(String[] data) {
        Match match = new Match();
        match.setId(Integer.parseInt(data[0]));
        match.setSeason(Integer.parseInt(data[1]));
        match.setCity(data[2]);
        match.setDate(data[3]);
        match.setTeam1(data[4]);
        match.setTeam2(data[5]);
        match.setToss_winner(data[6]);
        match.setToss_decision(data[7]);
        match.setResult(data[8]);
        match.setDl_applied(Integer.parseInt(data[9]) % 2 == 1);
        match.setWinner(data[10]);
        match.setWin_by_runs(Integer.parseInt(data[11]));
        match.setWin_by_wickets(Integer.parseInt(data[12]));
        match.setPlayer_of_match(data[13]);
        match.setVenue(data[14]);
        matchData.add(match);
    }
}
