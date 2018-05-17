package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DemoGraphQL.exception.*;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.*;

import java.util.Collection;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private TaskRepository taskRepository;
    private FormFieldRepository formFieldRepository;
    private GatewayRepository gatewayRepository;
    private SequenceFlowRepository sequenceFlowRepository;

    //Constructors
//    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//    }

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, FormFieldRepository formFieldRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository, TaskRepository taskRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.formFieldRepository = formFieldRepository;
        this.gatewayRepository = gatewayRepository;
        this.sequenceFlowRepository = sequenceFlowRepository;
        this.taskRepository = taskRepository;
    }

    //    public Mutation(TaskRepository taskRepository, FormFieldRepository formFieldRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository) {
//        this.taskRepository = taskRepository;
//        this.formFieldRepository = formFieldRepository;
//        this.gatewayRepository = gatewayRepository;
//        this.sequenceFlowRepository = sequenceFlowRepository;
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

    public FormField newFormField(String name, String fieldType, String defaultFieldValue, String fieldValue, Boolean isRequired){
        FormField formField = new FormField();
        formField.setName(name);
        formField.setFieldType(fieldType);
        formField.setDefaultFieldValue(defaultFieldValue);
        formField.setFieldValue(fieldValue);
        formField.setRequired(isRequired);

        formFieldRepository.save(formField);

        return formField;
    }

    public Gateway newGateway(String type) {
        Gateway gateway = new Gateway();
        gateway.setType(type);

        gatewayRepository.save(gateway);

        return gateway;
    }
//
    public SequenceFlow newSequenceFlow(String sourceId, String expression, String targetId) {
        SequenceFlow sf = new SequenceFlow();
        sf.setExpression(expression);
        sf.setSourceId(sourceId);
        sf.setTargetId(targetId);

        sequenceFlowRepository.save(sf);

        return sf;
    }

    public SequenceFlow newSequenceFlow(String sourceId, String targetId) {
        SequenceFlow sf = new SequenceFlow();
        sf.setSourceId(sourceId);
        sf.setTargetId(targetId);

        sequenceFlowRepository.save(sf);

        return sf;
    }

//    public Task newTask(String name, ArrayList<FormField> ListofFormFields , String className, String classBeanNameReference) {
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

    public Task newTask(String name, Collection<FormField> ListofFormFields , String className, String classBeanNameReference) {
        Task task = new Task();
        task.setName(name);
        task.setClassBeanNameReference(classBeanNameReference);
        task.setClassName(className);
        task.setFormFields(ListofFormFields);

        taskRepository.save(task);

        return task;
    }

    public Task newTask(String name) {
        Task task = new Task();
        task.setName(name);
        taskRepository.save(task);

        return task;
    }

}