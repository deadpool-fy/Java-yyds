package com.itheima.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class BeanUtil {
    /**
     * 封装表单中的数据到javabean中
     * @param request	表单中的数据
     * @param clazz		封装到哪个javabean
     * @return	封装好的javabean对象
     * 使用的是泛型。泛型必须先声明再使用。声明必须在返回值之前
     * T指的就是泛型，它可以是任意字符，只是作为一个占位符。
     * 声明时用什么字符，使用时就得用什么
     */
    public static <T> T fillBean(HttpServletRequest request, Class<T> clazz){
        //1.定义一个T类型的javabean
        T bean = null;
        try{
            //2.实例化bean对象
            bean = clazz.newInstance();
            //3.使用BeanUtils的方法进行封装
            //4.设置转换器
            ConvertUtils.register(new DateConverter(null), Date.class);
            BeanUtils.populate(bean, request.getParameterMap());
            //4.返回
            return bean;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * 封装表单中的数据到javabean中,带有日期格式数据
     * @param request	表单中的数据
     * @param tClass 封装到哪个javabean
     * @param format 日期格式
     * @return	封装好的javabean对象
     * 使用的是泛型。泛型必须先声明再使用。声明必须在返回值之前
     * T指的就是泛型，它可以是任意字符，只是作为一个占位符。
     * 声明时用什么字符，使用时就得用什么
     */
    public static <T> T fillBean(HttpServletRequest request, Class tClass, String format) {
        //创建bean
        T bean = null;
        try {
            bean = (T) tClass.newInstance();
            //3.创建日期转换器对象
            DateConverter converter = new DateConverter();
            converter.setPattern(format);
            //4.设置转换器
            ConvertUtils.register(converter, Date.class);
            BeanUtils.populate(bean, request.getParameterMap());
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件上传的表单填充
     * @param items	文件上传的表单项
     * @param clazz	要封装的实体类字节码
     * @param <T>	泛型
     * @return		返回封装好的对象
     */
    public static <T> T fillBean(List<FileItem> items, Class<T> clazz){
        //1.定义一个T类型的javabean
        T bean = null;
        try{
            //2.实例化Bean
            bean = clazz.newInstance();
            //3.遍历文件项 集合
            for(FileItem item : items){
                //4.判断是不是文件
                if(item.isFormField()){//表单字段，不是文件
                    //5.取出表单中的name属性取值
                    String fieldName = item.getFieldName();
                    //6.使用UTF-8字符集取出表单数据
                    String fieldValue = item.getString("UTF-8");
                    //7.创建属性描述器对象 描述的类的某个属性
                    PropertyDescriptor pd = new PropertyDescriptor(fieldName,clazz);
                    //8.获取写方法(setXXX方法）
                    Method method = pd.getWriteMethod();
                    //9.把数据填充到bean中
                    method.invoke(bean,fieldValue);
                }
            }
            //10.返回
            return bean;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

