package atmin_v5;

import atmin_v4.Observer;

public class AirConditioner {
    private int temp;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int newTemp) {
        if (newTemp >= 30)
            this.temp = 30;
        else this.temp = Math.max(newTemp, 16);
    }
}
