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
	
    @Test
    void registerStudents_allNew_success() {
    	// 複数件でもうまくいくことをテストしたい
        List<StudentModel> students = List.of(
            new StudentModel("20250001", 1111, 2222, 3333, "name1", LocalDate.of(2000,1,1), false),
            new StudentModel("20250002", 1111, 2222, 3333, "name2", LocalDate.of(2000,1,1), false)
        );

        when(studentMapper.findExistingIds(anyList())).thenReturn(List.of());

        int result = studentService.registerStudents(students);
        
        // マッパーは二回呼ばれる
        verify(studentMapper, times(2)).insert(any(StudentModel.class));
        // 結果は2件
        assertEquals(2, result);
    }
    
    @Test
    void registerStudents_DuplicateId_Multi() {
    	// 二番目が重複エラーになった時のテスト
        List<StudentModel> students = List.of(
            new StudentModel("20250001", 1111, 2222, 3333, "name1", LocalDate.of(2000,1,1), false),
            new StudentModel("20250002", 1111, 2222, 3333, "name2", LocalDate.of(2000,1,1), false)
        );

        // 重複チェックは20250002を重複として判定
        when(studentMapper.findExistingIds(anyList())).thenReturn(List.of("20250002"));

        DuplicateIdException ex = assertThrows(DuplicateIdException.class,
            () -> studentService.registerStudents(students));
        
        // 独自の重複エラーのメッセージに20250002が含まれることを確認
        assertTrue(ex.getMessage().contains("20250002"));
        // マッパークラスが処理されないことを確認
        verify(studentMapper, never()).insert(any());
    }
}
