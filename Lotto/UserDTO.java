package Lotto;

import java.util.ArrayList;

public class UserDTO {
    private String id;
    private String pw;
    ArrayList<Lotto> lottoList = null;


    public UserDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return this.pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public ArrayList<Lotto> getLottoList() {
        return this.lottoList;
    }

    public void setLottoList(ArrayList<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    
}
