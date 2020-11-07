package com.example.cs320EthicsPlayer.model;

public class ReflectionsID implements java.io.Serializable {

    /**
     * not necessary to include will declare one at runtime, 
     * can create our own too to make warning go away
     */
    private static final long serialVersionUID = 1L;

    int s_ID;
    int c_ID;
    int e_ID;    

    public ReflectionsID(){
        super();
    }
    
    public ReflectionsID(int s_ID, int c_ID, int e_ID){
        this.s_ID=s_ID;
        this.c_ID=c_ID;
        this.e_ID=e_ID; 
    }
}
