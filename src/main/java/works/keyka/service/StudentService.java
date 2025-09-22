package works.keyka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import works.keyka.mapper.StudentMapper;
import works.keyka.model.StudentModel;

@Service
@RequiredArgsConstructor
public class StudentService  {
	
	private final StudentMapper studentMapper;
	//登録
	public int registerStudents(List<StudentModel> students){
		int count = 0;
		for (StudentModel student:students) {
			studentMapper.insert(student);
			count ++ ;
		}
		return count;
	}
	
	//更新
    public int editStudents(List<StudentModel> students) {
        int count = 0;
        for (StudentModel student : students) {
            studentMapper.update(student);
            count++;
        }
        return count;
    }
}
