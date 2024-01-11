package com.hellomeme.v2.constants;

/**
 * 用户角色常量枚举类
 * @author lige
 * @since 2023.8.16
 */
public enum MemePropertyConstant {

    /**滑稽*/
    FUNNY(1L,"funny"),
    /**有趣*/
    INTERESTING(2L,"interesting"),
    /**无趣*/
    BORING(3L,"boring");


    /**
     * 属性id
     */
    private final Long propertyId;

    /**
     * 名称
     */
    private final String name;

    MemePropertyConstant(Long propertyId, String name){
        this.propertyId = propertyId;
        this.name = name;
    }

    public Long getPropertyId(){
        return propertyId;
    }

    public String getName(){
        return name;
    }

}
