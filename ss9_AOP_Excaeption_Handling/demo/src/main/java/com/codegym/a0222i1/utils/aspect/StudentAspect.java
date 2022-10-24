package com.codegym.a0222i1.utils.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Aspect
@Component
public class  StudentAspect {

    @After("execution(* com.codegym.a0222i1.controller.StudentController.*(..))")
    public void logAfterCallMethodStudentController(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println(nameMethod +" Thời gian: "+ LocalDate.now());
    }
}
