class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int aliceArrival = getDayOfYear(arriveAlice, daysInMonths);
        int aliceLeave = getDayOfYear(leaveAlice, daysInMonths);
        int bobArrival = getDayOfYear(arriveBob, daysInMonths);
        int bobLeave = getDayOfYear(leaveBob, daysInMonths);
        
        int startTogether = Math.max(aliceArrival, bobArrival);
        int endTogether = Math.min(aliceLeave, bobLeave);
        
        return Math.max(0, endTogether - startTogether + 1);
    }
    
    private int getDayOfYear(String date, int[] daysInMonths) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonths[i];
        }
        
        return totalDays;
    }
}