package team8.partyinthebackend.controller;

import com.example.cs320EthicsPlayer.api.*;
import com.example.cs320EthicsPlayer.model.Courses;
import com.example.cs320EthicsPlayer.model.EventPage;
import com.example.cs320EthicsPlayer.model.Pages;
import com.example.cs320EthicsPlayer.model.ReflectionQuestions;
import com.example.cs320EthicsPlayer.model.Reflections;
import com.example.cs320EthicsPlayer.model.Responses;
import com.example.cs320EthicsPlayer.model.Stakeholders;
import com.example.cs320EthicsPlayer.model.Student;
import com.example.cs320EthicsPlayer.model.ScenariosFor;
import com.example.cs320EthicsPlayer.repository.EventPageRepository;
import com.example.cs320EthicsPlayer.repository.PagesRepository;
import com.example.cs320EthicsPlayer.repository.StakeholderRepository;
import com.example.cs320EthicsPlayer.repository.StudentRepository;
import net.minidev.json.JSONObject;
import team8.partyinthebackend.controller.FrontendIntegration.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
@RequestMapping("/bt/v1")
public class IntegrationController {

    @Autowired
    private ActionPageController actionPageController;

    @Autowired
    private ScenariosForController scenariosForController;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventPageRepository eventPageRepository;

    @Autowired
    private PagesRepository pagesRepository;

    @Autowired
    private StakeholderController stakeholderController;

    @Autowired
    private ScenarioController scenarioController;

    @Autowired
    private EventPageController eventPageController;

    @Autowired 
    private PagesController pagesController;

    @Autowired
    private ReflectionQuestionsController reflectionQuestionsController;

    @Autowired
    private ReflectionsController reflectionsController;

    @Autowired 
    private StudentsInController studentsInController;

    @Autowired
    private Courses course;

    @Autowired
    private EventPage eventPage;

    @Autowired
    private ResponsesController responsesController;

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

