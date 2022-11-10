import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private List<Double> doubleList;
    private List<Cards> cardsList = new ArrayList<>();
    private List<Long> repetitionList = new LinkedList<>();

    private Long sumOfSequence;



    public Player(List<Double> doubleList) {
        this.doubleList = doubleList;
    }

    public List<Double> getDoubleList() {
        return doubleList;
    }

    public void setDoubleList(Double r) {
        this.doubleList.add(r);
    }

    public List<Cards> getCardsList() {
        return cardsList;
    }

    public void setCardsList(Cards card) {
        this.cardsList.add(card);
    }

    public void setRepetitionList(Long l) {
        this.repetitionList.add(l);
    }

    public List<Long> getRepetitionList() {
        return repetitionList;
    }

    public Long getSumOfSequence() {
        return sumOfSequence;
    }

    public void setSumOfSequence() {
        sumOfSequence = 0L;
        for (int i = 0; i < repetitionList.size(); i++) {
            sumOfSequence += repetitionList.get(i);
        }

        this.sumOfSequence = sumOfSequence;
    }

    @Override
    public String toString() {
        return "\nPlayer{" +
                "repetitionList=" + repetitionList +
                " " + sumOfSequence +
                '}';
    }
}
