//package com.example.DemoGraphQL.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Task {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//
//    private List<FormField> theFormFields;
//
//    private String className;
//
//    private String classBeanNameReference;
//
//    //Constructors
//    public Task(){}
//
//    public Task(String name) {
//        this.name = name;
//    }
//
//    public Task(String name, String className, String classBeanNameReference) {
//        this.name = name;
//        this.className = className;
//        this.classBeanNameReference = classBeanNameReference;
//    }
//
//    public Task(String name, List<FormField> theFormFields, String className, String classBeanNameReference) {
//        this.name = name;
//        this.theFormFields = theFormFields;
//        this.className = className;
//        this.classBeanNameReference = classBeanNameReference;
//    }
//
//    public Task(String name, List<FormField> theFormFields) {
//        this.name = name;
//        this.theFormFields = theFormFields;
//    }
//
//    //Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<FormField> getTheFormFields() {
//        return theFormFields;
//    }
//
//    public void setTheFormFields(List<FormField> theFormFields) {
//        this.theFormFields = theFormFields;
//    }
//
//    public String getClassName() {
//        return className;
//    }
//
//    public void setClassName(String className) {
//        this.className = className;
//    }
//
//    public String getClassBeanNameReference() {
//        return classBeanNameReference;
//    }
//
//    public void setClassBeanNameReference(String classBeanNameReference) {
//        this.classBeanNameReference = classBeanNameReference;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Task task = (Task) o;
//
//        if (id != null ? !id.equals(task.id) : task.id != null) return false;
//        if (name != null ? !name.equals(task.name) : task.name != null) return false;
//        if (theFormFields != null ? !theFormFields.equals(task.theFormFields) : task.theFormFields != null)
//            return false;
//        if (className != null ? !className.equals(task.className) : task.className != null) return false;
//        return classBeanNameReference != null ? classBeanNameReference.equals(task.classBeanNameReference) : task.classBeanNameReference == null;
//    }
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", theFormFields :" + theFormFields +
//                ", className='" + className + '\'' +
//                ", classBeanNameReference='" + classBeanNameReference + '\'' +
//                '}';
//    }
//
//}