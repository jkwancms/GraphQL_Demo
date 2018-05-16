//package com.example.DemoGraphQL.model;
//
//import javax.persistence.*;
//
//@Entity
//public class SequenceFlow {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Long id;
//
//    private String sourceId;
//
//    private String targetId;
//
//    private String expression;
//
//    //Constructors
//    public  SequenceFlow(){}
//
//    public SequenceFlow(String sourceId, String targetId) {
//        this.sourceId = sourceId;
//        this.targetId = targetId;
//    }
//
//    public SequenceFlow(String sourceId, String targetId, String expression) {
//        this.sourceId = sourceId;
//        this.targetId = targetId;
//        this.expression = expression;
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
//    public String getSourceId() {
//        return sourceId;
//    }
//
//    public void setSourceId(String sourceId) {
//        this.sourceId = sourceId;
//    }
//
//    public String getTargetId() {
//        return targetId;
//    }
//
//    public void setTargetId(String targetId) {
//        this.targetId = targetId;
//    }
//
//    public String getExpression() {
//        return expression;
//    }
//
//    public void setExpression(String expression) {
//        this.expression = expression;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        SequenceFlow that = (SequenceFlow) o;
//
//        if (id != null ? !id.equals(that.id) : that.id != null) return false;
//        if (sourceId != null ? !sourceId.equals(that.sourceId) : that.sourceId != null) return false;
//        if (targetId != null ? !targetId.equals(that.targetId) : that.targetId != null) return false;
//        return expression != null ? expression.equals(that.expression) : that.expression == null;
//    }
//
//    @Override
//    public String toString() {
//        return "SequenceFlow{" +
//                "id=" + id +
//                ", sourceId='" + sourceId + '\'' +
//                ", targetId='" + targetId + '\'' +
//                ", expression='" + expression + '\'' +
//                '}';
//    }
//}