package com.exemplo.crud.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResquestProductDTO(@NotBlank String name, @NotNull Integer price_in_cents) {

}
