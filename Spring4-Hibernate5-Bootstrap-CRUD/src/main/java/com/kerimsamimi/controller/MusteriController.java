package com.kerimsamimi.controller;

import java.util.List;


import javax.inject.Inject;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kerimsamimi.model.Musteri;
import com.kerimsamimi.repository.services.MusteriService;



@Controller
public class MusteriController {
	
	@Inject 
	private MusteriService musteriService;
	
	private static final Logger logger= Logger.getLogger(MusteriController.class);
	
	public MusteriController() {
		System.out.println("MusteriController");
	}
	
	@RequestMapping(value="newMusteri", method=RequestMethod.GET)
	public ModelAndView newMusteri(@ModelAttribute Musteri musteri) {
		logger.info("Musteri ekleniyor.Bilgi :" +musteri);
		return new ModelAndView("musteriForm");
	}
	
	@RequestMapping(value="editMusteri", method=RequestMethod.GET)
	public ModelAndView updateMusteri(@RequestParam long id, @ModelAttribute Musteri musteri) {
		logger.info("Musteri duzenleniyor.Id :" +id);
		musteri= musteriService.findMusteri(id);
		return new ModelAndView("musteriForm","MusteriObject",musteri);
	}
	
	@RequestMapping(value="saveMusteri", method=RequestMethod.POST)
	public ModelAndView saveMusteri(@ModelAttribute Musteri musteri) {
		logger.info("Musteri kaydediliyor. :" +musteri);
		if(musteri.getMusteriId()==0) {
			musteriService.createMusteri(musteri);
		}else {
			musteriService.updateMusteri(musteri);
		}
		return new ModelAndView("redirect:findAllMusteri");
	}
	
	//getListAllMusteri
	@RequestMapping(value= {"findAllMusteri","/ListAllMusteri"})
	public ModelAndView findAllMusteri() {
		logger.info("Butun musteriler." );
		List<Musteri> musteriList=musteriService.findAllMusteri();
		
		return new ModelAndView("musteriList","musteriList",musteriList);
	}
	
	@RequestMapping(value="removeMusteri")
	public ModelAndView deleteMusteri(@RequestParam long id) {
		logger.info("Musteri siliniyor. Id :" +id);
		musteriService.deleteMusteri(id);
		return new ModelAndView("redirect:listAllMusteri");
	}
	
	@RequestMapping(value="searchMusteri")
	public ModelAndView searchMusteri(@RequestParam ("searchAdi") String searchAdi) {
		logger.info("Arama Musteri. Musteri isimleri :" +searchAdi);
		List<Musteri> musteriList=musteriService.findMusteriler(searchAdi);
		return new ModelAndView("musteriList","musteriList",musteriList);
	}
	
}
