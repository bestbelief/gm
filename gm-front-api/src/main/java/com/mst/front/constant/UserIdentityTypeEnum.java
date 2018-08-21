package com.mst.front.constant;

public enum  UserIdentityTypeEnum {
    EMAIL("EMAIL"),QQ("QQ");
    private String value;
    private UserIdentityTypeEnum(String value) {
        this.value =value;
    }
    @Override
    public String toString() {
        return this.value;
    }

    public String getValue() {
        return this.value;
    }
}
