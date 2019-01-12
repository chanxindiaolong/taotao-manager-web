package com.taotao.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/content/save")
	@ResponseBody()
	public TaotaoResult addContent(TbContent content) {
		TaotaoResult result = contentService.addContent(content);
		return result;
	}
	
	@RequestMapping("/content/query/list")
	@ResponseBody()
	public EasyUIDataGridResult getContentList(@RequestParam(value = "categoryId", defaultValue = "0")Long categoryId ,Integer page,Integer rows){
		return contentService.getContentList(categoryId, page, rows);
	} 
	
	@RequestMapping("/rest/content/edit")
	@ResponseBody()
	public TaotaoResult editContent(TbContent content) {
		TaotaoResult result = contentService.editeContent(content);
		return result;
	}
	
	@RequestMapping("/content/delete")
	@ResponseBody()
	public TaotaoResult removeContent(@RequestParam List<Long> ids) {
		 contentService.removeContent(ids);
		return TaotaoResult.ok();
	}
	
}
