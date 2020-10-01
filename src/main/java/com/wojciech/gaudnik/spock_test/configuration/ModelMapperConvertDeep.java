//package com.wojciech.gaudnik.spock_test.configuration;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//public class ModelMapperConvertDeep {
//
//
//
//	this.modelMapper.createTypeMap(Doctor.class, DoctorResponseDTO.class).setPostConverter(getConverterDoctorIntoDTO());
//
//
//	private Converter<Doctor, DoctorResponseDTO> getConverterDoctorIntoDTO() {
//		Converter<Doctor, DoctorResponseDTO> converter = new Converter<>() {
//			@Override
//			public DoctorResponseDTO convert(MappingContext<Doctor, DoctorResponseDTO> context) {
//				Collection<Calendar> calendars = context.getSource().getCalendars();
//				if(calendars == null) return context.getDestination();
//				context
//						.getDestination()
//						.setCalendarsUUID(calendars
//								.stream()
//								.map(Calendar::getCalendarUUID)
//								.collect(Collectors.toList()));
//				return context.getDestination();
//			}
//		};
//		return converter;
//	}
//
//}
//
