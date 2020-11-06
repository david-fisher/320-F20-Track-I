package team8.partyinthebackend.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yulin Yang
 * @Time: 10/29/2020, Thu
 **/

public class StakeholderList {
    
    private int max_stakeholders;
    private List<Stakeholder> stakeholders;

    public StakeholderList() {
        this.max_stakeholders = 0;
        this.stakeholders = new ArrayList<Stakeholder>();
    }

    public int getNumberOfStakeholders() {
        return max_stakeholders;
    }

    public List<Stakeholder> getStakeholders() {
        return stakeholders;
    }

    public void addStakeholder(String name, String bio, String conversation) {
        this.stakeholders.add(new Stakeholder(name, bio, conversation));
        this.max_stakeholders = this.max_stakeholders + 1;
    }

}
