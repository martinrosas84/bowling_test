package com.jobsicty.bowling.game;

import java.util.List;

public class Scorer {

    private List<IFrame> frames;
    private Integer oneFrame;
    private Integer twoFrame;
    private Integer threeFrame;
    private Integer fourFrame;
    private Integer fiveFrame;
    private Integer sixFrame;
    private Integer sevenFrame;
    private Integer eightFrame;
    private Integer nineFrame;
    private Integer tenFrame;

    public void calculate(){
        IFrame one = this.frames.get(0);
        IFrame two = this.frames.get(1);
        IFrame three = this.frames.get(2);
        IFrame four = this.frames.get(3);
        IFrame five = this.frames.get(4);
        IFrame six = this.frames.get(5);
        IFrame seven = this.frames.get(6);
        IFrame eight = this.frames.get(7);
        IFrame nine = this.frames.get(8);
        IFrame ten = this.frames.get(9);

        this.setOneFrame(this.getResult(one, two, three));
        this.setTwoFrame(this.getOneFrame() + this.getResult(two, three, four));
        this.setThreeFrame(this.getTwoFrame() + this.getResult(three, four, five));
        this.setFourFrame(this.getThreeFrame() + this.getResult(four, five, six));
        this.setFiveFrame(this.getFourFrame() + this.getResult(five, six, seven));
        this.setSixFrame(this.getFiveFrame() + this.getResult(six, seven, eight));
        this.setSevenFrame(this.getSixFrame() + this.getResult(seven, eight, nine));
        this.setEightFrame(this.getSevenFrame() + this.getResult(eight, nine, ten));
        this.setNineFrame(this.getEightFrame() + this.getResult(nine, ten));
        this.setTenFrame(this.getNineFrame() + this.getResult(ten));
    }

    private Integer getResult(IFrame first, IFrame second, IFrame third) {
        if(first.isStrike()){
            if(second.isStrike()){

                if(third.isStrike()){
                    return 30;
                } else {
                    Integer n = 0;
                    if(!third.getFirst().equals("F")){
                        n = Integer.parseInt(third.getFirst());
                    } else if(!third.getSecond().equals("F")){
                        n = Integer.parseInt(third.getSecond());
                    }
                    return 20 + n;
                }

            } else if(second.isSpare()) {
                return 20;
            } else {
                Integer n = 0;
                if(!second.getFirst().equals("F")){
                    n = Integer.parseInt(second.getFirst());
                } else if(!second.getSecond().equals("F")){
                    n = Integer.parseInt(second.getSecond());
                }
                return 10 + n;
            }
        } else if(first.isSpare()) {
            if(second.isStrike()) {
                return 20;
            } else {
                Integer firstNum = second.getFirst().equals("F") ? 0 : Integer.parseInt(second.getFirst());
                return 10 + firstNum;
            }
        } else {
            Integer n = 0;
            if(!first.getFirst().equals("F")){
                n = Integer.parseInt(first.getFirst());
            }
            if(!first.getSecond().equals("F")){
                n = n + Integer.parseInt(first.getSecond());
            }
            return n;
        }
    }

    private Integer getResult(IFrame first, IFrame second) {
        if(first.isStrike()){
            if(second.getFirst().equals("10")){

                if(second.getSecond().equals("10")){
                    return 30;
                } else {
                    Integer n = 0;
                    if(!second.getSecond().equals("F")){
                        n = Integer.parseInt(second.getSecond());
                    } else if(!second.getThird().equals("F")){
                        n = Integer.parseInt(second.getThird());
                    }
                    return 20 + n;
                }

            } else {
                Integer n = 0;
                if(!second.getFirst().equals("F")){
                    n = Integer.parseInt(second.getFirst());
                } else if(!second.getSecond().equals("F")){
                    n = Integer.parseInt(second.getSecond());
                }
                return 10 + n;
            }
        } else if(first.isSpare()) {
            return 20;
        } else {
            Integer n = 0;
            if(!first.getFirst().equals("F")){
                n = Integer.parseInt(first.getFirst());
            }
            if(!first.getSecond().equals("F")){
                n = n + Integer.parseInt(first.getSecond());
            }
            return n;
        }
    }

