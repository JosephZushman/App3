package com.example.aleksej.budget;

public class budget {

    String name;
    Double budget;

    public budget(){
        name = "";
        budget = 0.0;
    }
    public budget (String n, double b){
        name = n;
        budget = b;
    }

    public Double getBudget(){
        return budget;
    }
    public String getName(){

        return name;
    }
    public void setName(String n){

        name = n;
    }
    public void setBudget(Double b){

        budget = b;
    }
    public String toString(){
        return "Budget = name: " + name + " Budget: $" + budget;
    }
}
