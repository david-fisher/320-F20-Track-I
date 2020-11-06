package team8.partyinthebackend.controller;

import net.bytebuddy.utility.visitor.StackAwareMethodVisitor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;
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
public class FrontendIntergration {

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
     * (GET) student homepage
     */
    @GetMapping(value = "/student/{student_id}/homepage")
    public JSONObject getHomePage(@PathVariable int student_id){
        try{
            JSONObject class1 = new JSONObject();
            JSONObject classes = new JSONObject();
            JSONObject rst = new JSONObject();
            class1.put("scenario_id", 5);
            class1.put("scenario_name", "Egassem Bdrawkcae");
            classes.put("course1", class1);
            rst.put("student_name", "John Doe");
            rst.put("courses", classes);
            rst.put("status_code", 200);
            return rst;
        }
        catch (Exception e){
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }

    /**
     * (GET) stackholderInfo
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/stakeholderinfo")
    public JSONObject getStakeHolders(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id){
        try{
            JSONObject body = new JSONObject();
            JSONObject rst = new JSONObject();
            JSONObject stakeHolder = new JSONObject();
            stakeHolder.put("name", "Steve");
            stakeHolder.put("bio", "Biography goes here.");
            stakeHolder.put("conversation", "This is a conversation.");
            body.put("max_conversations", 2);
            body.put("StakeHolders", stakeHolder);
            rst.put("status_code", 200);
            rst.put("body", body);
            return rst;
        }
        catch (Exception e){
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
