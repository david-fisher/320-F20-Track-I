package team8.partyinthebackend.model;

/**
 * @Author: Yulin Yang
 * @Time: 10/29/2020, Thu
 **/

public class Scenario {
    
    private int scenario_id;
    private String scenario_name;
    private String final_action;

    public Scenario(int id, String name) {
        this.scenario_id = id;
        this.scenario_name = name;
    }

    public int getId() {
        return scenario_id;
    }

    public void setId(int id) {
        this.scenario_id= id;
    }

    public String getName() {
        return scenario_name;
    }

    public void setName(String name) {
        this.scenario_name = name;
    }

    public String getFinal_action() {
        return final_action;
    }

    public void setFinal_action(String final_action) {
        this.final_action = final_action;
    }

}
