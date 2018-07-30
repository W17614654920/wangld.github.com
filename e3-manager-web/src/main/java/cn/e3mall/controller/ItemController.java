package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**
 * 商品管理Controller
 * 
 * @author wld
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 根据商品id，返回商品的Json对象
	 * 
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	/**
	 * 分页查询所有商品
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		// 调用服务查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	/**
	 * 商品的添加功能
	 * 
	 * @param item
	 * @param desc
	 * @return
	 */
	@RequestMapping(value = "/item/save", method = RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(TbItem item, String desc) {
		E3Result result = itemService.addItem(item, desc);
		return result;
	}

	/**
	 * 商品的删除
	 * 
	 * @param ids
	 * @param item
	 * @return
	 */
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public E3Result deleteItem(@RequestParam Long ids, TbItem item) {
		E3Result result = itemService.deleteItem(item, ids);
		return result;
	}

	/**
	 * 回显商品描述(修改)
	 * 
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	public E3Result getItemDesc(@PathVariable long itemId) {
		System.out.println(itemId);
		// itemService.getItemById(itemId);
		return null;
	}

	/**
	 * 回显商品信息(修改)
	 * 
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/rest/item/param/item/query/{itemId}")
	@ResponseBody
	public E3Result getItemInfo(@PathVariable long itemId) {
		System.out.println(itemId);
		// itemService.getItemById(itemId);
		return null;
	}
}
