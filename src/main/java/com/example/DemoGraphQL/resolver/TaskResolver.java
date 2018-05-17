package com.example.DemoGraphQL.resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.FormFieldRepository;

public class TaskResolver implements GraphQLResolver<Book> {
    private FormFieldRepository formfieldRepository;

    public TaskResolver(FormFieldRepository formfieldRepository) {
        this.formfieldRepository = formfieldRepository;
    }

   //get method to returns the list of formfields

}