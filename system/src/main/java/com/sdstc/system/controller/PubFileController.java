package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.PubFile;
import com.sdstc.system.service.Oauth2Service;
import com.sdstc.system.service.PubFileService;

@RestController
@RequestMapping("/api/system/pubFile")
public class PubFileController {
	@Autowired
	private PubFileService pubFileService;
	
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(PubFile dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		pubFileService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(PubFile dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		pubFileService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(PubFile dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		pubFileService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		pubFileService.deleteByPK(id,oauth2Service.userInfo().getCustomerId());
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public PubFile selectByPK(Long id) {
		return pubFileService.selectByPK(id,oauth2Service.userInfo().getCustomerId());
	}
	
	@RequestMapping("selectByDto")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<PubFile> selectByDto(PubFile dto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return pubFileService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<PubFile> selectPageByDto(PubFile dto,PageDto pageDto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return pubFileService.selectPageByDto(dto,pageDto);
	}
}