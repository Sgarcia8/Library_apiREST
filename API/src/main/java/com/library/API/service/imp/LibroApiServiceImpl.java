package com.library.API.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.API.dto.LibroApiDTO;
import com.library.API.service.LibroApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibroApiServiceImpl implements LibroApiService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${api.openLibrary.url}")
    private String url;

    @Autowired
    public LibroApiServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public LibroApiDTO getLibroByTitle(String title) {
        String finalURL = url + title +"&fields=title,author_name,first_publish_year";

        // Realiza la solicitud GET a la API openLibrary
        ResponseEntity<String> response = restTemplate.getForEntity(finalURL, String.class);

        try {
            // Deserializamos la respuesta para acceder al campo 'docs'
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            JsonNode docsNode = rootNode.path("docs");

            // Accedemos al primer libro
            if (docsNode.isArray() && !docsNode.isEmpty()) {
                JsonNode libroNode = docsNode.get(0);  // Obtener el primer libro de la lista
                String titleFromApi = libroNode.path("title").asText();
                String authorFromApi = libroNode.path("author_name").get(0).asText();
                int firstPublishYearFromApi = libroNode.path("first_publish_year").asInt();

                // Agregamos un valor manualmente
                return new LibroApiDTO(titleFromApi, authorFromApi, firstPublishYearFromApi, false, "El titulo no se encontro en la base de datos");
            } else {
                throw new RuntimeException("No se encontraron libros");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al deserializar el JSON", e);
        }
    }
}
