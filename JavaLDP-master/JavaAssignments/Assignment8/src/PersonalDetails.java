public class PersonalDetails {
    public static void validateDetails(String name, String address, String phoneNumber)  throws Exception{
        if (!name.matches("[a-zA-Z ]*"))
            throw new InvalidNameException("name must not contain digits");
        if (!address.matches("[a-zA-Z ,]*"))
            throw new InvalidAddressException("Special characters not allowed in Address");
        if (!phoneNumber.matches("[0-9]*"))
            throw new InvalidNumberException("phone number must contain only digits");
    }
}