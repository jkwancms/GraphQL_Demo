//package com.example.DemoGraphQL.model;
//
//import javax.persistence.*;
//
//@Entity
//public class FormField {
//
//    private String name;
//
//    private String type;
//
//    private String defaultValue;
//
//    private String value;
//
//    private Boolean required;
//
//    //Constructors
//    public FormField(){}
//
//    public FormField(String name, String type, String defaultValue, String value, Boolean required) {
//        this.name = name;
//        this.type = type;
//        this.defaultValue = defaultValue;
//        this.value = value;
//        this.required = required;
//    }
//
//    public FormField(String name, String type, String defaultValue, Boolean required) {
//        this.name = name;
//        this.type = type;
//        this.defaultValue = defaultValue;
//        this.required = required;
//    }
//
//    //Getters and Setters
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDefaultValue() {
//        return defaultValue;
//    }
//
//    public void setDefaultValue(String defaultValue) {
//        this.defaultValue = defaultValue;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public Boolean getRequired() {
//        return required;
//    }
//
//    public void setRequired(Boolean required) {
//        this.required = required;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        FormField that = (FormField) o;
//
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (type != null ? !type.equals(that.type) : that.type != null) return false;
//        if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
//        if (value != null ? !value.equals(that.value) : that.value != null) return false;
//        return required != null ? required.equals(that.required) : that.required == null;
//    }
//
//    @Override
//    public String toString() {
//        return "FormField{" +
//                "name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", defaultValue='" + defaultValue + '\'' +
//                ", value='" + value + '\'' +
//                ", required=" + required +
//                '}';
//    }
//
//}