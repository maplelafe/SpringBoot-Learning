package com.didispace.annotation;


import org.springframework.context.annotation.Conditional;
 
import java.lang.annotation.*;
 
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(MyConditional.class)
public @interface  MyConditionalIAnnotation {
    String key();
    String value();
}