package works.keyka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import works.keyka.model.StudentModel;

@Mapper
public interface StudentMapper {
	void insert(StudentModel studentModel);
	void update(StudentModel studentModel);
	List<String> findExistingIds(List<String> ids);
	List<StudentModel> view();
}
