package com.exemplo.crud.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResquestProductDTO(Integer id, @NotBlank String name, @NotNull Integer price_in_cents) {

}
