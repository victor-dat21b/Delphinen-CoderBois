public abstract class Member { //Lasse

    private String name;
    private int age;
    private boolean active;
    private boolean arrears;

    public Member(String name, int age, boolean active, boolean arrears) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.arrears = arrears;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getActive() {
        return active;
    }

    public boolean getArrears() {
        return arrears;
    }


    @Override
    public String toString() {
        return "Navn: " + name + ". Alder: " + age + ". Aktiv: " + active + ". Restance: " + arrears + "\n";
    }
}
