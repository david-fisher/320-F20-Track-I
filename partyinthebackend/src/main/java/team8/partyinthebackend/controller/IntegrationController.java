package team8.partyinthebackend.controller;

import com.example.cs320EthicsPlayer.model.EventPage;
import com.example.cs320EthicsPlayer.model.Pages;
import com.example.cs320EthicsPlayer.model.Student;
import com.example.cs320EthicsPlayer.repository.EventPageRepository;
import com.example.cs320EthicsPlayer.repository.PagesRepository;
import com.example.cs320EthicsPlayer.repository.StudentRepository;
import net.minidev.json.JSONObject;
import team8.partyinthebackend.controller.FrontendIntegration.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZJendex
 * @Time: 11/15/2020, Sun
 **/

@CrossOrigin
@RestController
@RequestMapping("/bt/v1")
public class IntegrationController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventPageRepository eventPageRepository;

    @Autowired
    private PagesRepository pagesRepository;
    
    @GetMapping(value = "/ss")
    public List<Student> test1() throws Exception {
        return studentRepository.findAll();
    }
    
    @PostMapping(value="/ss/{student_id}")
    public @ResponseBody JSONObject addStudentTest(@PathVariable int student_id, @RequestParam String name) {
        try {
            JSONObject obj = new JSONObject();
            Student student = new Student(student_id, name);
            studentRepository.save(student);
            obj.put("status_code", 200);
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }
    
    @DeleteMapping(value="/ss/{student_id}")
    public @ResponseBody JSONObject removeStudentTest(@PathVariable int student_id) {
        try {
            JSONObject obj = new JSONObject();
            Student student = studentRepository.findById(student_id)
                    .orElseThrow(() -> new Exception("Student " + student_id + " not found"));
            studentRepository.delete(student);
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
     * (GET)1 introduction
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario}/{scenarioVer}/introduction")
    public JSONObject getIntroduction(@PathVariable int student_id, @PathVariable(value="scenario") int scenario_id, @PathVariable(value="scenarioVer") int version_id) throws Exception {
        try {
            List<Pages> pagesList = pagesRepository.findByScenarioIDAndScenarioVerIDAndPageType(scenario_id, version_id, "Intro");
            int page_ID = pagesList.get(0).getPageID();
            String page_title = pagesList.get(0).getPageTitle();
//            EventPage ePage = eventPageRepository.findById(pagesList.get(0).getPageID())
//                    .orElseThrow(() -> new Exception("Event page " + page_ID + " not found"));
//            Pages p = pagesRepository.findById(page_ID)
//                    .orElseThrow(() -> new Exception("Page " + page_ID + " not found"));
            //if(!(p.getPageType().equals("INTRO"))){ throw new Exception("Incorrect Page Type");}
            String text = "The body of introduction";

            JSONObject rst = new JSONObject();
            rst.put("text", text);
            rst.put("page_title", page_title);
            rst.put("page_ID", page_ID);
            JSONObject obj = new JSONObject();
            obj.put("body", rst);
            obj.put("status_code", 200);
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            obj.put("error", e);
            return obj;
        }
    }

    /**
     * (GET)2 project task assignment
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/pta")
    public JSONObject getPTA(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) throws Exception {
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
     * (GET)3 gather information
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/gi")
    public JSONObject getGI(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) throws Exception {
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
}
