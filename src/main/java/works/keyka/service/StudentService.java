package works.keyka.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import works.keyka.common.ErrorCode;
import works.keyka.common.exception.DuplicateIdException;
import works.keyka.mapper.StudentMapper;
import works.keyka.model.StudentModel;

@Service
@RequiredArgsConstructor
public class StudentService  {
	
	private final StudentMapper studentMapper;
	//登録
	@Transactional
	public int registerStudents(List<StudentModel> students){
		List<String> ids = students.stream()
									.map(StudentModel::getStudentId)
									.toList();
		List<String> exists = studentMapper.findExistingIds(ids);
		
		if (!exists.isEmpty()) {
			//IDの重複エラーを投げる
			throw new DuplicateIdException("次のIDは既に存在します：" + String.join(",", exists), ErrorCode.DUPLICATE_ID);
		}
		for (StudentModel student:students) {
			studentMapper.insert(student);
		}
		return students.size();
	}
	
	//更新
	@Transactional
    public int editStudents(List<StudentModel> students) {
        int count = 0;
        for (StudentModel student : students) {
            studentMapper.update(student);
            count++;
        }
        return count;
    }
    
    //一覧表示
    public List<StudentModel> viewStudents(){
    	System.out.println(studentMapper.view());
    	return studentMapper.view();
    }
}
