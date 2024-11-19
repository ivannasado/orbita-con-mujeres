package com.orbita.orbitaconmujeres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orbita.orbitaconmujeres.model.Board;
import com.orbita.orbitaconmujeres.repository.BoardRepository;

@RestController
@RequestMapping("/api/v1/board")
public class BoardController {


	    final BoardRepository boardRepository;
		


	    public BoardController (@Autowired BoardRepository boardRepository )
	    {
	        this.boardRepository = boardRepository;
	    }

	    @GetMapping
	    public Iterable<Board> getBoard(){
	        return boardRepository.findAll();
	    }
	}

