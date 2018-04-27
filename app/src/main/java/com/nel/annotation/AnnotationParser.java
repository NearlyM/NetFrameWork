package com.nel.annotation;

/**
 * Created by ningerlei on 18-4-27.
 */

public class AnnotationParser extends IAnnotationParser<String, Host> {

    @Override
    public String getValue(Class cls) {
        return getAnnotation(cls).value();
    }
}
