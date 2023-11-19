package com.daniilbarsuk.webshopapi.dto;

import java.util.Set;

public record BasketDto(Integer id,
                        Set<ItemDto> items) {
}
