package com.zch.tiny.help;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

public class BeanUtils {
	public static void copyPropertiesWithoutNull(Object source, Object target) throws BeansException {
	    org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}

    
    // 获取空属性的名称
   public static String[] getNullPropertyNames(Object o) {
        final BeanWrapper src = new BeanWrapperImpl(o);
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : src.getPropertyDescriptors()) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}


