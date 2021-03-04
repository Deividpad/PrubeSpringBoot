package com.prueba.backend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.backend.dao.SociosDao;
import com.prueba.backend.entity.Socios;
import com.prueba.backend.service.SociosService;
import com.prueba.backend.vo.SociosVo;

@Service
public class SociosServiceImpl implements SociosService {

	@Autowired
	SociosDao sociosDao;

	@Override
	@Transactional
	public void save(SociosVo sociosVo) {	
		Integer id = sociosVo.getId();
		Boolean objectAlreadyExists=sociosDao.existsById(id);
		if(!objectAlreadyExists) {
			Socios socios = new Socios();
			BeanUtils.copyProperties(sociosVo, socios);
			sociosDao.save(socios);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(SociosVo sociosVo) {
		Integer id = sociosVo.getId();
		Boolean objectExists=sociosDao.existsById(id);
		if(objectExists) {
			Socios socios = new Socios();
			BeanUtils.copyProperties(sociosVo, socios);
			sociosDao.save(socios);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=sociosDao.existsById(id);
		if(objectExists) {
			sociosDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public SociosVo get(Integer monto) {
		Socios sociosOptional = sociosDao.searchSocio(monto);
		SociosVo sociosVo=null;		
		
		if(sociosOptional != null) {	
			sociosVo = new SociosVo();
			BeanUtils.copyProperties(sociosOptional, sociosVo);
			
			//operación
			Double cuotaMensual = (monto * sociosVo.getTasa() / 100) + (monto / 36);			
			sociosVo.setCuotaMensual(Math.round(cuotaMensual * 100.0) / 100.0);
			Double PagoTotal = cuotaMensual * 36;
			System.out.println(cuotaMensual + " # " + PagoTotal);
			sociosVo.setPagoTotal(Math.round(PagoTotal * 100.0) / 100.0);			
		}else {
			throw new EntityNotFoundException();
		}		
		return sociosVo;
	}

	@Override
	@Transactional
	public List<SociosVo> getAll() {
		List<Socios> sociosList = sociosDao.findAll();
		List<SociosVo> sociosVoList = new ArrayList<>();
		if (sociosList != null && !sociosList.isEmpty()) {
			for (Socios socios : sociosList) {
				SociosVo sociosVo = new SociosVo();
				BeanUtils.copyProperties(socios, sociosVo);
				sociosVoList.add(sociosVo);
			}
		}
		return sociosVoList;
	}

}

