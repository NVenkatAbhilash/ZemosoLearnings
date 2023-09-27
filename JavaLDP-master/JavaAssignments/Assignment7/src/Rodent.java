public abstract class Rodent {
    abstract void displayAppearence();

    abstract void nativeAreas();

    abstract void fact();

    public void display(){
        this.displayAppearence();
        this.nativeAreas();
        this.fact();
        System.out.println();
    }
}

class Mouse extends Rodent {
    Mouse() {
        System.out.println("Mouse created");
    }

    public void displayAppearence() {
        System.out.println("Mouse have long tail and no cheek pouches");
    }

    public void nativeAreas() {
        System.out.println("Mouse are found world wide");
    }

    public void fact() {
        System.out.println("Mouse heart can beat 700 times a minute");
    }
}

class Rat extends Rodent {
    Rat() {
        System.out.println("Rat created");
    }

    public void displayAppearence() {
        System.out.println("Rat have long tail and no cheek pouches");
    }

    public void nativeAreas() {
        System.out.println("Rat are found world wide");
    }

    public void fact() {
        System.out.println("Rat can swim underwater");
    }
}

class Hamster extends Rodent {
    Hamster() {
        System.out.println("Hamster created");
    }

    public void displayAppearence() {
        System.out.println("Hamster have short tail and cheek pouches");
    }

    public void nativeAreas() {
        System.out.println("Hamster are found in Asia and Europe");
    }

    public void fact() {
        System.out.println("Hamster has poor eyesight but keen hearing");
    }
}
