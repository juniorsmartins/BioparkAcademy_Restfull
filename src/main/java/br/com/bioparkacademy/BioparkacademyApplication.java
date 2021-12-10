package br.com.bioparkacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport // habilita suporte de paginação e ordenação
@EnableCaching // habilita suporte a caching
public class BioparkacademyApplication 
{
	public static void main(String[] args) 
        {SpringApplication.run(BioparkacademyApplication.class, args);}
}
