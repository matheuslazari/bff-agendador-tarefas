package com.matheus.bffagendadortarefas.infraestructure.client.config;

import com.matheus.bffagendadortarefas.infraestructure.exceptions.BusinessException;
import com.matheus.bffagendadortarefas.infraestructure.exceptions.ConflictException;
import com.matheus.bffagendadortarefas.infraestructure.exceptions.ResourceNotFoundException;
import com.matheus.bffagendadortarefas.infraestructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()) {
            case 409:
                return new ConflictException("Erro atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
