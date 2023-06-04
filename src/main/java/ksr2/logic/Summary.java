package ksr2.logic;

import java.util.ArrayList;
import java.util.List;

public class Summary {
    // generated summaries
    private  List<String> summaries = new ArrayList<>();
    // TODO zmienne które się łapią
//    private List<>



    public List<String> createSummaries(){
//        private lista domów, potem przeiterować wszystkie i zliczać te które załapują się w kwantyfikator a następnie możemy dodać
//        te zmienne które wynikają z tych liczb
        return this.summaries;
    }

    public List<String> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<String> summaries) {
        this.summaries = summaries;
    }
    public void addSummaries(String summary){
        this.summaries.add(summary);
    }
}
