package br.com.ySelf.modal;

public enum ESloopFaceDirection {
    
    RIGHT(1),
    LEFT(-1),
    MID(0);
    
    private int flag;
    
    private ESloopFaceDirection(int flag) {
        this.flag = flag;
    }
    
    public int getFlag() {
       return flag;
    }
    
    public int getInvFlag() {
       return flag * -1;
    }
    
    public boolean isMid() {
        return this == MID;
    }
    
    public static ESloopFaceDirection get(double sloopFace) {
        return sloopFace < 0 ? LEFT : sloopFace > 0 ? RIGHT : MID; 
    }
}
