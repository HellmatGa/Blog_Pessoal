package com.generation.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Projeto Blog Pessoal de Hellmat")
						.description("Projeto Blog Pessoal Desenvolvido na Generation Brasil")
						.version("v0.0.1") //Posso alterar toda vez que atualizar para informar oa consumidor da api qual versão ela esta consumindo.
						.license(new License()
								.name("Hellmat Gabriel de Arruda Arújo")
								.url("https://www.linkedin.com/in/hellmatgabriel"))
						.contact(new Contact()
								.name("Hellmat Gabriel")
								.url("")
								.email("Hellmatgabriel@icloud.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Github")
						.url("https://github.com/HellmatGa/Blog_Pessoal"));
		
	}
	
	@Bean
	OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
		
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
					.forEach(operation ->{
						
						ApiResponses apiResponses = operation.getResponses();
						
						apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
						apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
						apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
						apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
						apiResponses.addApiResponse("401", createApiResponse("Acesso não Autorizado!"));
						apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
						apiResponses.addApiResponse("404", createApiResponse("Objeto não Encontrado!"));
						apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
					})
					);
		};
	}
	
	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}
	

	
}
