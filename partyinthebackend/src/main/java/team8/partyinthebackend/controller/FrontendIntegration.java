package team8.partyinthebackend.controller;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import team8.partyinthebackend.controller.EthicsApplicationTestPlan.Data;
import team8.partyinthebackend.model.Page;
import team8.partyinthebackend.model.Scenario;
import team8.partyinthebackend.model.StakeholderList;
import team8.partyinthebackend.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJendex
 * @Time: 10/28/2020, Wed
 **/

@RestController
public class FrontendIntegration {
	
    /**
     * While we are not able to use the interfaces from database team right now and creating a database locally is too cumbersome, we have made this class as 
     * an alternative of the really database and we hope this will simplify the process of writing test code of controller methods for everyone. As the tradoff,
     * we can not perform data retrieval easily here as we usually do with the really databases, so most database functions listed in the Test Plans doc would not
     * be reproduced or simulated here. However, since we are assuming all functions from database team are correct and workable and we are just testing our own
     * controller methords, we can just ignore the retrieval process, create the possible result objects (assuming they are correct outputs from database functions)
     * inside the below class and encapsulate them as JSON objects in the controller methods.
     */
    public static class Data {
        //simulation of students table in the database
        public static List<Student> students = new ArrayList<Student>(){
            {
                add(new Student(1, "Keven"));
                add(new Student(2, "Lily"));
                add(new Student(3, "Jack"));
                add(new Student(4, "Cindy"));
                add(new Student(5, "Peter"));
            }
        };
        static {
            students.get(0).addCourse(4, "scenario_4");
            students.get(1).addCourse(1, "scenario_1");
            students.get(1).addCourse(2, "scenario_2");
        }

        //simulation of pages table in the database
        public static Page page = new Page("This is a title", "Introduction goes here.");
        public static Page initialreflection = new Page("This is a reflection", "reflect on this");

        //simulation of stakeholders in the database
        public static StakeholderList stakeholders = new StakeholderList();
        static {
            stakeholders.addStakeholder("steve", "first stakeholder", "the conversation with steve.");
            stakeholders.addStakeholder("john", "second stakeholder", "the conversation with john.");
        }
    }

    /**
     * (GET) introduction
     */

    @GetMapping(value = "/scenario/{scenario_id}/{version_id}/introduction")
    public JSONObject getIntroduction(@PathVariable int scenario_id, @PathVariable int version_id){
        try {
            JSONObject rst = new JSONObject();
            rst.put("text", "Ultrices gravida dictum fusce ut. At lectus urna duis convallis convallis tellus id interdum. Faucibus in ornare quam viverra orci. Sit amet tellus cras adipiscing enim eu turpis egestas pretium. Pellentesque elit eget gravida cum sociis natoque. Aliquet eget sit amet tellus cras adipiscing enim. Fermentum odio eu feugiat pretium nibh ipsum consequat nisl vel. Orci nulla pellentesque dignissim enim sit amet.\n" + "\n" + "Sit amet mattis vulputate enim nulla aliquet porttitor lacus luctus. Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing. ");
            rst.put("page_title", "Introduction Page");
            JSONObject obj = new JSONObject();
            obj.put("body", rst);
            obj.put("status_code", 200);
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }
    
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/initialreflection")
    public JSONObject getInitialReflection(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) {
        try {
            JSONObject obj = new JSONObject();
            String scenario_page = scenario_id+version_id+"initialreflection";
            Data.initialreflection.setAnswers(Data.students.get(student_id-1).getAnswer(scenario_page));
            obj.put("body", Data.initialreflection);
            obj.put("status_code", 200);
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }
    /**
     * (PUT) puts a students answer to the initial reflection in the student dummy object
     */

    @PutMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/initialreflection")
    public @ResponseBody JSONObject updateOneStudent(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @RequestParam String response) {
        try {
            JSONObject obj = new JSONObject();
            //creates a unique scenario version and page string
            String scenario_page = scenario_id+version_id+"initialreflection";
            Data.students.get(student_id-1).putAnswer(scenario_page, response);
            obj.put("status_code", 200);
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }


//    @PutMapping(value = "/students/{id}")
//    public @ResponseBody Student updateOneStudent(@PathVariable int id, @RequestParam String name) {
//        Data.students.get(id-1).setName(name);
//        return Data.students.get(id-1);
//    }
}
