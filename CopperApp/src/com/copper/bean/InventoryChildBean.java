package com.copper.bean;

import java.io.Serializable;

public class InventoryChildBean implements Serializable {

	String name;
	String description;
	String product_model_number;
	String id;

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getProduct_model_number() {
		return product_model_number;
	}

	public synchronized void setProduct_model_number(String product_model_number) {
		this.product_model_number = product_model_number;
	}

	String vendor_part_number;

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getDescription() {
		return description;
	}

	public synchronized void setDescription(String description) {
		this.description = description;
	}

	public synchronized String getVendor_part_number() {
		return vendor_part_number;
	}

	public synchronized void setVendor_part_number(String vendor_part_number) {
		this.vendor_part_number = vendor_part_number;
	}

	public synchronized String getVendor_name() {
		return vendor_name;
	}

	public synchronized void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public synchronized String getQuantity() {
		return quantity;
	}

	public synchronized void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public synchronized String getUnit_value() {
		return unit_value;
	}

	public synchronized void setUnit_value(String unit_value) {
		this.unit_value = unit_value;
	}

	public synchronized String getValue() {
		return value;
	}

	public synchronized void setValue(String value) {
		this.value = value;
	}

	public synchronized String getVendor_url() {
		return vendor_url;
	}

	public synchronized void setVendor_url(String vendor_url) {
		this.vendor_url = vendor_url;
	}

	public synchronized String getCategory() {
		return category;
	}

	public synchronized void setCategory(String category) {
		this.category = category;
	}

	public synchronized String getLocation() {
		return location;
	}

	public synchronized void setLocation(String location) {
		this.location = location;
	}

	public synchronized String getL_name() {
		return l_name;
	}

	public synchronized void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public synchronized String getL_description() {
		return l_description;
	}

	public synchronized void setL_description(String l_description) {
		this.l_description = l_description;
	}

	public synchronized String getL_product_model() {
		return l_product_model;
	}

	public synchronized void setL_product_model(String l_product_model) {
		this.l_product_model = l_product_model;
	}

	public synchronized String getL_vendor_part() {
		return l_vendor_part;
	}

	public synchronized void setL_vendor_part(String l_vendor_part) {
		this.l_vendor_part = l_vendor_part;
	}

	public synchronized String getL_vendor_name() {
		return l_vendor_name;
	}

	public synchronized void setL_vendor_name(String l_vendor_name) {
		this.l_vendor_name = l_vendor_name;
	}

	public synchronized String getL_quantity() {
		return l_quantity;
	}

	public synchronized void setL_quantity(String l_quantity) {
		this.l_quantity = l_quantity;
	}

	public synchronized String getL_unit() {
		return l_unit;
	}

	public synchronized void setL_unit(String l_unit) {
		this.l_unit = l_unit;
	}

	public synchronized String getL_value() {
		return l_value;
	}

	public synchronized void setL_value(String l_value) {
		this.l_value = l_value;
	}

	public synchronized String getL_vendor_url() {
		return l_vendor_url;
	}

	public synchronized void setL_vendor_url(String l_vendor_url) {
		this.l_vendor_url = l_vendor_url;
	}

	public synchronized String getL_category() {
		return l_category;
	}

	public synchronized void setL_category(String l_category) {
		this.l_category = l_category;
	}

	public synchronized String getL_location() {
		return l_location;
	}

	public synchronized void setL_location(String l_location) {
		this.l_location = l_location;
	}

	public synchronized String getL_image() {
		return l_image;
	}

	public synchronized void setL_image(String l_image) {
		this.l_image = l_image;
	}

	String vendor_name;
	String quantity;
	String unit_value;
	String value;
	String vendor_url;
	String category;
	String location;
	String l_name;
	String l_description;
	String l_product_model;
	String l_vendor_part;
	String l_vendor_name;
	String l_quantity;
	String l_unit;
	String l_value;
	String l_vendor_url;
	String l_category;
	String l_location;
	String l_image;
}