    private Integer getResult(IFrame first) {
        if(first.getFirst().equals("10")){
            if(first.getSecond().equals("10")){

                if(first.getThird().equals("10")){
                    return 30;
                } else {
                    Integer n = 0;
                    if(!first.getSecond().equals("F")){
                        n = Integer.parseInt(first.getSecond());
                    } else if(!first.getThird().equals("F")){
                        n = Integer.parseInt(first.getThird());
                    }
                    return 20 + n;
                }

            } else {
                Integer n = 0;
                if(!first.getSecond().equals("F")){
                    n = Integer.parseInt(first.getSecond());
                } else if(!first.getThird().equals("F")){
                    n = Integer.parseInt(first.getThird());
                }
                return 10 + n;
            }
        } else {
            Integer n = 0;
            if(!first.getFirst().equals("F")){
                n = Integer.parseInt(first.getFirst());
            }
            if(!first.getSecond().equals("F")){
                n = n + Integer.parseInt(first.getSecond());
            }
            return n;
        }
    }

    public List<IFrame> getFrames() {
        return frames;
    }

    public void setFrames(List<IFrame> frames) {
        this.frames = frames;
    }

    public Integer getOneFrame() {
        return oneFrame;
    }

    public void setOneFrame(Integer oneFrame) {
        this.oneFrame = oneFrame;
    }

    public Integer getTwoFrame() {
        return twoFrame;
    }

    public void setTwoFrame(Integer twoFrame) {
        this.twoFrame = twoFrame;
    }

    public Integer getThreeFrame() {
        return threeFrame;
    }

    public void setThreeFrame(Integer threeFrame) {
        this.threeFrame = threeFrame;
    }

    public Integer getFourFrame() {
        return fourFrame;
    }

    public void setFourFrame(Integer fourFrame) {
        this.fourFrame = fourFrame;
    }

    public Integer getFiveFrame() {
        return fiveFrame;
    }

    public void setFiveFrame(Integer fiveFrame) {
        this.fiveFrame = fiveFrame;
    }

    public Integer getSixFrame() {
        return sixFrame;
    }

    public void setSixFrame(Integer sixFrame) {
        this.sixFrame = sixFrame;
    }

    public Integer getSevenFrame() {
        return sevenFrame;
    }

    public void setSevenFrame(Integer sevenFrame) {
        this.sevenFrame = sevenFrame;
    }

    public Integer getEightFrame() {
        return eightFrame;
    }

    public void setEightFrame(Integer eightFrame) {
        this.eightFrame = eightFrame;
    }

    public Integer getNineFrame() {
        return nineFrame;
    }

    public void setNineFrame(Integer nineFrame) {
        this.nineFrame = nineFrame;
    }

    public Integer getTenFrame() {
        return tenFrame;
    }

    public void setTenFrame(Integer tenFrame) {
        this.tenFrame = tenFrame;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score \t \t");
        sb.append(this.getOneFrame());
        sb.append("\t \t");
        sb.append(this.getTwoFrame());
        sb.append("\t \t");
        sb.append(this.getThreeFrame());
        sb.append("\t \t");
        sb.append(this.getFourFrame());
        sb.append("\t \t");
        sb.append(this.getFiveFrame());
        sb.append("\t \t");
        sb.append(this.getSixFrame());
        sb.append("\t \t");
        sb.append(this.getSevenFrame());
        sb.append("\t \t");
        sb.append(this.getEightFrame());
        sb.append("\t \t");
        sb.append(this.getNineFrame());
        sb.append("\t \t");
        sb.append(this.getTenFrame());
        return sb.toString();
    }
    
}
