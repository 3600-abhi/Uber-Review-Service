//package com.uber.reviewService.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Student extends BaseModel {
//    private String name;
//
//    private String rollNumber;
//
//    @ManyToMany // with many-to-many we have add @JoinTable annotation also in any one side ie either student or course
//    @JoinTable( // using @JoinTable we are providing details of through-table or join-table
//            name = "course_student",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id")
//    )
//    private List<Course> courses = new ArrayList<>();
//}
