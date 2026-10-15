package itogHash;

import java.util.Arrays;

public class Shop {
    public final Integer[] masiv =new Integer[10];
    private int car;

    public Shop(){

    }
    public Shop addCar(int car){
        this.car =car;
        return this;
    }
    public int addPark(){
        int start = car % masiv.length;

        for (int i = 0; i < masiv.length; i++) {
            int pos = (start + i) % masiv.length;
            if (masiv[pos] == null) {
                masiv[pos] = car;
                return pos;
            }
        }
        return -1;
    }
    public void remove(int index){
        masiv[index] = null;
    }

    @Override
    public String toString() {
        return String.format("Места %s", Arrays.toString(masiv));
    }
}
