package com.example.DemoGraphQL.resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.FormFieldRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class TaskResolver implements GraphQLResolver<Task> {
    private FormFieldRepository formfieldRepository;

    public TaskResolver(FormFieldRepository formfieldRepository) {
        this.formfieldRepository = formfieldRepository;
    }

    public Collection<FormField> getFormFields(Task task){
        return Collections.emptyList();
    }

}