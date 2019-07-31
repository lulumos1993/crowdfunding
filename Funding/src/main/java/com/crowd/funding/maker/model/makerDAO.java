package com.crowd.funding.maker.model;

public interface makerDAO {
	
	void makerPOST(makerDTO maDTO) throws Exception;
	int idx(int mem_idx) throws Exception;
	int makeridx(int mem_idx) throws Exception;
	makerDTO makerinfo(int mem_idx) throws Exception;
	void makerinfoUP(makerDTO maDTO) throws Exception;
	void makerinfoDEL(makerDTO maDTO) throws Exception;

}
