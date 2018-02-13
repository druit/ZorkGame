package zork;

import java.io.Serializable;


class Items implements Serializable{

    private String ItemName;
    private String RoomHasItem;
    private String RoomUseItem;
    private String Verb;
    private String Noun;
    private String AfterAction;
    private String BeforeAction;
    private String TrueorFalse;
    private String ItemForAction;
    private String RoomUseActionItem;






    
    public Items(String RoomHasItem, String RoomUseItem, String ItemName,String Verb,String Noun,String AfterAction,String BeforeAction,String TrueorFalse,String ItemForAction,String RoomUseActionItem) {
        this.ItemName = ItemName;
        this.RoomHasItem = RoomHasItem;
        this.RoomUseItem = RoomUseItem;
        this.Verb = Verb;
        this.Noun = Noun;
        this.AfterAction = AfterAction;
        this.BeforeAction = BeforeAction;
        this.TrueorFalse = TrueorFalse;
        this.ItemForAction = ItemForAction;
        this.RoomUseActionItem = RoomUseActionItem;
        
    }


    
      public Items(){
        
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
   

    public String getRoomHasItem() {
        return RoomHasItem;
    }

    public void setRoomHasItem(String RoomHasItem) {
        this.RoomHasItem = RoomHasItem;
    }

    public String getRoomUseItem() {
        return RoomUseItem;
    }

    public void setRoomUseItem(String RoomUseItem) {
        this.RoomUseItem = RoomUseItem;
    }
    
        public String getVerb() {
        return Verb;
    }

    public void setVerb(String Verb) {
        this.Verb = Verb;
    }

    public String getNoun() {
        return Noun;
    }

    public void setNoun(String Noun) {
        this.Noun = Noun;
    }

    public String getAfterAction() {
        return AfterAction;
    }

    public void setAfterAction(String AfterAction) {
        this.AfterAction = AfterAction;
    }

    public String getBeforeAction() {
        return BeforeAction;
    }

    public void setBeforeAction(String BeforeAction) {
        this.BeforeAction = BeforeAction;
    }

    public String getTrueorFalse() {
        return TrueorFalse;
    }

    public void setTrueorFalse(String TrueorFalse) {
        this.TrueorFalse = TrueorFalse;
    }
    public String getItemForAction() {
        return ItemForAction;
    }

    public void setItemForAction(String ItemForAction) {
        this.ItemForAction = ItemForAction;
    }
    public String getRoomUseActionItem() {
        return RoomUseActionItem;
    }

    public void setRoomUseActionItem(String RoomUseActionItem) {
        this.RoomUseActionItem = RoomUseActionItem;
    }

  
    
}
