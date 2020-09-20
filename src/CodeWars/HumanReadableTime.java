package CodeWars;

class HumanReadableTime {
    public static void main(String[] args) {
        System.out.println(makeReadable(359999));
    }


    public static String makeReadable(int seconds) {
        int min = 0, hrs = 0;
        if (seconds > 59) {
            min = seconds / 60;
        }
        if (min > 59) {
            hrs = min / 60;
        }
        min = min - hrs * 60;
        seconds = seconds - min * 60 - (hrs * 60 * 60);
        String rtn = "";
        if (seconds < 10) {
            rtn += "0";
        }
        rtn += seconds;
        String temp = "";
        if (min < 10) {
            temp = "0";
        }
        temp += min + ":";
        rtn = temp + rtn;
        temp = "";
        if (hrs < 10) {
            temp = "0";
        }
        temp += hrs + ":";
        rtn = temp + rtn;
        return rtn;
    }
}
