package com.company;

public class Swordsman{
    private double life_count;
    private double hit_strength;

    public double getLife_count() {
        return life_count;
    }

    public void setLife_count(double life_count) {
        this.life_count = life_count;
    }

    public double getHit_strength() {
        return hit_strength;
    }

    public void setHit_strength(double hit_strength) {
        this.hit_strength = hit_strength;
    }

    public Swordsman() {
        this.life_count = 40;
        this.hit_strength = 10;
    }

    public void getHit(double damage_amount){
        damage_amount = damage_amount - (damage_amount * 0.15);
        double life_countAfterdamage = getLife_count() - damage_amount;
        if(life_countAfterdamage > 0 ){
            setLife_count(life_countAfterdamage);
        } else {
            //dead
            setLife_count(0);
        }
    }
    public void attack(Archer archer){
        archer.getHit(getHit_strength());
    }

    @Override
    public String toString() {
        return "Swordsman's " +
                "remaining life count: " + getLife_count() +
                ", hit strength: " + getHit_strength() + "\n";
    }
}
