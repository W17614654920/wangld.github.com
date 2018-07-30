package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;

/**
 * 内容分类管理Controller
 * 
 * @author wld
 */
@Controller
public class ContentCatController {

	@Autowired
	private ContentCategoryService contentCategoryService;

	/**
	 * 查询节点列表Controller
	 * 
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryLsit(@RequestParam(name = "id", defaultValue = "0") long parentId) {
		List<EasyUITreeNode> contentCatList = contentCategoryService.getContentCatList(parentId);
		return contentCatList;
	}

	/**
	 * 添加分类节点Controller
	 * 
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
	@ResponseBody
	public E3Result createContentCategory(long parentId, String name) {
		E3Result e3Result = contentCategoryService.addContentCategory(parentId, name);
		return e3Result;
	}

}
