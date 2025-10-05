package works.keyka.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import works.keyka.common.exception.DuplicateIdException;
import works.keyka.mapper.StudentMapper;
import works.keyka.model.StudentModel;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

	@Mock
	private StudentMapper studentMapper;
	
	@InjectMocks
	private StudentService studentService;
	
	@Test
	void registerTest() {
		//正常に処理が完了するパターン
	    StudentModel student = new StudentModel(
	            "20250001", 1111, 2222, 3333, "name",
	            LocalDate.of(1999, 1, 2), false
	    );
		List<StudentModel> students = List.of(student);
		
		//重複は見つからないものとする
		when(studentMapper.findExistingIds(anyList())).thenReturn(List.of());

		int count = studentService.registerStudents(students);
		
        // 登録メソッドが1回呼ばれたか
        verify(studentMapper, times(1)).insert(student);
        assertEquals(1, count);
	}
    @Test
    void registerDuplicateID() {
        // given
        StudentModel student = new StudentModel(
            "20250001", 1111, 2222, 3333, "name",
            LocalDate.of(1999, 1, 2), false
        );
        List<StudentModel> students = List.of(student);

        // findExistingIds が重複IDを返す
        when(studentMapper.findExistingIds(anyList())).thenReturn(List.of("20250001"));

        // when & then
        assertThrows(DuplicateIdException.class,
            () -> studentService.registerStudents(students));
    }
	
}