            String text = eventPageController.getIntroPageText(page_ID).get(0).getPageInfo();

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
    public JSONObject getPTA(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id) {
        try {
            List<Pages> pagesList = pagesRepository.findByScenarioIDAndScenarioVerIDAndPageType(scenario_id, version_id, "PTA");
            int page_ID = pagesList.get(0).getPageID();
            String page_title = pagesList.get(0).getPageTitle();
            String text = eventPageController.getPtaPageText(page_ID).get(0).getPageInfo();
            JSONObject rst = new JSONObject();
            rst.put("text", text);
            rst.put("page_title", page_title);
            JSONObject obj = new JSONObject();
            obj.put("body", rst);
            obj.put("status_code", 200);
            obj.put("page_ID", page_ID);
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
     * (GET)3 gather information -- IN PROGRESS!!!!
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

    /**
     *
     * (GET)3 Initial Reflection -- IN PROGRESS!!!!
     */
    @GetMapping(value="/student/{student_id}/scenario/{scenario_id}/{version_id}/page_id/{page_id}/initialreflection")
    public JSONObject getInitialReflection(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @PathVariable int page_id){
        try{
            // List<ReflectionQuestions> allReflections = reflectionQuestionsController.getAllReflections();
            List<ReflectionQuestions> allReflections = reflectionQuestionsController.getReflectionById(page_id);
            // 203 is in the DB, will update later
            //ResponseEntity<ReflectionQuestions> questions = reflectionQuestionsController.getReflectionById(203);
            JSONObject obj = new JSONObject();
            JSONObject o = new JSONObject();
            List<String> questions_asked = new ArrayList<>();

            o.put("page_title", pagesController.getPageTitle(page_id));
            o.put("text", reflectionQuestionsController.getReflectionById(page_id));
            for(int i = 0; i < allReflections.size(); i++){
                questions_asked.add(allReflections.get(i).getReflectionQuestion());
            }
            o.put("questions_asked", questions_asked);
            obj.put("body", o);
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
     * (GET)4 initial action -- IN PROGRESS!!!!
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario_id}/{version_id}/initialaction/page_id/{page_id}")
    public JSONObject getInitialAction(@PathVariable int student_id, @PathVariable int scenario_id, @PathVariable int version_id, @PathVariable int page_id) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 200);
            List<ReflectionQuestions> allReflections = reflectionQuestionsController.getReflectionById(page_id);
            JSONObject o = new JSONObject();
            List<String> questions_asked = new ArrayList<>();

            o.put("page_title", pagesController.getPageTitle(page_id));
            o.put("text", "What Would you like to do?");// Need to get the text content for this particular page. This is just page type. 
            for(int i = 0; i < allReflections.size(); i++){
                questions_asked.add(allReflections.get(i).getReflectionQuestion());
            }
            o.put("questions_asked", questions_asked);
            obj.put("body", o);
            obj.put("choices", actionPageController.getPageInfoById(page_id));
            return obj;
        }
        catch(Exception e) {
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }

    /**
     * (GET)5 Stakeholders
     */
    @GetMapping(value = "/student/{student_id}/scenario/{scenario}/{scenarioVer}/stakeholderinfo")
    public JSONObject getStakeHolders(@PathVariable int student_id, @PathVariable(value="scenario") int scenario_id, @PathVariable(value="scenarioVer") int version_id) throws Exception {
        try {
            List<Stakeholders> stakeholderList = stakeholderController.getAllStakeholdersInScenario(scenario_id);
            List<JSONObject> stakeholders = new ArrayList<JSONObject>();
            JSONObject body = new JSONObject();
            JSONObject obj = new JSONObject();

            for(int i = 0; i < stakeholderList.size(); i++){
                JSONObject indInfo = new JSONObject();
                String bio = stakeholderList.get(i).getJob() + ", " + stakeholderList.get(i).getDescription();
                indInfo.put("name", stakeholderList.get(i).getName());
                indInfo.put("conversation", stakeholderList.get(i).getIntroduction());
                indInfo.put("bio", bio);

                stakeholders.add(indInfo);
            }

            body.put("StakeHolders", stakeholders);
            // body.put("max_conversations", scenarioController.getMaxNumOfConvos(scenario_id, version_id));
            body.put("max_conversations", scenarioController.getMaxNumOfConvos(scenario_id, version_id)); // Just for now, can be replaced with line above, once it's figured out.
            obj.put("status_code", 200);
            obj.put("body", body);

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
     * Get: 13, Student ID on logging in -- IN PROGRESS!!!!
     */
    @GetMapping(value = "/student/{student_username}")
    public JSONObject getFeebackText(@PathVariable String student_username){
        try{
            JSONObject feedback = new JSONObject();
            feedback.put("status_code", 200);
            feedback.put("student_id", 1234);
            return feedback;
        }
        catch(Exception e){
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }

    /**
     * (GET) 8 Choose Final Action -- IN PROGRESS
     */
    @GetMapping(value="/student/{student_id}/scenario/{scenario}/{scenarioVer}/page_id/{page_id}/finalaction")
    public JSONObject getFinalAction(@PathVariable int student_id, @PathVariable(value="scenario") int scenario_id, @PathVariable(value="scenarioVer") int version_id, @PathVariable(value = "page_id") int page_id){
        try{
            JSONObject obj = new JSONObject();
            obj.put("status_code", 200);
            List<ReflectionQuestions> allReflections = reflectionQuestionsController.getReflectionById(page_id);
            JSONObject o = new JSONObject();
            List<String> questions_asked = new ArrayList<>();

            o.put("page_title", pagesController.getPageTitle(page_id));
            o.put("text", "What would you like to do?");// Need to get the text content for this particular page. This is just page type.
            for(int i = 0; i < allReflections.size(); i++){
                questions_asked.add(allReflections.get(i).getReflectionQuestion());
            }
            o.put("questions_asked", questions_asked);
            obj.put("body", o);
            obj.put("choices", actionPageController.getPageInfoById(page_id));
            return obj;
        }
        catch(Exception e){
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }

    //GET: Get the scenarios and versions assigned to a course, will return the first index
    @GetMapping(value = "/course/{course_id}")
    public JSONObject getScenarios(@PathVariable int course_id){
        try{
            List<ScenariosFor> scenarios = scenariosForController.getScenariosForCourse(course_id);
            List<Integer> scenario_ids = new ArrayList<Integer>();
            JSONObject obj = new JSONObject();
            JSONObject body = new JSONObject();

            //put the scenario ids into a list
            for(int i = 0; i < scenarios.size(); i ++){
                scenario_ids.add(scenarios.get(i).getScenarioID());
            }
            body.put("scenario_id", scenario_ids.get(0));
            obj.put("status_code", 200);
            obj.put("body", body);
            return obj;
        }
        catch(Exception e){
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }

    /**
     * (POST) 20 Reflection on consequences student response
     */
    @PostMapping(value="/student/{student_id}/scenario/{scenario}/{scenarioVer}/course_id/{course_id}/page_id/{page_id}/consequences")
    public @ResponseBody JSONObject consequencesReflection(@PathVariable int student_id, @PathVariable(value="scenario") int scenario_id, @PathVariable(value="scenarioVer") int version_id, @PathVariable(value = "course_id") int course_id, @PathVariable(value = "page_id") int page_id, @RequestParam String[] answers){
        try{
            List<ReflectionQuestions> allReflections = reflectionQuestionsController.getReflectionById(page_id);

            // Instantiating the date object to store current date and time
            Date current_date = new Date(System.currentTimeMillis());
            JSONObject obj = new JSONObject();
            // JSON array to store question_answer objects
            JSONObject[] questions_answers = new JSONObject[answers.length];
            // JSON object to store the array of question_answer objects
            JSONObject body_object = new JSONObject();

            // Storing question_answer objects in the JSON array
            for(int i = 0; i < allReflections.size(); i++){
                // Creating a response object to store an answer in that table
                Responses response = new Responses(student_id, scenario_id, version_id, course_id, current_date, answers[i]);
                responsesController.addStudentResponse(response);
                // Creating a reflection object to store reflection
                Reflections reflection = new Reflections();
                reflection.setSID(student_id);
                reflection.setCID(course_id);
                reflection.setEID(scenario_id);
                reflection.setVersion(version_id);
                reflection.setDate(current_date);
                reflection.setReflections(answers[i]);
                reflectionsController.createReflection(reflection);
        
                // For the JSON object
                JSONObject pair = new JSONObject();
                pair.put("question", allReflections.get(i).getReflectionQuestion());
                pair.put("answer", answers[i]);
                questions_answers[i] = pair;
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

    /**
     * (POST) 17 Reflection on conversation student response
     */
    @PostMapping(value="/student/{student_id}/scenario/{scenario}/{scenarioVer}/course_id/{course_id}/page_id/{page_id}/convoreflection")
    public @ResponseBody JSONObject conversationReflection(@PathVariable int student_id, @PathVariable(value="scenario") int scenario_id, @PathVariable(value="scenarioVer") int version_id, @PathVariable(value="course_id") int course_id, @PathVariable(value = "page_id") int page_id, @RequestParam String[] answers){
        try{
            List<ReflectionQuestions> allReflections = reflectionQuestionsController.getReflectionById(page_id);

            // Instantiating the date object to store current date and time
            Date current_date = new Date(System.currentTimeMillis());
            JSONObject obj = new JSONObject();
            // JSON array to store question_answer objects
            JSONObject[] questions_answers = new JSONObject[answers.length];

            // JSON object to store the array of question_answer objects
            JSONObject body_object = new JSONObject();

            // Storing question_answer objects in the JSON array
            for(int i = 0; i < allReflections.size(); i++){
                // Storing this reflection in the database
                Responses response = new Responses(student_id, scenario_id, version_id, course_id, current_date, answers[i]);
                responsesController.addStudentResponse(response);
                // Creating a reflection object to store reflection
                Reflections reflection = new Reflections();
                reflection.setSID(student_id);
                reflection.setCID(course_id);
                reflection.setEID(scenario_id);
                reflection.setVersion(version_id);
                reflection.setDate(current_date);
                reflection.setReflections(answers[i]);
                reflectionsController.createReflection(reflection);

                // For the JSON object
                JSONObject pair = new JSONObject();
                pair.put("question", allReflections.get(i).getReflectionQuestion());
                pair.put("answer", answers[i]);
                questions_answers[i] = pair;
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

    //GET: Courses
    // @GetMapping(value = "/student/{student_id}")
    // public JSONObject getCourses(@PathVariable int student_id){
    //     try{
    //         JSONObject rst = new JSONObject();
    //         rst.put("status_code", 200);
    //         List<Integer> courses = studentsInController.getCoursesInStudent(student_id);
    //         JSONObject body = new JSONObject();
    //         body.put("courses", courses);
    //         rst.put("body", body);
    //         return rst;
    //     }
    //     catch(Exception e){
    //         JSONObject obj = new JSONObject();
    //         obj.put("status_code", 404);
    //         return obj;
    //     }
    // }

    //GET: Next Page ID
    @GetMapping(value="/scenario/{scenario_id}/version/{version_id}/page_id/{page_id}")
    public JSONObject getNextPageID(@PathVariable int scenario_id,@PathVariable int version_id,@PathVariable int page_id) {
        try{
            JSONObject rst = new JSONObject();
            rst.put("status_code", 200);
            int next = pagesController.getNextPage(page_id);
            JSONObject body = new JSONObject();
            body.put("next_page_id", next);
            rst.put("body", body);
            return rst;
        }
        catch(Exception e){
            JSONObject obj = new JSONObject();
            obj.put("status_code", 404);
            return obj;
        }
    }
    
}