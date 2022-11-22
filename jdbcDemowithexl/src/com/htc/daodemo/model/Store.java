package com.htc.daodemo.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Store {
	
	String storeId;
	String storeName;
	//Book books[];
    ConcurrentHashMap<String,List<Book>> store_books;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
	
	public Store() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public ConcurrentHashMap<String, List<Book>> getStore_books() {
		return store_books;
	}
	public void setStore_books(ConcurrentHashMap<String, List<Book>> store_books) {
		this.store_books = store_books;
	}
	public Store(String storeId, String storeName) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", store_books=" + store_books + "]";
	}
	
}
