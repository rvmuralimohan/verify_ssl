import groovy.time.TimeCategory
import java.text.SimpleDateFormat
import java.date.*
import java.time.*
import java.util.*

public class Demo3 {

    public static void main(String[] args) {
        String dateStr ="Nov 28 20:13:06 2019";
        String dateStr2 = "Nov 30 20:13:06 2019";
        SimpleDateFormat format = new SimpleDateFormat("MMM dd H:m:s yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("MMM dd H:m:s yyyy");
        try {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);

            System.out.println("distance is :"+differentDaysByMillisecond(date,date2));
        }catch(ParseException e ){
            e.printStackTrace();
        }
    }

//get Days method

    private static int differentDaysByMillisecond(Date date, Date date2) {
        return (int)((date2.getTime()-date.getTime())/1000/60/60/24);
    }

}
