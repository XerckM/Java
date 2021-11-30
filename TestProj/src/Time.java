public class Time {
    private int hrs;
    private int mins;
    private int secs;
    public Time() {
      hrs = 0;
      mins = 0;
      secs = 0;
    }
    public Time(int h, int m, int s) {
      hrs = h;
      mins = m;
      secs = s;
    }
    public int getHrs() {
      return hrs;
    }
    public int getMins() {
      return mins;
    }
    public int getSecs() {
      return secs;
    }
    public void set(int h, int m, int s) {
      hrs =  (h >= 0 && h < 24)? h : 0;
      mins = (m >= 0 && m < 60)? m : 0;
      secs = (s >= 0 && s < 60)? s : 0;
    }
    public void printMilitary() {
      System.out.print((hrs < 10? "0": "") + hrs + ":");
      System.out.print((mins < 10? "0": "") + mins + ":");
      System.out.print((secs < 10? "0": "") + secs);
    }
    public void printStandard() {
      System.out.print((hrs == 0 || hrs == 12? 12: hrs % 12) + ":");
      System.out.print((mins < 10? "0": "") + mins + ":");
      System.out.print((secs < 10? "0": "") + secs + " ");
      System.out.print((hrs < 12? "AM": "PM"));
    }
    public String toString() {
      return hrs + ":" + mins + ":" + secs;
    }
    public boolean equals(Time time) {
      return (hrs == time.hrs && mins == time.mins && secs == time.secs);
    }
    public void copy(Time time) {
      hrs = time.hrs;
      mins = time.mins;
      secs = time.secs;
    }
    public Time getCopy() {
      return new Time(hrs,mins,secs); 
    }
    public void advanceSecs() { 
      secs++; 
      if(secs > 59) { 
        secs = 0; 
        mins++; 
        if(mins > 59) { 
          mins = 0; 
          hrs++; 
          if(hrs > 23) {
            hrs = 0; 
          }
        } 
      } 
    }
    public boolean lessThan(Time t) {
      return (hrs < t.hrs || hrs == t.hrs && mins < t.mins || hrs == t.hrs && mins == t.mins && secs < t.secs);
    }
    public boolean notEquals(Time otherTime) {
      return !(equals(otherTime));
    }
    public boolean lessOrEquals(Time otherTime) {
      return (lessThan(otherTime)||equals(otherTime));
    }
    public boolean greaterThan(Time otherTime) {
      return !(lessThan(otherTime));
    }
    public boolean greaterOrEquals(Time otherTime) {
      return ((!(lessThan(otherTime)))||equals(otherTime));
    }
    public void advanceHrs() { 
      hrs++; 
      if(hrs > 23) 
        hrs = 0;   
    }
    public void advanceMins() {  
      mins++; 
      if(mins > 59) { 
        mins = 0; 
        hrs++; 
        if(hrs > 23) {
          hrs = 0; 
        }
      } 
    }
    public String toMilitary() {
     return String.format("%02d:%02d:%02d",hrs,mins,secs);
    }
    public String toStandard() {
      return String.format("%02d:%02d:%02d "+((hrs/12>0)? "PM":"AM"),(hrs == 0 || hrs == 12? 12: hrs % 12),mins,secs);
    }
}