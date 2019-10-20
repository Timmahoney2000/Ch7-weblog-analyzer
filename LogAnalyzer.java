
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    /**
     * Method for busiest hour
     */
    public int busiestHour()
    {
        
        int maxHour = 0;
        for(int hour = 1; hour < hourCounts.length; hour++)
        {
            // value comparison- hourCounts of exact hour to max hour
            if(hourCounts[hour] > hourCounts[maxHour])
            {
                maxHour = hour;
            }
        }
        return maxHour;
    }

    /**
     * Method for quietest hour
     */
  

    /**
     * Method for finding busiest 2 hour period
     */
    public int busiestHour()
    {
        int busiestHour(int[] hourCounts);
        {
            int busiestOne = 0;
            int busiestTwo = 0;
            for(int n:hourCounts){
                if(busiestOne < n){
                    busiestTwo = busiestOne;
                    busiestOne = n;
                } else if(busiestTwo < n){
                    busiestTwo = n;
                }
            }
        // put your code here
        return busiestOne;
    }
}



    /**
     * Modification to accept a string
     *
     * 
     */
    public LogAnalyzer(String fileName)
    {
        // Create array object to hold the hourly
        // access counts
        hourCounts = new int[24];
        // Create reader to get data
        reader = new LogfileReader(fileName);
    
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Returns the number of accesses
     */
    public int numberOfAccesses()
    {
        
        int total = 0;
        for(int hour = 0; hour < hourCounts.length; hour++) {
            total += hourCounts[hour];
        }
        return total;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String [] args)
    {
        // Main method of LogAnalyzer class
        LogAnalyzer analyze = new LogAnalyzer();
        analyze.analyzeHourlyData();
        int numberofAccesses = analyze.numberOfAccesses();
        System.out.println("Number of Accesses:" + numberofAccesses);
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
