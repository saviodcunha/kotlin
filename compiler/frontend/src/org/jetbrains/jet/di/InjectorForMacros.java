/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.jetbrains.jet.di;

import org.jetbrains.jet.lang.types.expressions.ExpressionTypingServices;
import com.intellij.openapi.project.Project;
import org.jetbrains.jet.lang.ModuleConfiguration;
import org.jetbrains.jet.lang.resolve.calls.CallResolver;
import org.jetbrains.jet.lang.resolve.calls.CandidateResolver;
import org.jetbrains.jet.lang.resolve.TypeResolver;
import org.jetbrains.jet.lang.resolve.AnnotationResolver;
import org.jetbrains.jet.lang.resolve.DescriptorResolver;
import org.jetbrains.jet.lang.resolve.QualifiedExpressionResolver;
import org.jetbrains.jet.lang.resolve.calls.results.ResolutionResultsHandler;
import org.jetbrains.jet.lang.resolve.calls.results.OverloadingConflictResolver;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.di.AllInjectorsGenerator. DO NOT EDIT! */
public class InjectorForMacros {

    private ExpressionTypingServices expressionTypingServices;
    private final Project project;
    private final ModuleConfiguration moduleConfiguration;
    private CallResolver callResolver;
    private CandidateResolver candidateResolver;
    private TypeResolver typeResolver;
    private AnnotationResolver annotationResolver;
    private DescriptorResolver descriptorResolver;
    private QualifiedExpressionResolver qualifiedExpressionResolver;
    private ResolutionResultsHandler resolutionResultsHandler;
    private OverloadingConflictResolver overloadingConflictResolver;

    public InjectorForMacros(
        @NotNull Project project,
        @NotNull ModuleConfiguration moduleConfiguration
    ) {
        this.expressionTypingServices = new ExpressionTypingServices();
        this.project = project;
        this.moduleConfiguration = moduleConfiguration;
        this.callResolver = new CallResolver();
        this.candidateResolver = new CandidateResolver();
        this.typeResolver = new TypeResolver();
        this.annotationResolver = new AnnotationResolver();
        this.descriptorResolver = new DescriptorResolver();
        this.qualifiedExpressionResolver = new QualifiedExpressionResolver();
        this.resolutionResultsHandler = new ResolutionResultsHandler();
        this.overloadingConflictResolver = new OverloadingConflictResolver();

        this.expressionTypingServices.setCallResolver(callResolver);
        this.expressionTypingServices.setDescriptorResolver(descriptorResolver);
        this.expressionTypingServices.setProject(project);
        this.expressionTypingServices.setTypeResolver(typeResolver);

        callResolver.setCandidateResolver(candidateResolver);
        callResolver.setExpressionTypingServices(expressionTypingServices);
        callResolver.setResolutionResultsHandler(resolutionResultsHandler);
        callResolver.setTypeResolver(typeResolver);

        candidateResolver.setExpressionTypingServices(expressionTypingServices);
        candidateResolver.setTypeResolver(typeResolver);

        typeResolver.setAnnotationResolver(annotationResolver);
        typeResolver.setDescriptorResolver(descriptorResolver);
        typeResolver.setModuleConfiguration(moduleConfiguration);
        typeResolver.setQualifiedExpressionResolver(qualifiedExpressionResolver);

        annotationResolver.setCallResolver(callResolver);
        annotationResolver.setExpressionTypingServices(expressionTypingServices);

        descriptorResolver.setAnnotationResolver(annotationResolver);
        descriptorResolver.setExpressionTypingServices(expressionTypingServices);
        descriptorResolver.setTypeResolver(typeResolver);

        resolutionResultsHandler.setOverloadingConflictResolver(overloadingConflictResolver);

    }

    @PreDestroy
    public void destroy() {
    }

    public ExpressionTypingServices getExpressionTypingServices() {
        return this.expressionTypingServices;
    }

    public Project getProject() {
        return this.project;
    }

}
