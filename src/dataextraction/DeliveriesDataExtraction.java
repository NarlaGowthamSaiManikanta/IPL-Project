package dataextraction;

import dataclasses.Delivery;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeliveriesDataExtraction {
    public static List<Delivery> deliveryData =new ArrayList<Delivery>();
    public void readingData(){
        String line="";
        String splitby=",";
        try{
            BufferedReader br =new BufferedReader(new FileReader("src/csvfiles/deliveries.csv"));
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
    public void storingData(String[] data){
        Delivery delivery=new Delivery();
        delivery.setMatch_id(Integer.parseInt(data[0]));
        delivery.setInning(Integer.parseInt(data[1]));
        delivery.setBatting_team(data[2]);
        delivery.setBowling_team(data[3]);
        delivery.setOver(Integer.parseInt(data[4]));
        delivery.setBall(Integer.parseInt(data[5]));
        delivery.setBatsman(data[6]);
        delivery.setNon_striker(data[7]);
        delivery.setBowler(data[8]);
        delivery.setIs_super_over(Integer.parseInt(data[9])%2==1);
        delivery.setWide_runs(Integer.parseInt(data[10]));
        delivery.setBye_runs(Integer.parseInt(data[11]));
        delivery.setLegbye_runs(Integer.parseInt(data[12]));
        delivery.setNoball_runs(Integer.parseInt(data[13]));
        delivery.setPenalty_runs(Integer.parseInt(data[14]));
        delivery.setBatsman_runs(Integer.parseInt(data[15]));
        delivery.setExtra_runs(Integer.parseInt(data[16]));
        delivery.setTotal_runs(Integer.parseInt(data[17]));
        deliveryData.add(delivery);
    }
}
