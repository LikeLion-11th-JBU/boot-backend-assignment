package jym.yeongmu.mybatis.mapper;

import jym.yeongmu.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
