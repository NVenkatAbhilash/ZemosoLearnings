import java.text.SimpleDateFormat;
import java.util.*;

class KYCForm{
    private Calendar signUpDate;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    KYCForm(String date){
        signUpDate = getCalendarDate(date);
    }

    private Calendar getCalendarDate(String date){
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(date));
        }catch(Exception e){
            System.out.println("date cannot be parsed");
            //throw e;
        }
        return cal;
    }

    private boolean isPossible(Calendar date){
        if(signUpDate.compareTo(date)==1)
            return false;
        return true;
    }

    private String getDate(Calendar cal){
        return sdf.format(cal.getTime());
    }

    private Calendar addDays(int numberOfDays){
        Calendar newDate = getCalendarDate(getDate(signUpDate));
        newDate.add(Calendar.DAY_OF_MONTH,numberOfDays);
        return newDate;
    }

    private static Calendar minDate(Calendar cal1,Calendar cal2){
        if(cal1.compareTo(cal2)<=0)
            return cal1;
        return cal2;
    }

    private void changeYearTo(int year){
        signUpDate.set(Calendar.YEAR,year);
    }

    public String getDateRange(String date){
        Calendar currentDate = getCalendarDate(date);
        if(!isPossible(currentDate)){
            return "No range";
        }
        changeYearTo(currentDate.get(Calendar.YEAR));
        Calendar lowDate = addDays(-30);
        Calendar maxDate = addDays(30);
        maxDate = minDate(maxDate,currentDate);
        String range = getDate(lowDate)+" "+getDate(maxDate);
        return range;
    }
}

public class Assignment4 {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean getInput = false;
        if(getInput){
            int t = sc.nextInt();
            sc.nextLine();
            for(int i=0;i<t;i++) {
                String signUpDate = sc.next();
                String currentDate = sc.next();
                sc.nextLine();
                KYCForm kyc = new KYCForm(signUpDate);
                System.out.println(kyc.getDateRange(currentDate));
            }
        }
        else {
            Tester.testAssignment4();
        }
    }
}