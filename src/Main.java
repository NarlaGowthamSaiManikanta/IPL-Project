import dataextraction.DeliveriesDataExtraction;
import dataextraction.MatchesDataExtraction;
import statements.StatementOne;
import statements.StatementThree;
import statements.StatementTwo;

public class Main {
    public static void main(String[] args) {

        MatchesDataExtraction matchesDataExtraction=new MatchesDataExtraction();
        DeliveriesDataExtraction deliveriesDataExtraction=new DeliveriesDataExtraction();
        matchesDataExtraction.readingData();
        deliveriesDataExtraction.readingData();

        StatementOne statementOne=new StatementOne();
        statementOne.output();

        StatementTwo statementTwo=new StatementTwo();
        statementTwo.output();

        StatementThree statementThree=new StatementThree();
        statementThree.output();
    }
}