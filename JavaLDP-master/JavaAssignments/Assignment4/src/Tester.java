public class Tester {
    public static void test(String signUpDate,String currentDate,String expected,int testNum){
        KYCForm kyc = new KYCForm(signUpDate);
        String actual = kyc.getDateRange(currentDate);
        if(!actual.equals(expected))
            System.out.println("test "+testNum+" failed input : "+signUpDate+" "+currentDate);
    }

    public static void testAssignment4(){
        test("16-07-1998","27-06-2017","16-06-2017 27-06-2017",1);
        test("04-02-2016","04-04-2017","05-01-2017 06-03-2017",2);
        test("04-05-2017","04-04-2017","No range",3);
        test("04-04-2015","04-04-2016","05-03-2016 04-04-2016",4);
        test("04-04-2015","15-03-2016","05-03-2016 15-03-2016",5);
        System.out.println("Tests completed");
    }
}
/*
5
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016

output:
16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016

 */