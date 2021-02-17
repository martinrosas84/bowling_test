package com.jobsicty.bowling.game;

public class Frame implements IFrame {
    private String first;
    private String second;
    private String third;
    private Boolean isLast = false;
    private Boolean isSpare;
    private Boolean isStrike;

    public void calculate(){
        if(this.first.equals("10")) {
            this.isStrike = true;
            this.isSpare = false;
        } else if(this.second.equals("10")) {
            this.isStrike = false;
            this.isSpare = true;
        }
        else if(!this.first.equals("F") && !this.second.equals("F")){
            Integer sum = Integer.parseInt(this.first) + Integer.parseInt(this.second);
            if(sum == 10){
                this.isStrike = false;
                this.isSpare = true;
            } else {
                this.isStrike = false;
                this.isSpare = false;
            }
        } else {
            this.isStrike = false;
            this.isSpare = false;
        }
    }

    public String getFirst() {
        if(this.first != null){
            return first;
        } else {
            return "";
        }
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        if(this.second != null){
            return second;
        } else {
            return "";
        }
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        if(this.third != null){
            return third;
        } else {
            return "";
        }
    }

    public void setThird(String third) {
        this.third = third;
    }

    public Boolean getIsLast() {
        return isLast;
    }

    public void setIsLast(Boolean isLast) {
        this.isLast = isLast;
    }

    public Boolean isSpare(){
        return this.isSpare;
    }
    
    public Boolean isStrike(){
        return this.isStrike;
    }

    @Override
    public String toString() {
        String third = this.getIsLast() ? "\t " + this.getThird() : "";
        String str = this.getFirst() + "\t " + this.getSecond() + third;
        return str;
    }
}
