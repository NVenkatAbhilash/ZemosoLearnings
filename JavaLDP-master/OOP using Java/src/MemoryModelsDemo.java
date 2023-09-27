class MemoryModelsDemo {
    static String staticVariable = "This is a static Variable";
    public String publicVariable = "This is a public instance Variable";
    private String privateVariable = "This is a private instance Variable";
    final static String finalStaticVariable = "This is a final static variable";
    final String finalVariable;

    MemoryModelsDemo() {
        //can be assigned only once
        finalVariable = "This is a final variable";
    }

    public static void main(String args[]){
        MemoryModelsDemo objectCreation = new MemoryModelsDemo();
    }
}
