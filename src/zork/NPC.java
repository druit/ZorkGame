package zork;


class NPC {
    private String nameNPC;
    private String GuiderDescription;

    NPC() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNameNPC() {
        return nameNPC;
    }

    public void setNameNPC(String nameNPC) {
        this.nameNPC = nameNPC;
    }

    public String getGuiderDescription() {
        return GuiderDescription;
    }

    public void setGuiderDescription(String GuiderDescription) {
        this.GuiderDescription = GuiderDescription;
    }

    public NPC(String nameNPC, String GuiderDescription) {
        this.nameNPC = nameNPC;
        this.GuiderDescription = GuiderDescription;
    }
    

    
}
