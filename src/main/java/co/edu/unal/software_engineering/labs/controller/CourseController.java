package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.model.Course;
import co.edu.unal.software_engineering.labs.pojo.CoursePOJO;
import co.edu.unal.software_engineering.labs.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


    @PostMapping( value = {"/profesor/cursos"} )
    public ResponseEntity<Void> createCourse( @RequestBody CoursePOJO coursePojo ){
        Course course = courseService.mapperCourseEntity( coursePojo );
        if( !courseService.isRightCourse( course ) ){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
        courseService.save( course );
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

}