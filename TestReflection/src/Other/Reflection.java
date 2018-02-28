package Other;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import User.Person;

/**
 *
 * @ClassName Reflection.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月22日下午4:51:11
 * @Description 使用反射实现类文件的反编译
 */

public class Reflection extends AccessibleObject{

	public static void main(String[] args) {
		Class cla = null;
		try{
			//根据传入类的全名来创建Class对象
			cla =Class.forName("User.Person");
			//获取包路径
			System.out.println("package "+cla.getPackage().getName()+";\n");
			//获取类修饰符
			System.out.println(Modifier.toString(cla.getModifiers()));
			//获取类名
			System.out.println("class "+cla.getSimpleName());
			//获取类属性、类构造器、类方法
			System.out.println("{");
			
			PrintConstructor(cla);
			PrintField(cla);
			PrintMethods(cla);
			
			System.out.println("}");
			
		}catch(ClassNotFoundException | SecurityException e){
			e.printStackTrace();
		} 
		
		Class<?> c1 = null;
		Object obj = null;
		try {
			c1 = Class.forName("User.Person");
			obj = c1.newInstance();
			Field nameField = c1.getDeclaredField("name");
			Field ageField = c1.getDeclaredField("age");
			Field sexField = c1.getDeclaredField("sex");
			nameField.setAccessible(true);
			ageField.setAccessible(true);
			sexField.setAccessible(true);
			nameField.set(obj, "Leno");
			ageField.set(obj, 23);
			sexField.set(obj, "男");
			System.out.println("name: "+nameField.get(obj));
			System.out.println("age: "+ageField.get(obj));
			System.out.println("sex: "+sexField.get(obj));
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	private static void PrintConstructor(Class c){
		Constructor[] cs = c.getConstructors();
		for(int i = 0;i<cs.length;i++){
			System.out.println();
			System.out.println("\t");
			//获取整数形式构造函数修饰符，使用Modifier进行解码
			System.out.print(Modifier.toString(cs[i].getModifiers())+" ");
			//获取方法名
			System.out.print(cs[i].getName()+"(");
			//获取方法参数数组
			Class[] paras = cs[i].getParameterTypes();
			for(int j=0;j<paras.length;j++){
				System.out.print(paras[j].getSimpleName()+"  arg"+j);
				if(j<paras.length-1){
					System.out.print(" ,");
				}
			}
			System.out.print(")");
			System.out.println("{");
			System.out.println("\t\t\\\\方法体");
			System.out.println("}");
			
		}
	}
	private static void PrintField(Class c){
		Field[] fs = c.getDeclaredFields();
		for(int i = 0;i<fs.length;i++){
			System.out.print("\t");
			System.out.print(Modifier.toString(fs[i].getModifiers())+" ");
			System.out.print(fs[i].getType().getSimpleName()+" ");
			System.out.println(fs[i].getName()+";");
		}
	}
	private static void PrintMethods(Class c){
		Method[] md = c.getMethods();
		for(int i = 0;i<md.length;i++){
			System.out.println();
			System.out.print("\t");
			System.out.print(Modifier.toString(md[i].getModifiers())+" ");
			System.out.print(md[i].getGenericReturnType()+" ");
			System.out.print(md[i].getName()+"(");
			Class[] paras = md[i].getParameterTypes();
			for(int j=0;j<paras.length;j++){
				System.out.print(paras[j].getSimpleName()+" arg" + j);
				if(j<paras.length-1){
					System.out.print(",");
				}
			}
			System.out.print(")");
			Class[] exceps = md[i].getExceptionTypes();
			if(exceps.length>0){
				System.out.print(" throws ");
				for(int k = 0;k<exceps.length;k++){
					System.out.print(exceps[k].getSimpleName());
					if(k<exceps.length-1){
						System.out.print(",");
					}
				}
			}
			System.out.println("{");
			System.out.println("\t\t\\\\方法体");
			System.out.println("\t}");
		}
	}

}
