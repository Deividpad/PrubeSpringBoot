package com.prueba.backend.service;

import java.util.List;

import com.prueba.backend.vo.SociosVo;

public interface SociosService {

	void save(SociosVo sociosVo) ;
	void update(SociosVo sociosVo) ;
	void delete(Integer id);
	SociosVo get(Integer monto);
	List<SociosVo> getAll();

}

