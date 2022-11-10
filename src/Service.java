import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Service {
    public void start(){
        int sizeOfRandomList = 2000;
        int amountOfPlayers = 400;
        List<Double> doubleListOfRandomNr = generateListOfRandomDoubles(sizeOfRandomList);
        List<Player> playersList = generatePlayers(amountOfPlayers);
        List<Player> playerList = assignRandomsToPlayers(playersList, doubleListOfRandomNr);
        exchangeNumbersToCards(playerList);
        setCardsRepetitionSetSumOfSequence(playerList);
        countCosTamNieMamPomyslu(playerList);

    }

    public void countCosTamNieMamPomyslu(List<Player> playerList){
        int x5 = 0;
        int x7 = 0;
        int x9 = 0;
        int x11 = 0;
        int x13 = 0;
        int x17 = 0;
        int x25 = 0;
        for (int i = 0; i < playerList.size(); i++) {

            Long sumOfSequence = playerList.get(i).getSumOfSequence();
            if (sumOfSequence == 5) {
                x5++;
            }
            if (sumOfSequence == 7) {
                x7++;
            }
            if (sumOfSequence == 9) {
                x9++;
            }
            if (sumOfSequence == 11) {
                x11++;
            }
            if (sumOfSequence == 13) {
                x13++;
            }
            if (sumOfSequence == 17) {
                x17++;
            }
            if (sumOfSequence == 25) {
                x25++;
            }
        }
        System.out.println("układ: x5" + " ilość: " + x5);
        System.out.println("układ: x7" + " ilość: " + x7);
        System.out.println("układ: x9" + " ilość: " + x9);
        System.out.println("układ: x11" + " ilość: " + x11);
        System.out.println("układ: x13" + " ilość: " + x13);
        System.out.println("układ: x17" + " ilość: " + x17);
        System.out.println("układ: x25" + " ilość: " + x25);
    }


    public void setCardsRepetitionSetSumOfSequence(List<Player> playerList){
        for (int i = 0; i < playerList.size(); i++) {
            for (int i1 = 0; i1 < playerList.get(i).getCardsList().size(); i1++) {
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.A)){
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.A)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.B)){
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.B)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.C)){
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.C)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.D)){
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.D)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.E)){
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.E)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                Collections.sort(playerList.get(i).getRepetitionList());
                Collections.reverse(playerList.get(i).getRepetitionList());
                playerList.get(i).setSumOfSequence();

            }
        }
    }

    public void exchangeNumbersToCards(List<Player> playerList){

        for (int j = 0; j < playerList.size(); j++) {

            int size = playerList.get(j).getDoubleList().size();

            for (int i = 0; i < size; i++) {

                if (playerList.get(j).getDoubleList().get(i) >= 0.0 && playerList.get(j).getDoubleList().get(i) < 0.2) {
                    playerList.get(j).setCardsList(Cards.A);

                }
                if (playerList.get(j).getDoubleList().get(i) >= 0.2 && playerList.get(j).getDoubleList().get(i) < 0.4) {
                    playerList.get(j).setCardsList(Cards.B);

                }
                if (playerList.get(j).getDoubleList().get(i) >= 0.4 && playerList.get(j).getDoubleList().get(i) < 0.6) {
                    playerList.get(j).setCardsList(Cards.C);

                }
                if (playerList.get(j).getDoubleList().get(i) >= 0.6 && playerList.get(j).getDoubleList().get(i) < 0.8) {
                    playerList.get(j).setCardsList(Cards.D);

                }
                if (playerList.get(j).getDoubleList().get(i) >= 0.8 && playerList.get(j).getDoubleList().get(i) <= 1.0) {
                    playerList.get(j).setCardsList(Cards.E);

                }
            }
        }
    }

    public List<Player> assignRandomsToPlayers(List<Player> playerList,List<Double> randomList){
        int sizeOfRandomList = randomList.size();
        int amountOfPlayers = playerList.size();
        int numberOfLoops = sizeOfRandomList/amountOfPlayers;
        int counter = 0;

        for (int i = 0; i < amountOfPlayers; i++) {
            for (int j = 0; j < numberOfLoops; j++) {
                playerList.get(i).setDoubleList(randomList.get(counter));
                counter++;
            }
        }
        return playerList;
    }

    public List<Double> generateListOfRandomDoubles(int size){
        List<Double> doubleList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            doubleList.add(r.nextDouble());
        }
        return doubleList;
    }

    public List<Player> generatePlayers(int amount){
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            playerList.add(new Player(new ArrayList<>()));
        }
        return playerList;
    }
}
