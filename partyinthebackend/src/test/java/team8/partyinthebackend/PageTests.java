package team8.partyinthebackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import team8.partyinthebackend.model.Page;

public class PageTests {
    
    public List<Page> pages = new ArrayList<Page>();
    Page p1 = new Page(500, 1, "Test1");
    Page p2 = new Page(600, 2, "Test2");
    Page p3 = new Page(700, 3, "Test3");

    public void setup(){
        pages.add(p1);
        pages.add(p2);
        pages.add(p3);
    }

    @Test
    public void testGetVersion(){
        this.setup();
        assertEquals(3, pages.get(2).getVersion());
        assertEquals(2, pages.get(1).getVersion());
        assertEquals(1, pages.get(0).getVersion());
    }

    @Test
    public void testGetBody(){
        this.setup();
        assertEquals("Test3", pages.get(2).getBody());
        assertEquals("Test2", pages.get(1).getBody());
        assertEquals("Test1", pages.get(0).getBody());
    }

    @Test
    public void testAnswers(){
        this.setup();
        String answer1 = "42";
        String answer2 = "Flayn's got us trapped in the McDonald's PlayPlace. We're currently in the bubble facing the dining area, do you see us waving at you? Please, get us out - we haven't eaten our order yet.";
        String answer3 = "egassem sdrawkcaB ,egassem sdrawkcaB ,egassem sdrawkcaB";
        pages.get(0).setAnswer(answer3);
        pages.get(2).setAnswer(answer1);
        pages.get(1).setAnswer(answer2);
        assertEquals(answer1, pages.get(2).getAnswer());
        assertEquals(answer2, pages.get(1).getAnswer());
        assertEquals(answer3, pages.get(0).getAnswer());
    }

}
