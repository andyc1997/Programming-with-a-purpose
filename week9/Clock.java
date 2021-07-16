/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Clock {
    private int hour;
    private int minute;

    public Clock(int h, int m) {
        // Class variable
        hour = h;
        minute = m;
        // Handle exception
        if ((hour < 0) || (hour > 23))
            throw new IllegalArgumentException("the hour must be between 0 and 23");
        if ((minute < 0) || (minute > 59))
            throw new IllegalArgumentException("the minute must be between 0 and 59");
    }

    public Clock(String s) {
        // Handle exception
        if ((s.length() != 5) || (s.charAt(2) != ':'))
            throw new IllegalArgumentException("Invalid time format");
        // Class variable
        hour = Integer.parseInt(s.substring(0, 2));
        minute = Integer.parseInt(s.substring(3, 5));
        // Handle exception
        if ((hour < 0) || (hour > 23))
            throw new IllegalArgumentException("the hour must be between 0 and 23");
        if ((minute < 0) || (minute > 59))
            throw new IllegalArgumentException("the minute must be between 0 and 59");
    }

    public String toString() {
        String strHour;
        String strMinute;

        if (hour < 10) {
            strHour = "0" + hour;
        }
        else {
            strHour = Integer.toString(hour);
        }

        if (minute < 10) {
            strMinute = "0" + minute;
        }
        else {
            strMinute = Integer.toString(minute);
        }

        return strHour + ":" + strMinute;
    }

    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) return true;
        if ((hour == that.hour) && (minute < that.minute)) return true;
        return false;
    }

    public void tic() {
        minute++;
        if (minute == 60) {
            hour++;
            minute = 0;
            if (hour == 24) hour = 0;
        }
    }

    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Negative delta");
        
        minute += delta;
        
        if (minute >= 60) {
            int addHour = Math.floorDiv(minute, 60);
            hour += addHour;
            minute = minute % 60;
            if (hour > 23) hour = hour % 24;
        }
    }

    public static void main(String[] args) {
        Clock newClock = new Clock(23, 59);
        Clock newClockII = new Clock("00:00");
        System.out.println(newClock.toString());
        newClock.toc(1440);
        System.out.println(newClock.toString());
        System.out.println(newClockII.isEarlierThan(newClock));
        newClockII.tic();
        System.out.println(newClockII.toString());
    }
}
