
package in.strikes.dtoDemo.controller;

import in.strikes.dtoDemo.dto.CreateStudentRequestDto;
import in.strikes.dtoDemo.dto.CreateStudentResponseDto;
import in.strikes.dtoDemo.dto.UpdateStudentRequestDto;
import in.strikes.dtoDemo.dto.UpdateStudentResponseDto;
import in.strikes.dtoDemo.entity.Student;
import in.strikes.dtoDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
@PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDto> createStudent(@RequestBody CreateStudentRequestDto studentRequestDto){

   CreateStudentResponseDto createdStudent= studentService.createStudent(studentRequestDto);

   return ResponseEntity.ok(createdStudent);
    }
    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@RequestParam Long id){
   CreateStudentResponseDto studentResp= studentService.getStudent(id);
   if (studentResp==null){
       return ResponseEntity.notFound().build();
   }
//   return ResponseEntity.status(HttpStatus.OK).body(studentResp);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent(){
        List<CreateStudentResponseDto> studentList= studentService.getAllStudent();
        if (studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent
            (@RequestParam Long id,@RequestBody UpdateStudentRequestDto studentReq){
        UpdateStudentResponseDto studentResp= studentService.updateStudent(id,studentReq);
        if (studentResp==null){
            return ResponseEntity.notFound().build();
        }
//   return ResponseEntity.status(HttpStatus.OK).body(studentResp);
        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted=studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        Boolean isDeleted=studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
}
