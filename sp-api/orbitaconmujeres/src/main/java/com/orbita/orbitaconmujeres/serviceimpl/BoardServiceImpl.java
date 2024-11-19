package com.orbita.orbitaconmujeres.serviceimpl;


import java.util.Optional;

import org.springframework.stereotype.Service;
import com.orbita.orbitaconmujeres.model.Board;
import com.orbita.orbitaconmujeres.repository.BoardRepository;
import com.orbita.orbitaconmujeres.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	BoardRepository boardRepository;
	
	public BoardServiceImpl(BoardRepository boardRepository) {
	this.boardRepository = boardRepository;
	}

	@Override
	public Board createBoard(Board board) {
		// TODO Verificar si los atributos son válidos
		board.setActive(true); 
		board.setIdBoard(null); 
		Board newBoard = boardRepository.save( board );
		return newBoard;
	}

	@Override
	public Board getBoardById(Long id) {
		Optional<Board> optionalBoard = boardRepository.findById(id);
		if( optionalBoard.isEmpty()) {
			throw new IllegalStateException("Board does not exist with id " + id);
		}
		Board existingBoard = optionalBoard.get();
		return existingBoard;
	}

	@Override
	public Board updateBoard(Board board, Long id) {
		// TODO Auto-generated method stub
		Board existingBoard = getBoardById(id);
		existingBoard.setIdBoard( board.getIdBoard() );
			
		return boardRepository.save(existingBoard);
	}
	
	@Override
	public void deleteBoard(Long id) {
		Board existingBoard = getBoardById(id);
		existingBoard.setActive(false); // desactivar al usuario
		boardRepository.save(existingBoard);
	}
		
}
