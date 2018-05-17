package com.example.DemoGraphQL.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

//    private ArrayList<FormField> formFields;
    private ArrayList<String> formFields;

    private String className;

    private String classBeanNameReference;

    //Constructors
    public Task(){}

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, String className, String classBeanNameReference) {
        this.name = name;
        this.className = className;
        this.classBeanNameReference = classBeanNameReference;
    }

//    public Task(String name, ArrayList<FormField> formFields, String className, String classBeanNameReference) {
//        this.name = name;
//        this.formFields = formFields;
//        this.className = className;
//        this.classBeanNameReference = classBeanNameReference;
//    }
    public Task(String name, ArrayList<String> formFields, String className, String classBeanNameReference) {
        this.name = name;
        this.formFields = formFields;
        this.className = className;
        this.classBeanNameReference = classBeanNameReference;
    }

//    public Task(String name, ArrayList<FormField> formFields) {
//        this.name = name;
//        this.formFields = formFields;
//    }
    public Task(String name, ArrayList<String> formFields) {
        this.name = name;
        this.formFields = formFields;
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

//    public ArrayList<FormField> getTheFormFields() {
//        return formFields;
//    }
//
//    public void setTheFormFields(ArrayList<FormField> formFields) {
//        this.formFields = formFields;
//    }


    public ArrayList<String> getFormFields() {
        return formFields;
    }

    public void setFormFields(ArrayList<String> formFields) {
        this.formFields = formFields;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassBeanNameReference() {
        return classBeanNameReference;
    }

    public void setClassBeanNameReference(String classBeanNameReference) {
        this.classBeanNameReference = classBeanNameReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (formFields != null ? !formFields.equals(task.formFields) : task.formFields != null)
            return false;
        if (className != null ? !className.equals(task.className) : task.className != null) return false;
        return classBeanNameReference != null ? classBeanNameReference.equals(task.classBeanNameReference) : task.classBeanNameReference == null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", FormFields :" + formFields +
                ", className='" + className + '\'' +
                ", classBeanNameReference='" + classBeanNameReference + '\'' +
                '}';
    }

}