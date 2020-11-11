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
@CrossOrigin
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
        public static Page initialreflection = new Page("Initial reflection page", "reflect on this");
        public static Page initialactions = new Page("Initial action page", "Initial action text");
        public static Page finalaction = new Page("Final action page", "Final action text");

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

    /**
     * (GET) project task assignment
     */
    @GetMapping(value = "/scenario/{scenario_id}/{version_id}/pta")
    public JSONObject getPTA(@PathVariable int scenario_id, @PathVariable int version_id){
        try {
            JSONObject rst = new JSONObject();
            rst.put("text", "Ultrices gravida dictum fusce ut. At lectus urna duis convallis convallis tellus id interdum. Faucibus in ornare quam viverra orci. Sit amet tellus cras adipiscing enim eu turpis egestas pretium. Pellentesque elit eget gravida cum sociis natoque. Aliquet eget sit amet tellus cras adipiscing enim. Fermentum odio eu feugiat pretium nibh ipsum consequat nisl vel. Orci nulla pellentesque dignissim enim sit amet.\n" + "\n" + "Sit amet mattis vulputate enim nulla aliquet porttitor lacus luctus. Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing. ");
            rst.put("page_title", "Project Task Assignment Page");
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

    /**
     * (GET) gather information
     */
    @GetMapping(value = "/scenario/{scenario_id}/{version_id}/gi")
    public JSONObject getGI(@PathVariable int scenario_id, @PathVariable int version_id){
        try {
            JSONObject rst = new JSONObject();
            rst.put("text", "Ultrices gravida dictum fusce ut. At lectus urna duis convallis convallis tellus id interdum. Faucibus in ornare quam viverra orci. Sit amet tellus cras adipiscing enim eu turpis egestas pretium. Pellentesque elit eget gravida cum sociis natoque. Aliquet eget sit amet tellus cras adipiscing enim. Fermentum odio eu feugiat pretium nibh ipsum consequat nisl vel. Orci nulla pellentesque dignissim enim sit amet.\n" + "\n" + "Sit amet mattis vulputate enim nulla aliquet porttitor lacus luctus. Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing. ");
            rst.put("page_title", "Gather Information Page");
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
    
    /**
     * (GET) initial reflection
     */
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
     * (GET) initial action
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/initialaction")
    public JSONObject getInitialAction(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) {
        try {
            JSONObject obj = new JSONObject();
            String scenario_page = scenario_id+version_id+"initialreflection";
            Data.initialactions.setAnswers(Data.students.get(student_id-1).getAnswer(scenario_page));
            obj.put("body", Data.initialactions);
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
     * (GET) consequences
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/consequences")
    public JSONObject getConsequences(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 200);
            obj.put("summary_text", "Nice job. Probably. This is just filler text, so I don't have a way to know.");
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            JSONObject blank = new JSONObject();
            obj.put("status_code", 404);
            obj.put("summary_text", blank);
            return obj;
        }
    }

    /**
     * (GET) radar plot
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/finalscore")
    public JSONObject getRadarPlot(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 200);
            JSONObject rPlot = new JSONObject();
            rPlot.put("field1", 1);
            rPlot.put("field2", 4);
            rPlot.put("field3", 5);
            rPlot.put("field4", 3);
            rPlot.put("field5", 2);
            rPlot.put("field6", 2);
            obj.put("body", rPlot);
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            JSONObject blank = new JSONObject();
            obj.put("status_code", 404);
            obj.put("body", blank);
            return obj;
        }
    }

    /**
     * (GET) Choose Final Action
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/finalaction")
    public JSONObject getFinalAction(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("body", "Final action question");
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
     * (POST) posts a students answer to the initial reflection 
     */
    @PostMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/initialreflection")
    public @ResponseBody JSONObject postInitialReflection(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @RequestParam String response) {
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
    
    /**
     * (POST) posts a students answer to the initial action
     */
    @PostMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/initialaction")
    public @ResponseBody JSONObject postInitialAction(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @RequestParam String response) {
        try {
            JSONObject obj = new JSONObject();
            //creates a unique scenario version and page string
            String scenario_page = scenario_id+version_id+"initialaction";
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

    /**
     * (POST) posts a students answer to the feedback section
     */
    @PostMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/feedback")
    public @ResponseBody JSONObject updateFeedbackResponse(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @RequestParam String response) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("feedback_response", "Pretty engaging scenario, 8/10, would take again.");
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 400);
            return obj;
        }
    }

    /**
     * (POST) Reflection on consequences student response
     */
    @PostMapping(value="/student/{student_id}/scenario/{scenario_id}/{version_id}/consequences")
    public @ResponseBody JSONObject consequencesReflection(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @RequestParam String cons_reflection){
        try{
            JSONObject obj = new JSONObject();
            String scenario_page = scenario_id+version_id+"consequences";
            Data.students.get(student_id - 1).putAnswer(scenario_page, cons_reflection);
            obj.put("status_code", 200);

            return obj;
        }
        catch(Exception e){
            JSONObject obj = new JSONObject();
            obj.put("status_code", 400);

            return obj;
        }
    }

    /**
     * (POST) Reflection on conversation student response
     */
    @PostMapping(value="/student/{student_id}/scenario/{scenario_id}/{version_id}/convoreflection")
    public @ResponseBody JSONObject conversationReflection(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @RequestParam String[] answers){
        try{
            JSONObject obj = new JSONObject();
            String scenario_page = scenario_id + version_id + "convoreflection";

            // JSON array to store question_answer objects
            JSONObject[] questions_answers = new JSONObject[answers.length];

            // JSON object to store the array of question_answer objects
            JSONObject body_object = new JSONObject();

            // Storing question_answer objects in the JSON array
            for(int i = 0; i < answers.length; i++){
                JSONObject pair = new JSONObject();
                pair.put("question", "Test question");
                pair.put("answer", answers[i]);
                questions_answers[i] = pair;
                Data.students.get(student_id - 1).putAnswer(scenario_page, answers[i]); // Unsure about this
            }
            // Adding the questions_answers array to the body_object JSON object
            body_object.put("questions_answers", questions_answers);
            
            obj.put("status_code", 200);
            obj.put("body", body_object);
            
            return obj;
        }
        catch(Exception e){
            JSONObject obj = new JSONObject();
            JSONObject questions_answers = new JSONObject();
            obj.put("status_code", 404);
            obj.put("body", questions_answers);

            return obj;
        }
    }
    
    /*
     * (POST) Conversations - IN PROGRESS
     */

    @PostMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/stakeholder")
    public @ResponseBody JSONObject updateConversations(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, 
    		@RequestParam String stk_name, @RequestParam boolean is_picked, @RequestParam String[] questions) {
    	try {
    		JSONObject obj = new JSONObject();
    		JSONObject body = new JSONObject();
    		obj.put("status_code", 200);
    		body.put("stk_name", stk_name);
    		body.put("is_picked", is_picked);
    		body.put("questions", questions);
    		obj.put("body", body);
    		return obj;
    	}
    	catch(Exception e) {
    		JSONObject obj = new JSONObject();
    		obj.put("status_code",  400);
    		return obj;
    	}
    	
    }
    
    
    
}
