package com.library.API.service;

import com.library.API.dto.LibroApiDTO;

public interface LibroApiService {

    LibroApiDTO getLibroByTitle(String title);
}
