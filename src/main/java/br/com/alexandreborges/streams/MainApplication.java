package br.com.alexandreborges.streams;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MainApplication.class, args);
		
		if(args.length != 1) {
			System.out.println("Argumento de busca obrigatório!");
			System.exit(-1);
		}
		
		long time = System.currentTimeMillis();
		
		grep(args[0]);
		
		time = System.currentTimeMillis() - time;
		
		System.out.println(String.format("Tempo de execucao: %s milisegundos", time));
	}

	final static void grep(String pattern) throws IOException {

		final File sampleCsv = new File("src/test/resources/Data7602DescendingYearOrder.csv");
		
		final Path caminho = Paths.get(sampleCsv.toURI());

		Files.lines(caminho, StandardCharsets.ISO_8859_1)
			.parallel()
			
			.map(linha -> { 
				
				return linha.contains(pattern) ? linha : "";
				
			})
			
			.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			
			.forEach((k, v) -> System.out.println(v + "\t" + k));
	}

}
