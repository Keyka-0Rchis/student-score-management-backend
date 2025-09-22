package works.keyka.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import works.keyka.model.StudentModel;
import works.keyka.service.StudentService;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")  // フロントのURLを許可
public class StudentController {

	private final StudentService studentService;
	
	@PostMapping("/registerStudents")
	public ResponseEntity<String> registerStudents(@RequestBody List<StudentModel> students) {
		int count = studentService.registerStudents(students);
		return ResponseEntity.ok(count + "件の生徒を登録しました");
	}
	
    // 生徒情報更新
    @PostMapping("/editStudents")
    public ResponseEntity<String> editStudents(@RequestBody List<StudentModel> students) {
        int count = studentService.editStudents(students);
        return ResponseEntity.ok(count + "件の生徒情報を更新しました");
    }
}
