package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Atom {

    @SerializedName("ID")
    String Id;
    @SerializedName("name")
    private String name;

    @SerializedName("category")
    private String type;

    @SerializedName("cost")
    private int atomNumber;



    public Atom(){
        Id="No id";
        name="No name";
        type="No type";
        atomNumber=0;
    }

    public Atom(String i, String n, String t, int a)
    {
        Id=i;
        name=n;
        type=t;
        atomNumber=a;
    }

    public String info(){
        String tmp = new String();
        tmp+= "Name:" + name + " Type:"  + type + "  Atomic number: " + atomNumber;
        return tmp;
    }

    public void setName(String n){
        name=n;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getId(){
        return Id;
    }
    public void setID(String Id){
        this.Id=Id;
    }

    @Override
    public String toString() {
        return name;
    }

}
