package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DemoGraphQL.exception.*;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.*;

import java.util.List;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
//    private TaskRepository taskRepository;
//    private FormFieldsRepository formFieldsRepository;
    private GatewayRepository gatewayRepository;
//    private SequenceFlowRepository sequenceFlowRepository;

//    public Mutation( AuthorRepository authorRepository,BookRepository bookRepository, FormFieldsRepository formFieldsRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository, TaskRepository taskRepository) {
//        this.bookRepository = bookRepository;
//        this.authorRepository = authorRepository;
//        this.taskRepository = taskRepository;
//        this.formFieldsRepository = formFieldsRepository;
//        this.gatewayRepository = gatewayRepository;
//        this.sequenceFlowRepository = sequenceFlowRepository;
//    }

//    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//    }

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, GatewayRepository gatewayRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.gatewayRepository = gatewayRepository;
    }

    //    public Mutation(TaskRepository taskRepository, FormFieldsRepository formFieldsRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository) {
//        this.taskRepository = taskRepository;
//        this.formFieldsRepository = formFieldsRepository;
//        this.gatewayRepository = gatewayRepository;
//        this.sequenceFlowRepository = sequenceFlowRepository;
//    }
//
//    public Mutation(TaskRepository taskRepository, FormFieldsRepository formFieldsRepository) {
//        this.taskRepository = taskRepository;
//        this.formFieldsRepository = formFieldsRepository;
//    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was not found", id);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }

    //---------------------------- CMF ----------------------------//
//    public FormField newFormField(String name, String type, String defaultValue, String value, Boolean required) {
//        FormField ff = new FormField();
//        ff.setName(name);
//        ff.setDefaultValue(defaultValue);
//        ff.setType(type);
//        ff.setValue(value);
//        ff.setRequired(required);
//
//        formFieldsRepository.save(ff);
//
//        return ff;
//    }
//
//    public FormField newFormField(String name, String type, String defaultValue, Boolean required) {
//        FormField ff = new FormField();
//        ff.setName(name);
//        ff.setDefaultValue(defaultValue);
//        ff.setType(type);
//        ff.setRequired(required);
//
//        formFieldsRepository.save(ff);
//
//        return ff;
//    }
//
//    public FormField newFormField(String name) {
//        FormField ff = new FormField();
//        ff.setName(name);
//
//        formFieldsRepository.save(ff);
//
//        return ff;
//    }
//
//
//
    public Gateway newGateway(String type) {
        Gateway gateway = new Gateway();
        gateway.setType(type);

        gatewayRepository.save(gateway);

        return gateway;
    }
//
//    public SequenceFlow newSequenceFlow(String sourceId, String expression, String targetId) {
//        SequenceFlow sf = new SequenceFlow();
//        sf.setExpression(expression);
//        sf.setSourceId(sourceId);
//        sf.setTargetId(targetId);
//
//        sequenceFlowRepository.save(sf);
//
//        return sf;
//    }
//
//    public SequenceFlow newSequenceFlow(String sourceId, String targetId) {
//        SequenceFlow sf = new SequenceFlow();
//        sf.setSourceId(sourceId);
//        sf.setTargetId(targetId);
//
//        sequenceFlowRepository.save(sf);
//
//        return sf;
//    }
//
//    public Task newTask(String name, String className, String classBeanNameReference, List<FormField> ListofFormFields) {
//        Task task = new Task();
//        task.setName(name);
//        task.setClassBeanNameReference(classBeanNameReference);
//        task.setClassName(className);
//        task.setTheFormFields(ListofFormFields);
//
//        taskRepository.save(task);
//
//        return task;
//    }
//
//    public Task newTask(String name) {
//        Task task = new Task();
//        task.setName(name);
//        taskRepository.save(task);
//
//        return task;
//    }

}