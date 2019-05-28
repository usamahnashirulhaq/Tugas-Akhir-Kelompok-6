package com.apap.TA.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.TA.model.StokLabModel;
import com.apap.TA.repository.StokLabDb;


@Service
@Transactional
public class StokLabServiceImpl implements StokLabService {
	@Autowired
	private StokLabDb stokLabDb;

	@Override
	public StokLabModel addStok(StokLabModel stok) {
		return stokLabDb.save(stok);
	}
	
	@Override
	public List<StokLabModel> getAllStokLab (){
		return stokLabDb.findAll();
	}
	
	@Override
	public Optional<StokLabModel> getDetail (Long id){
		return stokLabDb.findById(id);
	}


}

