package team8.partyinthebackend.model;

/**
 * @Author: Yulin Yang
 * @Time: 10/29/2020, Thu
 **/

public class Page {
    
    private String title_page;
    private String intro_page;
    private String questions_asked;

    public Page(String page_title, String text) {
        this.title_page = page_title;
        this.intro_page = text;
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
        return questions_asked;
    }

    public void setAnswers(String questions_asked) {
        this.questions_asked = questions_asked;
    }

}
