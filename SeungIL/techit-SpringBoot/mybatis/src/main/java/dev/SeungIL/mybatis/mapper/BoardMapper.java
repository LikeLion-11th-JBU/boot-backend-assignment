package dev.SeungIL.mybatis.mapper;

import dev.SeungIL.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
