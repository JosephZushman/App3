package com.example.aleksej.budget;

import android.os.Parcel;
import android.os.Parcelable;

public class budget implements Parcelable {

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

    protected budget(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            budget = null;
        } else {
            budget = in.readDouble();
        }
    }

    public static final Creator<budget> CREATOR = new Creator<budget>() {
        @Override
        public budget createFromParcel(Parcel in) {
            return new budget(in);
        }

        @Override
        public budget[] newArray(int size) {
            return new budget[size];
        }
    };

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
        String str;
        str = "Budget" + "\n" + "Name: " + name + "\n"+ "Budget: $" + budget;

        return str;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        if (budget == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(budget);
        }
    }
}
