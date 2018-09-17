import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) {
        //第一步：将字符串（2013-02-18 10:53:10）转换成日期Date
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sdate="2018-09-9 12:34:10";
        Date date= null;
        try {
            date = sdf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        System.out.println(Math.round(-7.2));
        //第二步：将日期Date转换成字符串String
        DateFormat  sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sdate2=sdf2.format(date);
        System.out.println(sdate2);
    }
}
