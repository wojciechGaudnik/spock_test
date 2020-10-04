package com.wojciech.gaudnik.spock_test.configuration;

//package pl.com.enigma.centaurdat.admin.configuration;
//
//@Converter(autoApply = true)  //todo this is for DB !!!
//public class CategoryConverter implements AttributeConverter<Category, String> {
//
//	@Override
//	public String convertToDatabaseColumn(Category category) {
//		if (category == null) {
//			return null;
//		}
//		return category.getCode();
//	}
//
//	@Override
//	public Category convertToEntityAttribute(String code) {
//		if (code == null) {
//			return null;
//		}
//
//		return Stream.of(Category.values())
//				.filter(c -> c.getCode().equals(code))
//				.findFirst()
//				.orElseThrow(IllegalArgumentException::new);
//	}
//}
