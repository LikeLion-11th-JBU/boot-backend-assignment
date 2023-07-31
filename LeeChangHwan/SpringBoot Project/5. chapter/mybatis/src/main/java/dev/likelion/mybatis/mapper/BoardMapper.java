package dev.likelion.mybatis.mapper;

import dev.likelion.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
