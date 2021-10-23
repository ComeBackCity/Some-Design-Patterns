public class time {
    int min;
    int sec;

    public time() {
    }

    public time(int min, int sec) {
        this.min = min;
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    int total_time()
    {
        return 60 * min + sec;
    }

    @Override
    public String toString() {
        return min + ":" + sec;
    }
}
