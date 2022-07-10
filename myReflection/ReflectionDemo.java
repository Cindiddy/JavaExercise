package myReflection;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
/*
run a method in class by using the configuration file
 */
public class ReflectionDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //load data
        Properties prop=new Properties();
        FileReader fr=new FileReader("myReflection/class.txt");

        prop.load(fr);
        fr.close();

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //use reflection use the method
        Class<?> c = Class.forName(className);
        Constructor<?> con = c.getConstructor();

        Object obj = con.newInstance();

        Method m = c.getMethod(methodName);
        m.invoke(obj);

    }
}
