public abstract class Member {

    private String name;
    private int age;
    private boolean active;
    private boolean arrears;

    public Member(String name, int age, boolean active, boolean arrears){
        this.name = name;
        this.age = age;
        this.active = active;
        this.arrears = arrears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setArrears(boolean arrears) {
        this.arrears = arrears;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getActive() {
        return active;
    }

    public boolean getArrears () {
        return arrears;
    }
}
