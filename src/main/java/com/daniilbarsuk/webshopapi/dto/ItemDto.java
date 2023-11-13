package com.daniilbarsuk.webshopapi.dto;

import java.io.Serializable;

public record ItemDto(Integer id,
                      String name,
                      int price) implements Serializable {
}
