package ua.advanced.practice6.customAnnotations;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnnotationValidator {
    private static Logger logger;
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("practice6Logs");
            logger = Logger.getLogger(AnnotationValidator.class.getName());
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isRangeMethodObject(Object object) {
        logger.log(Level.INFO, "Invoke isRangedMethodObject method");
        Class<?> clazz = object.getClass();
        try {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Range.class)) {
                    method.setAccessible(true);
                    Range range = method.getAnnotation(Range.class);
                    String result = (String) method.invoke(object);
                    logger.log(Level.INFO, "Method result: ".concat(result));
                    if (result.length() < range.min() || result.length() > range.max())
                        throw new IllegalArgumentException();
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.log(Level.SEVERE, "Exception at isRangeMethodObject method: ".concat(e.getMessage()));
            return false;
        }
        return true;
    }

    private static boolean isNotNullFieldObject(Object object) {
        logger.log(Level.INFO, "Invoke isNotNullFieldObject method");
        Class<?> clazz = object.getClass();
        try {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    String value = (String) field.get(object);
                    logger.log(Level.INFO, "Field value: ".concat(value));
                    if (!value.equals(""))
                        throw new IllegalArgumentException();
                }
            }
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, "Exception at isRangeMethodObject method: ".concat(e.getMessage()));
            return false;
        }
        return true;
    }

    public boolean isRangeMethodValidate(Object object) {
        return isRangeMethodObject(object);
    }

    public boolean isNotNullFieldValidate(Object object) {
        return isNotNullFieldObject(object);
    }

}
