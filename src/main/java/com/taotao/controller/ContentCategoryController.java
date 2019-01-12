package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;

@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") long parentId) {
		List<EasyUITreeNode> resultList = contentCategoryService.getContentCategoryList(parentId);
		return resultList;
	}

	@RequestMapping("/content/category/create")
	@ResponseBody
	public TaotaoResult addContentCategory(Long parentId, String name) {
		TaotaoResult result = contentCategoryService.addContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping("/content/category/update")
	@ResponseBody
	public void updateContentCategory(Long id,String name){
		contentCategoryService.updateCategory(id, name);
	}
	
	@RequestMapping("/content/category/delete")
	@ResponseBody
	public void removeContentCategory(Long id) {
		contentCategoryService.removeCategory(id);
	}
	
}
