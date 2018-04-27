package com.nel.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by ningerlei@outlook.com on 18-4-27.
 */

public abstract class IAnnotationParser<T, A extends Annotation> {

    public boolean isAnnotation(Class cls) {
        return cls.isAnnotationPresent(getAClass());
    }

    public abstract T getValue(Class cls);

    A getAnnotation(Class cls) {
        A annotation = null;
        if (isAnnotation(cls)) {
            annotation = (A) cls.getAnnotation(getAClass());
        }
        return annotation;
    }

    private Class<A> getAClass() {
        Type sType = getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) sType).getActualTypeArguments();
        return (Class<A>) actualTypeArguments[1];
    }
}
