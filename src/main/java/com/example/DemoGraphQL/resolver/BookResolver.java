package com.example.DemoGraphQL.resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }

}