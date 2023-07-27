package dev.park.mybatis.mybatis.mapper;

import dev.park.mybatis.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
