package com.qianfeng.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qianfeng.dao.ProductListDao;
import com.qianfeng.dao.ProductListDao;
import com.qianfeng.dao.ProductListDao;
import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.ValueBean;
import com.qianfeng.domain.vo.PageBean;

public class ProductListService {

	public List<Product> findAllProduct() throws SQLException {
		// ��ȡ������Ʒ��Ϣ�����ط�װ��allProduct�ļ���
		ProductListDao dao=new ProductListDao();
		List<Product> pList=dao.findAllProduct();
		return pList;
	}
	public void deleteProduct(String pid) throws SQLException {
		ProductListDao dao=new ProductListDao();
		dao.deleteProduct(pid);
		
	}

	public List<Category> showCategoryProduct() throws SQLException {
		ProductListDao dao = new ProductListDao();
		List<Category> cList=dao.showCategoryProduct();
		return cList;
	}

	public void addProduct(Product product) throws SQLException {
		ProductListDao dao=new ProductListDao();
		dao.addProduct(product);
		
	}

	public Product editProduct(String pid) throws SQLException {
		ProductListDao dao = new ProductListDao();
		Product pro=dao.editProduct(pid);
		return pro;
	}

	public void updateProduct(Product product) throws SQLException {
		ProductListDao dao = new ProductListDao();
		dao.updateProduct(product);
		
	}

	public List<Product> searchProduct(ValueBean value) throws SQLException {
		ProductListDao dao = new ProductListDao();
		List<Product> pList=dao.searchProduct(value);
		return pList;
	}

	public PageBean<Product> findProductByPageBean(int currentPageInt, int currentPageCount) throws SQLException {
		ProductListDao dao = new ProductListDao();
		//��ȡÿҳ��Ʒ��Ϣ
		int productIndex = (currentPageInt-1)*currentPageCount;
		List<Product> product=dao.findProductByPageBean(productIndex,currentPageCount);
		//��ȡ������
		Long totalCountLong =dao.findProductTotalCount();
		int totalCount = totalCountLong.intValue();
		//��ȡ��ҳ��
		int totalPage = (int) Math.ceil(totalCount/(currentPageCount*1.0));
		/*System.out.println(totalCount);
		System.out.println(totalPage);*/
		//����ȡ�����ݷ�װ��һ��PageBean�����з���
		PageBean<Product> pageBean = new PageBean<>();
		pageBean.setCurrentPage(currentPageInt);
		pageBean.setCurrentPageCount(currentPageCount);
		pageBean.setPageData(product);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		
		
		return pageBean;
	}
	public PageBean<Product> pageSeacherProduct(List<Product> pList,int currentPageInt,int currentPageCount) {
		int totalPage = (int) Math.ceil(pList.size()/(currentPageCount*1.0));
		int startnum=(currentPageInt-1)*12;
		int endnum=startnum+12;
		List<Product> product=new ArrayList<>();
		for(int i=startnum;i<endnum;i++){
			Product p = pList.get(i);
			product.add(p);
		}
		
		
		PageBean<Product> pageBean = new PageBean<>();
		pageBean.setCurrentPage(currentPageInt);
		pageBean.setCurrentPageCount(currentPageCount);
		pageBean.setPageData(product);
		pageBean.setTotalCount(pList.size());
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

}
