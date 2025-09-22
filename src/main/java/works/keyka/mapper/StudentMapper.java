package works.keyka.mapper;

import org.apache.ibatis.annotations.Mapper;

import works.keyka.model.StudentModel;

@Mapper
public interface StudentMapper {
	void insert(StudentModel studentModel);
	void update(StudentModel studentModel);
}
