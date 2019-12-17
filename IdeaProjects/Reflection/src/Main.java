import com.sun.jdi.VoidType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

      List listProperties = new ArrayList();

      listProperties.add("name");

      WO1 wo1 = new WO1();
      wo1.setName("Moises");

      WO2 wo2 = new WO2();
      invokeSetters(listProperties,wo2,invokeGetters(listProperties,wo1));

      System.out.println("Objeto: " + wo2.toString());
    }


    private static Object invokeGetters (List properties, Object wo1){
        Class c = wo1.getClass();
        Object result = null;
        for (Field field : c.getDeclaredFields()){

            if (properties.contains(field.getName())) {
                // llamo a su getter

                try {


                    Method getter = c.getDeclaredMethod("get"+field.getName()
                            .replaceFirst(field.getName().substring(0, 1), field.getName()
                                    .substring(0, 1).toUpperCase()));

                    result = getter.invoke(wo1);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

        }

        return result;
    }


    private static void invokeSetters (List properties ,Object wo2, Object value){
        Class c = wo2.getClass();
        for (Field field : c.getDeclaredFields()){

            if (properties.contains(field.getName())) {
                // llamo a su setter

                try {
                    Method setter = c.getDeclaredMethod("set"+field.getName()
                            .replaceFirst(field.getName().substring(0, 1), field.getName()
                                    .substring(0, 1).toUpperCase()),field.getType());

                    setter.invoke(wo2,value);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
