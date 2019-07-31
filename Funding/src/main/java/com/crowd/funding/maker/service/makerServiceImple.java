package com.crowd.funding.maker.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crowd.funding.maker.model.makerDAO;
import com.crowd.funding.maker.model.makerDTO;

@Service
public class makerServiceImple implements makerService {

	@Inject
	makerDAO maDAO;
	
	@Override
	public void makerPOST(makerDTO maDTO) throws Exception {
		System.out.println("### makerService : makerPOST ###");
		maDAO.makerPOST(maDTO);
	}
	
	@Override
	public int idx(int mem_idx) throws Exception {
		System.out.println("### makerService : idx ###");
		return maDAO.idx(mem_idx);
	}



	@Override
	public int makeridx(int mem_idx) throws Exception {
		System.out.println("### makerService : makeridx ###");
		return maDAO.makeridx(mem_idx);
	}

	@Override
	public makerDTO makerinfo(int mem_idx) throws Exception {
		System.out.println("### makerService : makerinfo ###");
		return maDAO.makerinfo(mem_idx);
	}
	


	@Override
	public void makerinfoUP(makerDTO maDTO) throws Exception {
		System.out.println("### makerService : makerinfoUP ###");
		maDAO.makerinfoUP(maDTO);
	}

	@Override
	public void makerinfoDEL(makerDTO maDTO) throws Exception {
		System.out.println("### makerService : makerinfoDEL ###");
		maDAO.makerinfoDEL(maDTO);
	}
	
	

}
