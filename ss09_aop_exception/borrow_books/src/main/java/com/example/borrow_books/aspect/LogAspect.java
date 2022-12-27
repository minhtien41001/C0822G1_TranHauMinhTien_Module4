package com.example.borrow_books.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {

    static private int number = 0;

    @AfterReturning(value = "execution(* com.example.borrow_books.controller.OderController.save*(..))")
    public void checkEx(JoinPoint joinPoint) {
        System.out.println("Complete the " + joinPoint.getSignature() + " method at " + LocalDateTime.now());
        System.out.println("----------------");

    }

    @After(value = "execution(* com.example.borrow_books.controller.OderController.showList(..))")
    public void checkOk() {
        System.out.println("Access number is: " + ++number + " on " + LocalDateTime.now());
        System.out.println("----------------");
    }
}

