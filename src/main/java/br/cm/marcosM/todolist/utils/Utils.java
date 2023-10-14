package br.cm.marcosM.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    public static void copyNonNullPropeties(Object sourc, Object target) {
        BeanUtils.copyProperties(sourc, target, getNullPropertyNames(sourc));
    }

    public static String[] getNullPropertyNames(Object souce) {
        final BeanWrapper src = new BeanWrapperImpl(souce);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for(PropertyDescriptor pd: pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        
        return emptyNames.toArray(result);
    }
    
}
