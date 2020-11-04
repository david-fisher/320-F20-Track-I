package team8.partyinthebackend.model;

/**
 * @Author: Yulin Yang
 * @Time: 10/29/2020, Thu
 **/

public class Page {
    
    private String title_page;
    private String intro_page;
    private String answers;

    public Page(String title, String intro) {
        this.title_page = title;
        this.intro_page = intro;
    }

    public String getTitle() {
        return title_page;
    }

    public void setTitle(String title) {
        this.title_page = title;
    }

    public String getIntro() {
        return intro_page;
    }

    public void setIntro(String intro) {
        this.intro_page = intro;
    }
    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

}
