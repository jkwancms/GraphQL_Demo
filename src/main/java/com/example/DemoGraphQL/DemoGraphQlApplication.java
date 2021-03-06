package com.example.DemoGraphQL;

import com.example.DemoGraphQL.exception.GraphQLErrorAdapter;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.*;
import com.example.DemoGraphQL.resolver.BookResolver;
import com.example.DemoGraphQL.resolver.Mutation;
import com.example.DemoGraphQL.resolver.Query;
import com.example.DemoGraphQL.resolver.TaskResolver;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository, FormFieldRepository formFieldRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository, TaskRepository taskRepository) {
		return new Query(authorRepository, bookRepository, formFieldRepository, gatewayRepository, sequenceFlowRepository, taskRepository);
	}

//	@Bean
//	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
//		return new Mutation(authorRepository, bookRepository);
//	}

	@Bean
	public TaskResolver getTaskResolver(FormFieldRepository repository){
		return new TaskResolver(repository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository, FormFieldRepository formFieldRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository, TaskRepository taskRepository) {
		return new Mutation(authorRepository, bookRepository, formFieldRepository, gatewayRepository, sequenceFlowRepository, taskRepository);
	}


	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository, FormFieldRepository formFieldRepository, GatewayRepository gatewayRepository, SequenceFlowRepository sequenceFlowRepository, TaskRepository taskRepository) {
		return (args) -> {
			Author author = new Author("Herbert", "Schildt");
			authorRepository.save(author);

			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));

			//----------------------------------------- CMF -----------------------------------------//
			FormField ff01 = new FormField("Form Field 1","type 01","01","0101",false);
			ArrayList<FormField> tempList = new ArrayList<>();
			tempList.add(ff01);
			formFieldRepository.save(tempList);
			gatewayRepository.save(new Gateway("Exclusive"));
			sequenceFlowRepository.save(new SequenceFlow("123","456"));
			taskRepository.save(new Task("Task 01",tempList,"class 01","Reference 01"));

		};
	}

}
