package com.kerimsamimi.repository.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kerimsamimi.model.Musteri;
import com.kerimsamimi.repository.dao.MusteriDao;
import com.kerimsamimi.repository.services.MusteriService;

@Service
@Transactional
public class MusteriServiceImpl implements MusteriService {
	
	@Inject //@Autowired
	private MusteriDao musteriDao;
	
	public MusteriServiceImpl() {
		System.out.println("MusteriServiceImpl");
	}

	@Override
	public List<Musteri> findAllMusteri() {
		return musteriDao.findAllMusteri();
	}

	@Override
	public List<Musteri> findMusteriler(String musteriAdi) {
		return musteriDao.findMusteriler(musteriAdi);
	}

	@Override
	public Musteri findMusteri(long musteriId) {
		return musteriDao.findMusteri(musteriId);
	}

	@Override
	public long createMusteri(Musteri musteri) {
		return musteriDao.createMusteri(musteri);
	}

	@Override
	public Musteri updateMusteri(Musteri musteri) {
		return musteriDao.updateMusteri(musteri);
	}

	@Override
	public void deleteMusteri(long musteriId) {
		musteriDao.deleteMusteri(musteriId);
	}

}
