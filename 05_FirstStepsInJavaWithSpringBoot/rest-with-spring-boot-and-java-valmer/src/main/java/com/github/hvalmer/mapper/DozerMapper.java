package com.github.hvalmer.mapper;

import java.util.ArrayList;
import java.util.List;

//import org.modelmapper.ModelMapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/*
 * converte VO´s em entidades e
 * entidades em objetos
 */
public class DozerMapper {

	//inicializando o Mapper
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	//inicializando o ModelMapper
	//private static ModelMapper mapper = new ModelMapper();
	
	//para converter em objetos simples
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}

	//para converter listas
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		//criando uma lista de destination
		List<D> destinationObjects = new ArrayList<D>();
		//iterando sobre o objeto de origem, convertendo um por um no objeto de destino
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
}
