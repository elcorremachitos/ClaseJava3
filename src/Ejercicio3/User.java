package Ejercicio3;

public class User {
    private int age;
    private String gender;
    private boolean sisben;
    private int benefit;
    private int extra;

    public User(int age, String gender, boolean sisben) {
        this.age = age;
        this.gender = gender;
        this.sisben = sisben;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean isSisben() {
        return sisben;
    }


    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit) {
        this.benefit = benefit;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }
}
