package com.orbita.orbitaconmujeres.service;

import com.orbita.orbitaconmujeres.model.Board;

public interface BoardService {

	Board createBoard(Board board);
	Board getBoardById(Long id);
	Board updateBoard(Board board, Long id);
	void deleteBoard(Long id);
}
