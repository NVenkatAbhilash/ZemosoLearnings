public class Main {
    public static void main(String args[]) {
        try {
            //System.out.println("No Exception expected :");
            //PersonalDetails.validateDetails("Abhi", "near airport", "9999999999");

            //System.out.println("\ninvalid address expected :");
            //PersonalDetails.validateDetails("Abhi", "near $ airport", "9999999999");

            System.out.println("\ninvalid null exception expected :");
            PersonalDetails.validateDetails(null, "near airport", "9999999999");
        }
        catch (Exception e){
            System.out.println("Exception caught "+e.getMessage());
        }
        finally {
            System.out.println("Close all files");
        }
    }
}
