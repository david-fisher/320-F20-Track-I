package team8.partyinthebackend.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yulin Yang
 * @Time: 10/29/2020, Thu
 **/

public class Courses {
    
    private List<Scenario> scenarios;

    public Courses() {
        this.scenarios = new ArrayList<Scenario>();
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void addScenario(int id, String name) {
        this.scenarios.add(new Scenario(id, name));
    }
}
