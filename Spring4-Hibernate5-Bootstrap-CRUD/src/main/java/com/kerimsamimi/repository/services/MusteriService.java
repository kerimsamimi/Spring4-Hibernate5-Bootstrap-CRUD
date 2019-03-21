package com.kerimsamimi.repository.services;

import java.util.List;

import com.kerimsamimi.model.Musteri;

public interface MusteriService {
public List<Musteri> findAllMusteri();
	
	public List<Musteri> findMusteriler(String musteriAdi);
	
	public Musteri findMusteri(long musteriId);
	
	public long createMusteri(Musteri musteri);
	
	public Musteri updateMusteri(Musteri musteri);

	public void deleteMusteri(long musteriId);
}
