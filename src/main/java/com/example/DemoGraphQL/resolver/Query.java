package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.*;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
//    private TaskRepository taskRepository;
//    private FormFieldsRepository formFieldsRepository;
    private GatewayRepository gatewayRepository;
//    private SequenceFlowRepository sequenceFlowRepository;

//    public Query(AuthorRepository authorRepository, BookRepository bookRepository, FormFieldsRepository formFieldsRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository, TaskRepository taskRepository) {
//        this.bookRepository = bookRepository;
//        this.authorRepository = authorRepository;
//        this.taskRepository = taskRepository;
//        this.formFieldsRepository = formFieldsRepository;
//        this.gatewayRepository = gatewayRepository;
//        this.sequenceFlowRepository = sequenceFlowRepository;
//    }
//
    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

//    public Query(TaskRepository taskRepository, FormFieldsRepository formFieldsRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository) {
//        this.taskRepository = taskRepository;
//        this.formFieldsRepository = formFieldsRepository;
//        this.gatewayRepository = gatewayRepository;
//        this.sequenceFlowRepository = sequenceFlowRepository;
//    }
//
//    public Query(TaskRepository taskRepository, FormFieldsRepository formFieldsRepository) {
//        this.taskRepository = taskRepository;
//        this.formFieldsRepository = formFieldsRepository;
//    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }

    //---------------------------- CMF ----------------------------//

//    public Iterable<Task> findAllTasks() {
//        return taskRepository.findAll();
//    }
//    public Iterable<FormField> findAllFormFields() {
//        return formFieldsRepository.findAll();
//    }
    public Iterable<Gateway> findAllGateways() {
        return gatewayRepository.findAll();
    }
//    public Iterable<SequenceFlow> findAllSequenceFlows() {
//        return sequenceFlowRepository.findAll();
//    }
//
//    public long countTasks() {
//        return taskRepository.count();
//    }
//    public long countFormFields() {
//        return formFieldsRepository.count();
//    }
    public long countGateways() {
        return gatewayRepository.count();
    }
//    public long countSequenceFlows() {
//        return sequenceFlowRepository.count();
//    }

}