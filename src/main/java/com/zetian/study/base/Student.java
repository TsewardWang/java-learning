package com.zetian.study.base;

/**
 * Description 学生
 *
 * @author Zetian Wang
 * @date 2019/10/19
 **/
public class Student {

    /**
     * 姓名
     */
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 学号
     */
    private String num;

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    /**
     * 身高
     */
    public String height;

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    /**
     * 体重
     */
    public String weight;

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    /**
     * 成绩（保存数学，语文，英语三门成绩）
     */
    private String[] score;

    public void setScore(String[] score) {
        this.score = score;
    }

    public String[] getScore() {
        return score;
    }
}
