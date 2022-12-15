import java.util.*;

public class Service {
    public void start() {
        // Generate the random numbers and players
        int sizeOfRandomList = 2000;
        int amountOfPlayers = 400;
        List<Double> doubleListOfRandomNr = generateListOfRandomDoubles(sizeOfRandomList);
        List<Player> playersList = generatePlayers(amountOfPlayers);

        // Assign the random numbers to the players, exchange them for cards,
        // set the card repetition set and sum of sequence, and count the sum of sequences
        List<Player> playerList = assignRandomsToPlayers(playersList, doubleListOfRandomNr);
        exchangeNumbersToCards(playerList);
        setCardsRepetitionSetSumOfSequence(playerList);
        countSumOfSequences(playerList);
    }

    public void countSumOfSequences(List<Player> playerList) {
        // Create a Map to store the counts of each sequence
        Map<Long, Integer> sequenceCounts = new HashMap<>();

        // Iterate over the playerList
        for (Player player : playerList) {
            // Get the sum of the sequence for this player
            Long sumOfSequence = player.getSumOfSequence();

            // Update the count for this sequence in the Map
            sequenceCounts.put(sumOfSequence, sequenceCounts.getOrDefault(sumOfSequence, 0) + 1);
        }

        // Print the counts of each sequence
        for (Map.Entry<Long, Integer> entry : sequenceCounts.entrySet()) {
            System.out.println("układ: " + entry.getKey() + " ilość: " + entry.getValue());
        }
    }


    public void setCardsRepetitionSetSumOfSequence(List<Player> playerList) {
        // Iterate over each player in the list
        for (int i = 0; i < playerList.size(); i++) {
            // Iterate over each card in the player's card list
            for (int i1 = 0; i1 < playerList.get(i).getCardsList().size(); i1++) {
                // Check if the current card is A
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.A)) {
                    // Count the number of A cards in the player's card list
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.A)).count();
                    // Set the repetition list for the player to the count of A cards
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.B)) {
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.B)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.C)) {
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.C)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.D)) {
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.D)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                if (playerList.get(i).getCardsList().get(i1).equals(Cards.E)) {
                    Long count = playerList.get(i).getCardsList().stream().filter(x -> x.equals(Cards.E)).count();
                    playerList.get(i).setRepetitionList(count);
                }
                // Sort the repetition list in descending order
                Collections.sort(playerList.get(i).getRepetitionList());
                // Reverse the repetition list so that it is in ascending order
                Collections.reverse(playerList.get(i).getRepetitionList());
                // Set the sum of sequence for the player
                playerList.get(i).setSumOfSequence();
            }
        }
    }

    public void exchangeNumbersToCards(List<Player> playerList) {
        // Iterate over each player in the list
        for (int j = 0; j < playerList.size(); j++) {
            // Get the size of the player's double list
            int size = playerList.get(j).getDoubleList().size();
            // Iterate over each value in the player's double list
            for (int i = 0; i < size; i++) {
                // Get the current value in the double list
                double value = playerList.get(j).getDoubleList().get(i);
                // Check if the value is in the range 0.0 - 0.2 and set the corresponding card
                if (value >= 0.0 && value < 0.2) {
                    playerList.get(j).setCardsList(Cards.A);
                }
                else if (value >= 0.2 && value < 0.4) {
                    playerList.get(j).setCardsList(Cards.B);
                } else if (value >= 0.4 && value < 0.6) {
                    playerList.get(j).setCardsList(Cards.C);
                } else if (value >= 0.6 && value < 0.8) {
                    playerList.get(j).setCardsList(Cards.D);
                } else if (value >= 0.8 && value <= 1.0) {
                    playerList.get(j).setCardsList(Cards.E);
                }
            }
        }
    }

    public List<Player> assignRandomsToPlayers(List<Player> playerList, List<Double> randomList) {
        // Get the size of the random number list and the number of players
        int sizeOfRandomList = randomList.size();
        int amountOfPlayers = playerList.size();
        // Calculate the number of loops needed to assign the random numbers to the players
        int numberOfLoops = sizeOfRandomList / amountOfPlayers;
        // Initialize a counter variable
        int counter = 0;

        // Iterate over each player in the list
        for (int i = 0; i < amountOfPlayers; i++) {
            // Iterate over the number of loops
            for (int j = 0; j < numberOfLoops; j++) {
                // Assign the current random number to the player's double list
                playerList.get(i).setDoubleList(randomList.get(counter));
                // Increment the counter
                counter++;
            }
        }
        // Return the updated player list
        return playerList;
    }

    public List<Double> generateListOfRandomDoubles(int size) {
        // Create a new list of doubles
        List<Double> doubleList = new ArrayList<>();
        // Create a new random number generator
        Random r = new Random();
        // Generate the specified number of random doubles
        for (int i = 0; i < size; i++) {
            doubleList.add(r.nextDouble());
        }
        // Return the generated list of random doubles
        return doubleList;
    }


    public List<Player> generatePlayers(int amount) {
        // Create a new list of players
        List<Player> playerList = new ArrayList<>();
        // Generate the specified number of players
        for (int i = 0; i < amount; i++) {
            // Create a new player with an empty list of cards
            playerList.add(new Player(new ArrayList<>()));
        }
        // Return the generated list of players
        return playerList;
    }

}
