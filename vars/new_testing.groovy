import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Demo3 {
 
    public static void main(String[] args) {
       System.out.println("~~~~~~~~~~~~~~~~~~START~~~~~~~~~~~~~~~~~~");
        String dateStr ="Nov 28 20:13:06 2019";
        String dateStr2 = "Nov 30 20:13:06 2019";
        SimpleDateFormat format = new SimpleDateFormat("MMM dd H:m:s yyyy");
        try {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);
 
            System.out.println("Number of days :: " + differentDaysByMillisecond(date,date2));
        }catch(ParseException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~");
    }
 
    private static int differentDaysByMillisecond(Date date, Date date2) {
        return (int)((date2.getTime()-date.getTime())/1000/60/60/24);
    }
}
 
