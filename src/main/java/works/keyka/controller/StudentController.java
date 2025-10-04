package works.keyka.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import works.keyka.model.StudentModel;
import works.keyka.service.StudentService;


@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")  // フロントのURLを許可
public class StudentController {

	private final StudentService studentService;
	
	@PostMapping("/register")
	public Map<String, String> registerStudents(@Valid @RequestBody List<StudentModel> students) {
	    int count = studentService.registerStudents(students);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", count + "件の生徒を登録しました。");
	    return response; // JSONに変換してくれる
	}
	
    // 生徒情報更新
    @PostMapping("/edit")	
    public Map<String, String> editStudents(@Valid @RequestBody List<StudentModel> students) {
	    int count = studentService.editStudents(students);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", count + "件の生徒情報を更新しました。");
	    return response; // JSONに変換してくれる
    }
    
    @GetMapping("/view")
    public List<StudentModel> getMethodName() {
        return studentService.viewStudents();
    }
    
}
