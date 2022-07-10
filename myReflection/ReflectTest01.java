package myReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
There is an ArrayList<Integer>, can we add a String to this ArrayList<Integer>?
 */

public class ReflectTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Integer> arr=new ArrayList<>();

        Class<? extends ArrayList> c = arr.getClass();

        Method methodAdd = c.getMethod("add",Object.class);

        methodAdd.invoke(arr,"Hello");
        methodAdd.invoke(arr,"World");
        methodAdd.invoke(arr,"Java");

        System.out.println(arr);
    }
}
