package com.example.DemoGraphQL.model;

import javax.persistence.*;

@Entity
public class FormField {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String fieldType;
    private String defaultFieldValue;
    private String  fieldValue;
    private Boolean isRequired;

    //Constructors
    public FormField(){}

    public FormField(String name) {
        this.name = name;
    }

    public FormField(String name, String fieldType, String defaultFieldValue, String fieldValue, Boolean isRequired) {
        this.name = name;
        this.fieldType = fieldType;
        this.defaultFieldValue = defaultFieldValue;
        this.fieldValue = fieldValue;
        this.isRequired = isRequired;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getDefaultFieldValue() {
        return defaultFieldValue;
    }

    public void setDefaultFieldValue(String defaultFieldValue) {
        this.defaultFieldValue = defaultFieldValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormField formField = (FormField) o;

        if (id != null ? !id.equals(formField.id) : formField.id != null) return false;
        if (name != null ? !name.equals(formField.name) : formField.name != null) return false;
        if (fieldType != null ? !fieldType.equals(formField.fieldType) : formField.fieldType != null) return false;
        if (defaultFieldValue != null ? !defaultFieldValue.equals(formField.defaultFieldValue) : formField.defaultFieldValue != null)
            return false;
        if (fieldValue != null ? !fieldValue.equals(formField.fieldValue) : formField.fieldValue != null) return false;
        return isRequired != null ? isRequired.equals(formField.isRequired) : formField.isRequired == null;
    }

    @Override
    public String toString() {
        return "FormField{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", defaultFieldValue='" + defaultFieldValue + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                ", isRequired=" + isRequired +
                '}';
    }
}