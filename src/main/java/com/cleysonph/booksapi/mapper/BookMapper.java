package com.cleysonph.booksapi.mapper;

import com.cleysonph.booksapi.dto.BookDTO;
import com.cleysonph.booksapi.model.Book;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    public static final BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    public abstract Book toBook(BookDTO bookDTO);

}
