package com.example.project;

public class Atom {
    private String name;
    private String type;
    private int atomNumber;


    public Atom(){
        name="No name";
        type="No type";
        atomNumber=0;
    }

    public Atom(String n, String t, int a)
    {
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

    @Override
    public String toString() {
        return name;
    }

}
