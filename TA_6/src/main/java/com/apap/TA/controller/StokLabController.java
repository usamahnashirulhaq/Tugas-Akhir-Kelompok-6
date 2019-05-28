package com.apap.TA.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.TA.model.StokLabModel;

import com.apap.TA.service.StokLabService;


@Controller
public class StokLabController {

	@Autowired
	private StokLabService stokLabService;
	
	
    @RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("stok", new StokLabModel());
        return "add-stok";
    }
    
    @RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.POST)
    private String addStokSubmit(@ModelAttribute StokLabModel stok) {
        stokLabService.addStok(stok);
        return "add";
    
    }
    @RequestMapping(value = "/lab/stok", method = RequestMethod.GET)
    private String view(Model model) {
        List<StokLabModel> archiveStok = stokLabService.getAllStokLab();
        
        model.addAttribute("listStok", archiveStok);
        return "view-stok";
    }
    
    @RequestMapping(value = "/lab/stok/ubah/{id}", method = RequestMethod.GET)
    private String update(@PathVariable(value = "id") Long id, Model model) {
    	System.out.println(id);
        StokLabModel archive = stokLabService.getDetail(id).get();
        model.addAttribute("stok", archive);
        return "update-stok";
    }

    @RequestMapping(value = "/lab/stok/ubah", method = RequestMethod.POST)
    private String updateStokLab(@ModelAttribute StokLabModel stok, Model model) {
        stokLabService.addStok(stok);
        return "update";
    }


}