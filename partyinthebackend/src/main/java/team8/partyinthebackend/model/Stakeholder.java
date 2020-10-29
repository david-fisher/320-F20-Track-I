package team8.partyinthebackend.model;


public class Stakeholder {

    private String name;
    private String bio;
    private String conversation;

    public Stakeholder(String name, String bio, String conversation) {
        this.name = name;
        this.bio = bio;
        this.conversation = conversation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getConversation(){
        return conversation;
    }

    public void setConversation(String conversation){
        this.conversation = conversation;
    }

}
