package Lotto;

import java.util.HashSet;

public class Lotto {
    private HashSet<Integer> lottoNums;

    public Lotto(HashSet<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }
    
    public HashSet<Integer> getLotto() {
        return this.lottoNums;
    }

    public void setLotto(HashSet<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }
    
}
